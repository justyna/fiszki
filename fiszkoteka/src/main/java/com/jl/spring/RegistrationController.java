package com.jl.spring;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jl.spring.data.DBUser;
import com.jl.spring.service.UserService;
import com.jl.spring.validator.RegisterValidator;
import com.jl.spring.validator.RegistrationValidation;


@Controller
@RequestMapping("/register")
public class RegistrationController {
	
	
	@Autowired
	private RegistrationValidation rv;
	@Autowired
	private UserService  userService;


	public void setRv(RegistrationValidation rv) {
		this.rv = rv;
	}
	
	/**
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET)
	public String showRegistration(Map model) {
		RegisterValidator registerValidator = new RegisterValidator();
		model.put("register", registerValidator);
		return "/user/register";
		
	}

	/**
	 * 
	 * @param registerValidator
	 * @param result
	 * @param model
	 * @return
	 */
	@RequestMapping(method = RequestMethod.POST)
	public String processRegistration(@Valid RegisterValidator registerValidator, BindingResult result, Model model) {
		rv.validate(registerValidator, result);
		
		if(result.hasErrors()) {
			return "/user/register";
		}
		model.addAttribute("email", result.getFieldValue("email"));
		model.addAttribute("password", result.getFieldValue("password"));
		DBUser user = new DBUser();
		user.setRoleUser("ROLE_USER");
		user.setEmail(result.getFieldValue("email").toString());
		user.setPass(result.getFieldValue("password").toString());
		user.setDeleted(false);
		userService.addUser(user);
		return "/user/registersuccess";
		
	}

}
