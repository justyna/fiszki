package com.jl.spring;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jl.spring.data.DBGrade;
import com.jl.spring.data.DBGroup;
import com.jl.spring.data.DBUser;
import com.jl.spring.service.GradeService;
import com.jl.spring.service.UserService;
import com.jl.spring.validator.GradeValidator;
import com.jl.spring.validator.GroupValidator;

@Controller
@RequestMapping("grade")
public class GradeController {

	@Autowired
	private UserService userService;

	@Autowired
	private GradeService gradeService;

	/**
	 * 
	 * @param model
	 * @param gradeValidator
	 * @param result
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "add")
	public String addGrade(Model model, @Valid GradeValidator gradeValidator,
			BindingResult result, @RequestParam int id) {

		if (result.hasErrors()) {
			model.addAttribute("grade", new DBGrade());
			model.addAttribute("id", id);
			return "grade/add";
		} else {
			DBUser user = userService.findUserById(id);
			DBGrade grade = new DBGrade();
			grade.setForwhat(result.getFieldValue("forwhat").toString());
			grade.setGrade(Integer.valueOf(result.getFieldValue("grade")
					.toString()));
			grade.setUsers(user);
			gradeService.addGrade(grade);
			return "redirect:grade/list";

		}

	}

	/**
	 * 
	 * @param model
	 * @param id
	 * @param gradeValidator
	 * @param result
	 * @return
	 */
	@RequestMapping(value = "edit")
	public String editGrade(Model model, @RequestParam int id,
			@Valid GradeValidator gradeValidator, BindingResult result) {

		DBGrade grade = gradeService.findGradeById(id);
		model.addAttribute("grade", grade);
		model.addAttribute("id", id);

		if (result.hasErrors()) {
			return "grade/edit";
		} else {
			grade.setForwhat(result.getFieldValue("forwhat").toString());
			grade.setGrade(Integer.valueOf((result.getFieldValue("grade")
					.toString())));
			gradeService.updateGrade(grade);
			return "redirect:grade/list";
		}

	}

	/**
	 * 
	 * @param model
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "delete")
	public @ResponseBody
	String deleteGrade(Model model, @RequestParam int id) {
		// TODO ulepszyc
		DBGrade grade = gradeService.findGradeById(id);

		gradeService.deleteGrade(grade);

		return "";
	}

	/**
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "mine")
	public String myGrade(Model model) {

		return null;
	}

	/**
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "list")
	public String listGrade(Model model) {
		return null;
	}

	/**
	 * 
	 * @param model
	 * @param id
	 * @param gid
	 * @return
	 */
	@RequestMapping(value = "show")
	public String showGrade(Model model, @RequestParam int id,
			@RequestParam int gid) {
		// System.out.println("Parametr id1 " + gid);
		List<DBGrade> grades = gradeService.findGradeByUserIdGroupId(id, gid);
		System.out.println(grades);
		model.addAttribute("grades", grades);
		model.addAttribute("groupId", gid);
		return "grade/list";

	}

}
