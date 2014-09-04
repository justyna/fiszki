
package com.jl.spring;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.jl.spring.data.DBUser;
import com.jl.spring.form.RemindPasswordValidator;
import com.jl.spring.form.TestForm;
import com.jl.spring.service.MailService;
import com.jl.spring.service.UserService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private MailService mailService;
	
	/**
	 * 
	 * @return
	 */
	@RequestMapping(value = { "/", "/welcome**" }, method = RequestMethod.GET)
	//public ModelAndView defaultPage() {
	public String defaultPagr() {

	/*	ModelAndView model = new ModelAndView();
		model.addObject("title", "Spring Security + Hibernate Example");
		model.addObject("message", "This is default page!");
		model.setViewName("hello");
		return model;*/
		return "/home/homeanonymous";

	}
	/**
	 * 
	 * @return
	 */
	@RequestMapping(value = "/admin**", method = RequestMethod.GET)
	public ModelAndView adminPage() {

		ModelAndView model = new ModelAndView();
		model.addObject("title", "Spring Security + Hibernate Example");
		model.addObject("message", "This page is for ROLE_ADMIN only!");
		model.setViewName("admin");

		return model;

	}
	
	/**
	 * 
	 * @param error
	 * @param logout
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login(@RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "logout", required = false) String logout, HttpServletRequest request) {

		ModelAndView model = new ModelAndView();
		if (error != null) {
			model.addObject("error", getErrorMessage(request, "SPRING_SECURITY_LAST_EXCEPTION"));
		}

		if (logout != null) {
			model.addObject("message", "You've been logged out successfully.");
		}
		model.setViewName("login");

		return model;

	}

	/**
	 * 
	 * @param request
	 * @param key
	 * @return
	 */
	// customize the error message
	private String getErrorMessage(HttpServletRequest request, String key) {

		Exception exception = (Exception) request.getSession().getAttribute(key);

		String error = "";
		if (exception instanceof BadCredentialsException) {
			error = "Invalid username and password!";
		} else if (exception instanceof LockedException) {
			error = exception.getMessage();
		} else {
			error = "Invalid username and password!";
		}

		return error;
	}

	// for 403 access denied page
	/**
	 * 
	 * @return
	 */
	@RequestMapping(value = "/403", method = RequestMethod.GET)
	public ModelAndView accesssDenied() {

		ModelAndView model = new ModelAndView();

		// check if user is login
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (!(auth instanceof AnonymousAuthenticationToken)) {
			UserDetails userDetail = (UserDetails) auth.getPrincipal();
			System.out.println(userDetail);

			model.addObject("username", userDetail.getUsername());

		}

		model.setViewName("403");
		return model;

	}
	
	@RequestMapping(value="/remind")
	public String remindPassword(Model model) {
		RemindPasswordValidator remindPasswordValidator = new RemindPasswordValidator();
		model.addAttribute("remindPasswordValidator", remindPasswordValidator);
		return "/user/remindpassword";
	}
	
	@RequestMapping(value="/send")
	public String sendPassword(@Valid RemindPasswordValidator remindPasswordValidator,
			BindingResult result, Model model) {
		
		if(result.hasErrors()){
			return "/user/remindpassword";
		}
		DBUser user = userService.findUserByEmail(result.getFieldValue("email").toString());
		
		if(user == null){
			model.addAttribute("message", "<b>U¿ytkownik o podanym adresie email nie istnieje lub nie jest aktywny</b>");
		} else {
			model.addAttribute("message", "<b>Na podany adres wys³ano email z has³em</b>");
			mailService.sendMail(user.getEmail(), user.getPass());
		}
		return "/user/remindpassword";
	}
	
	@RequestMapping(value="/logout")
	public String logout(Model model) {
		return "/logout";
	}
	
}
