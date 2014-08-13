package com.jl.spring;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.tags.Param;

import com.jl.spring.data.DBUser;
import com.jl.spring.service.UserService;
import com.jl.spring.util.ROLE;
import com.jl.spring.validator.UserValidator;

@Controller
@RequestMapping(value="/admin")
public class AdminController {
	
	@Autowired
	private UserService userService;
	
	//Strona glowna
	@RequestMapping(value="home", method= RequestMethod.GET)
	public String home (Model model) {
		//pobranie wszystkich uzytkownikow
		List<DBUser> users = userService.getAllUsers(null, null);
		//przekazanie ich do widoku
		model.addAttribute("users",users);
		//przekierowanie do widoku
		return "/home/homeadmin";
		
	}

	@RequestMapping(value="edit")
	public String edit (Model model, @RequestParam int id) {
		//pobranie wybranego uzytkowanika
		DBUser user = userService.findUserById(id);
		//dodanie go do widoku
		model.addAttribute("user", user);
		//przekazanie listy rol do widoku enum z ROLES znajduje sie w pakiecie com.jl.spring.util
		model.addAttribute("role", ROLE.values());
		//przekierowanie do widoku
		return "/admin/edituser";
		
	}
	
	@RequestMapping(value="editform", params="ok",   method=RequestMethod.POST)
	public String editOK(Model model, @Valid UserValidator userValidator, BindingResult result, HttpServletRequest request) {
		
		//Pobranie id u¿ytkownika
		
		Integer id = Integer.valueOf(request.getParameter("idUser"));
		//Walidacja formularza
		if(result.hasErrors()){
			DBUser user = userService.findUserById(id);
			model.addAttribute("user", user);
			model.addAttribute("role", ROLE.values());
			return "/admin/edituser";
		} else {
		
			model.addAttribute("message", "Zaaktualizowano dane u¿ytkownika");
			return "redirect:/admin/home";
		}
	}
	//Anulowania edycji u¿ytkownika
	@RequestMapping(value="editform", params="cancel", method=RequestMethod.POST)
	public String editCancel(Model model) {
		return "redirect:/admin/home";
	}
	//Usuwanie u¿ytkownika
	@RequestMapping(value="delete")
	public String delete (Model model, @RequestParam int id) {
		//Znalezienie u¿ytkownika po id
		DBUser user = userService.findUserById(id);
		model.addAttribute("user", user);
		return "/admin/deleteuser";
	}
	//Anulowanie usuwania u¿ytkownika
	@RequestMapping(value="cancel")
	public String cancel(Model model) {
		//Przekierowanie do strony g³ównej
		return "redirect:/home/homeadmin";
	}
	//Usuniêcie u¿ytkownika
	@RequestMapping(value="ok")
	public String ok(Model model, @RequestParam int id) {
		//Usuniêcie u¿ytkownika
		userService.deleteUser(id);
		//Przekierowanie do strony g³ównej
		return "redirect:/home/homeadmin";
	}
}
