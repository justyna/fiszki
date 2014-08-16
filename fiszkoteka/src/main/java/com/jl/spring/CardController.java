package com.jl.spring;

import java.util.List;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.eclipse.jetty.plus.jaas.callback.RequestParameterCallback;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.jl.spring.data.DBCard;
import com.jl.spring.form.CardForm;
import com.jl.spring.service.CardService;
import com.jl.spring.service.TestService;

@Controller
@RequestMapping("card")
public class CardController {

	@Autowired(required = true)
	@Resource(name = "cardService")
	private CardService cardService;
	
	@Autowired
	private TestService testService;

	/**
	 * 
	 * @param cardValidator
	 * @param result
	 * @param model
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String cardadd(@Valid CardForm cardValidator,
			BindingResult result, Model model, @RequestParam int id) {
		DBCard cardDB = new DBCard();
		model.addAttribute("card", cardDB);
		if (result.hasErrors()) {
			return "/card/addcard";
		}

		Integer cardID = null;
		cardDB.setWord(cardValidator.getWord());
		cardDB.setTranslation(cardValidator.getTranslation());
		cardDB.setDefinition(cardValidator.getDefinition());
		cardDB.setLangword(cardValidator.getLangword());
		cardDB.setLangtranslation(cardValidator.getLangtranslation());
		cardDB.setMp3file(cardValidator.getMp3file());
		cardDB.setPicture(cardValidator.getPicture());

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
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String cardpadd(@Valid CardForm cardValidator,
			BindingResult result, Model model, @RequestParam int id) {
		DBCard cardDB = new DBCard();
		model.addAttribute("card", cardDB);
		if (result.hasErrors()) {
			return "/card/addcard";
		}

		Integer cardID = null;
		cardDB.setWord(cardValidator.getWord());
		cardDB.setTranslation(cardValidator.getTranslation());
		cardDB.setDefinition(cardValidator.getDefinition());
		cardDB.setLangword(cardValidator.getLangword());
		cardDB.setLangtranslation(cardValidator.getLangtranslation());
		cardDB.setMp3file(cardValidator.getMp3file());
		cardDB.setPicture(cardValidator.getPicture());
		System.out.println(cardDB.getMp3file());
		System.out.println(cardDB.getWord());

		cardID = cardService.addCard(cardDB, id);
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
			// przegl¹daj fiszki jako publiczne
			return "/card/publiccardlist";
		} else {
			// przegl¹daj fiszki jako prywatne
			return "/card/cardlist";
		}

	}

	@RequestMapping(value = "/test")
	public String testCard(Model model, @RequestParam int id) {
		DBCard card = testService.chooseCard(id);
		model.addAttribute("card", card);
		return null;
	}

	/*
	 * @RequestMapping(value="/publiclist") public String publiclistCard(Model
	 * model, @RequestParam int id){ List<DBCard> cards =
	 * cardService.findByBundleId(id, null, null); model.addAttribute("id", id);
	 * model.addAttribute("cards", cards); return "/card/publiccardlist"; }
	 */
}
