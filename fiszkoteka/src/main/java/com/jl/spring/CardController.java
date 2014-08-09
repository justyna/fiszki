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
import com.jl.spring.service.CardService;
import com.jl.spring.validator.CardValidator;

@Controller
@RequestMapping("card")
public class CardController {

	@Autowired(required=true)
	@Resource(name = "cardService")
	private CardService cardService;
	
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String cardadd(@Valid CardValidator cardValidator, BindingResult result, Model model, @RequestParam int id) {
		DBCard cardDB =new DBCard();
		model.addAttribute("card", cardDB);
		if(result.hasErrors()) {
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
        model.addAttribute("message", "Successfully saved card: " + cardValidator.toString());
		
		
		return "card/successCard";
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String cardpadd(@Valid CardValidator cardValidator, BindingResult result, Model model, @RequestParam int id) {
		DBCard cardDB =new DBCard();
		model.addAttribute("card", cardDB);
		if(result.hasErrors()) {
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
        model.addAttribute("message", "Successfully saved card: " + cardValidator.toString());
		
		
		return "/card/successCard";
	}
	
	@RequestMapping(value="/edit")
	public String editCard(Model model, @RequestParam int id) {
		DBCard card = cardService.findCardById(id);
		model.addAttribute("card", card);
		return "/card/editcard";
	}
	
	@RequestMapping(value="/show")
	public String showCard(Model model, @RequestParam int id) {
		DBCard card = cardService.findCardById(id);
		model.addAttribute("card", card);
		return "/card/showcard";
	}
	
	@RequestMapping(value="/deleteconfirmation")
	public String deleteConfirmCard(Model model, @RequestParam int id){
		model.addAttribute("id", id);
		return "/card/deletecard";
	}
	
	@RequestMapping(value="/cancel")
	public String cancelDeleteCard(Model model, @RequestParam int id){
		DBCard card = cardService.findCardById(id);
		Integer bundleId = card.getBundles().getIdBundle();
		return "redirect:/card/list?id="+bundleId;
		
	}
	
	@RequestMapping(value="/delete")
	public String deleteCard(Model model, @RequestParam int id){
		DBCard card = cardService.findCardById(id);
		Integer bundleId = card.getBundles().getIdBundle();
		cardService.deleteCard(card);
		return "redirect:/card/list?id="+bundleId;
	}
	
	@RequestMapping(value="/list")
	public String listCard (Model model, @RequestParam int id) {
		List<DBCard> cards = cardService.findByBundleId(id, null, null);
		model.addAttribute("id", id);
		model.addAttribute("cards", cards);
		return "/card/cardlist";
	}
}
