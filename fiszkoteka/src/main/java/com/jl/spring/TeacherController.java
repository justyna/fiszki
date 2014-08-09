package com.jl.spring;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/teacher")
public class TeacherController {
	
	@RequestMapping(value = "home", method =  RequestMethod.GET)
	public String home (Model model) {
		return "/home/hometeacher";
	}
	

}
