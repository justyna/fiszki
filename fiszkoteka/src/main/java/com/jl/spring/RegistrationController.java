package com.jl.spring;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jl.spring.data.DBUser;
import com.jl.spring.form.RegisterValidator;
import com.jl.spring.form.RegistrationValidation;
import com.jl.spring.service.UserService;


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
	public String showRegistration(Model model) {
		RegisterValidator register = new RegisterValidator();
		model.addAttribute("register", register);
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
	public String processRegistration(@Valid RegisterValidator register, BindingResult result, Model model) {
		rv.validate(register, result);
		
		if(result.hasErrors()) {
			System.out.println("èLE"+ result.getErrorCount());
			model.addAttribute("register", register);
			
			
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
