package com.jl.spring;

import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jl.spring.data.DBUser;
import com.jl.spring.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		
		return "/home/homeuser";
	}
	
	@RequestMapping(value="/list", method=RequestMethod.GET)
	public String userList(Model model) {
			List<DBUser> users = userService.getAllUsers(null, null);
			model.addAttribute("users",users);
		return "/admin/listusers";
	}
	
}
