package com.jl.spring;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.validation.Valid;

import org.apache.commons.io.FileUtils;
import org.eclipse.jetty.plus.jaas.callback.RequestParameterCallback;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.ServletContextAware;
import org.springframework.web.multipart.MultipartFile;

import com.jl.spring.data.DBCard;
import com.jl.spring.form.CardValidator;
import com.jl.spring.form.TestForm;
import com.jl.spring.form.TestValidator;
import com.jl.spring.service.CardService;
import com.jl.spring.service.TestService;

@Controller
@RequestMapping("card")
public class CardController implements ServletContextAware {

	private ServletContext servletContext;

	@Autowired(required = true)
	@Resource(name = "cardService")
	private CardService cardService;

	@Autowired
	private TestService testService;

	@Autowired
	private TestValidator tv;

	/**
	 * 
	 * @param cardValidator
	 * @param result
	 * @param model
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/add")
	public String cardadd(@Valid CardValidator cardValidator,
			BindingResult result, Model model, @RequestParam int id) {
		DBCard cardDB = new DBCard();
		model.addAttribute("card", cardDB);
		model.addAttribute("id", id);
		if (result.hasErrors()) {
			return "/card/addcard";
		}

		Integer cardID = null;
		cardDB.setWord(cardValidator.getWord());
		cardDB.setTranslation(cardValidator.getTranslation());
		cardDB.setDefinition(cardValidator.getDefinition());
		cardDB.setLangword(cardValidator.getLangword());
		cardDB.setLangtranslation(cardValidator.getLangtranslation());
		// cardDB.setMp3file(cardValidator.getMp3file());
		// cardDB.setPicture(cardValidator.getPicture());

		cardID = cardService.addCard(cardDB, id);
		model.addAttribute("message", "Successfully saved card: "
				+ cardValidator.toString());

		return "card/successCard";
	}

	/**
	 * 
	 * @param cardValidator
	 * @param result
	 * @param model
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/addform"/* , method = RequestMethod.POST */)
	public String cardpadd(
			@Valid CardValidator cardValidator,
			BindingResult result,
			Model model,
			@RequestParam int id,
			@RequestParam(value = "image", required = false) MultipartFile image,
			@RequestParam(value = "mp3file", required = false) MultipartFile mp3file) {
		DBCard cardDB = new DBCard();
		model.addAttribute("card", cardDB);
		if (result.hasErrors()) {
			System.err.println(result.getErrorCount());
			model.addAttribute("id", id);
			return "/card/addcard";

		}

		Integer cardID = null;
		String imagePath = null;
		String mp3Path = null;
		cardDB.setWord(cardValidator.getWord());
		cardDB.setTranslation(cardValidator.getTranslation());
		cardDB.setDefinition(cardValidator.getDefinition());
		cardDB.setLangword(cardValidator.getLangword());
		cardDB.setLangtranslation(cardValidator.getLangtranslation());
		// cardDB.setMp3file(cardValidator.getMp3file());
		// cardDB.setPicture(cardValidator.getPicture());
		// System.out.println(cardDB.getMp3file());
		// System.out.println(cardDB.getWord());

		cardID = cardService.addCard(cardDB, id);
		if (!image.isEmpty()) {
			try {
				validateImage(image);
			} catch (RuntimeException re) {
				result.reject(re.getMessage());
			}
			try {
				imagePath = saveFile(cardID + ".jpg", image);

			} catch (IOException e) {
				imagePath = null;
				result.reject(e.getMessage());
			}

		}

		if (!mp3file.isEmpty()) {

			try {
				validateMp3(mp3file);
			} catch (RuntimeException re) {
				result.reject(re.getMessage());
			}

			try {
				mp3Path = saveFile(cardID + ".mp3", mp3file);
			} catch (IOException e) {
				mp3Path = null;
				result.reject(e.getMessage());
			}

		}

		cardDB.setPicture(imagePath);
		cardDB.setMp3file(mp3Path);

		cardService.updateCard(cardDB);
		model.addAttribute("message", "Successfully saved card: "
				+ cardValidator.toString());

		return "/card/successCard";
	}

	/**
	 * 
	 * @param model
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/edit")
	public String editCard(Model model, @RequestParam int id) {
		DBCard card = cardService.findCardById(id);
		model.addAttribute("card", card);
		return "/card/editcard";
	}

	/**
	 * 
	 * @param model
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/show")
	public String showCard(Model model, @RequestParam int id) {
		DBCard card = cardService.findCardById(id);
		model.addAttribute("card", card);
		return "/card/showcard";
	}

	/**
	 * 
	 * @param model
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/deleteconfirmation")
	public String deleteConfirmCard(Model model, @RequestParam int id) {
		model.addAttribute("id", id);
		return "/card/deletecard";
	}

	/**
	 * 
	 * @param model
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/cancel")
	public String cancelDeleteCard(Model model, @RequestParam int id) {
		DBCard card = cardService.findCardById(id);
		Integer bundleId = card.getBundles().getIdBundle();
		return "redirect:/card/list?id=" + bundleId;

	}

	/**
	 * 
	 * @param model
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/delete")
	public String deleteCard(Model model, @RequestParam int id) {
		DBCard card = cardService.findCardById(id);
		Integer bundleId = card.getBundles().getIdBundle();
		cardService.deleteCard(card);
		return "redirect:/card/list?id=" + bundleId;
	}

	/**
	 * 
	 * @param model
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/list")
	public String listCard(Model model, @RequestParam int id,
			@RequestParam String type) {
		List<DBCard> cards = cardService.findByBundleId(id, null, null);
		model.addAttribute("id", id);

		model.addAttribute("cards", cards);
		System.out.println(type);
		if (type == "pub") {
			// przeglπdaj fiszki jako publiczne
			return "/card/publiccardlist";
		} else {
			// przeglπdaj fiszki jako prywatne
			return "/card/cardlist";
		}

	}

	@RequestMapping(value = "/test")
	public String testCard(Model model, @RequestParam int id) {
		DBCard card = testService.chooseCard(id);
		TestForm testValidator = new TestForm();
		testValidator.setIdCard(card.getIdcard());
		testValidator.setQuestion(card.getTranslation());
		// testValidator.setCorrectAnswer(card.getWord());
		model.addAttribute("testValidator", testValidator);
		model.addAttribute("id", id);
		return "/card/testcard";
	}

	@RequestMapping(value = "/checkanswer")
	public String checkCard(@Valid TestForm testValidator,
			BindingResult result, Model model, @RequestParam int id) {
		// tv.validate(testValidator, result);
		System.out.println(testValidator.getQuestion());
		model.addAttribute("id", id);
		/*
		 * if(result.hasErrors()){
		 * //testValidator.setQuestion(result.getFieldValue
		 * ("question").toString()); model.addAttribute("testValidator",
		 * testValidator);
		 * 
		 * System.out.println("èLE"); return "/card/testcard"; }
		 */
		System.out.println(result.getFieldValue("idCard"));
		System.out.println("DOBRZE");
		String answer = result.getFieldValue("answer").toString();
		Integer idCard = Integer.valueOf(result.getFieldValue("idCard")
				.toString());
		// boolean ifCorrect = testService.checkAnswer(idCard, answer);
		DBCard card = cardService.findCardById(idCard);
		if (card.getWord().toLowerCase().equals(answer.toLowerCase())) {
			testService.updateResult(idCard, 1);
			model.addAttribute("message", "Odpowiedü <b>" + answer
					+ "</b> jest poprawna.");
		} else {
			testService.updateResult(idCard, -1);
			model.addAttribute("message",
					"Odpowiedü poprawna to <b>" + card.getWord() + "</b>");
		}

		return "/card/checkanswer";
	}

	@RequestMapping(value = "/confirmleave")
	public String confirmleave(Model model, @RequestParam int id) {
		model.addAttribute("id", id);
		return "/card/confirm";
	}

	private String saveFile(String filename, MultipartFile image)
			throws RuntimeException, IOException {

		try {
			File file = new File(servletContext.getRealPath("/")
					+ File.separator + "resources" + File.separator + "data"
					+ File.separator + filename);

			FileUtils.writeByteArrayToFile(file, image.getBytes());
			System.out
					.println("Go to the location:  "
							+ file.toString()
							+ " on your computer and verify that the image has been stored.");
			String path = file.getCanonicalPath();
			// String rpath = path.replace("\\", "/");
			System.err.println(path);
			return filename;
		} catch (IOException e) {
			throw e;
		}

	}

	private void validateImage(MultipartFile image) {
		if (!image.getContentType().equals("image/jpeg")) {
			throw new RuntimeException("Tylko pliki JPG sπ akceptowane");
		}
	}

	private void validateMp3(MultipartFile mp3) {
		if (!mp3.getContentType().equals("audio/mpeg")) {
			throw new RuntimeException("Tylko pliki mp3 sπ akceptowane");
		}
		// System.out.println("MP3 : "+mp3.getContentType());
	}

	@Override
	public void setServletContext(ServletContext servletContext) {
		this.servletContext = servletContext;

	}

}
