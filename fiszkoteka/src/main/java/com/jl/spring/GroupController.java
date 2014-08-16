package com.jl.spring;

import java.util.List;

import javax.validation.Valid;

import org.neo4j.cypher.internal.compiler.v2_1.ast.rewriters.addUniquenessPredicates;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.jl.spring.data.DBGroup;
import com.jl.spring.data.DBUser;
import com.jl.spring.form.GroupForm;
import com.jl.spring.service.GroupService;
import com.jl.spring.service.UserGroupService;
import com.jl.spring.service.UserService;

@Controller
@RequestMapping("group")
public class GroupController {

	@Autowired
	private GroupService groupService;

	@Autowired
	private UserGroupService ugService;

	@Autowired
	private UserService userService;

	/**
	 * 
	 * @param model
	 * @param groupValidator
	 * @param result
	 * @return
	 */
	@RequestMapping(value = "add", method = RequestMethod.GET)
	public String addGroupGet(Model model,
			@Valid GroupForm groupValidator, BindingResult result) {

		if (result.hasErrors()) {
			model.addAttribute("group", new DBGroup());
			model.addAttribute("message", result.getFieldValue("namegroups"));
		} else {
			Authentication auth = SecurityContextHolder.getContext()
					.getAuthentication();
			UserDetails userDetail = (UserDetails) auth.getPrincipal();
			DBUser user = userService.findUserByEmail(userDetail.getUsername());

			DBGroup group = new DBGroup();
			group.setNamegroups(result.getFieldValue("namegroups").toString());

			groupService.addGroup(group);
			ugService.addUserGroup(user, group);

			model.addAttribute("group", new DBGroup());
			model.addAttribute("message", "Dodano now¹ grupê");
		}

		return "/group/addgroup";
	}

	/**
	 * 
	 * @param model
	 * @param groupValidator
	 * @param result
	 * @return
	 */
	@RequestMapping(value = "add", method = RequestMethod.POST)
	public String addGroupPost(Model model,
			@Valid GroupForm groupValidator, BindingResult result) {
		if (result.hasErrors()) {
			model.addAttribute("group", new DBGroup());
			model.addAttribute("message", result.getFieldValue("namegroups"));

		} else {
			// Pobranie id zalogowanego u¿ytkownika
			Authentication auth = SecurityContextHolder.getContext()
					.getAuthentication();
			UserDetails userDetail = (UserDetails) auth.getPrincipal();
			DBUser user = userService.findUserByEmail(userDetail.getUsername());

			DBGroup group = new DBGroup();
			group.setNamegroups(result.getFieldValue("namegroups").toString());

			groupService.addGroup(group);
			ugService.addUserGroup(user, group);

			model.addAttribute("group", new DBGroup());
			model.addAttribute("message", "Dodano now¹ grupê");

		}
		return "group/addgroup";
	}

	/**
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "list")
	public String listGroup(Model model) {

		List<DBGroup> groups = groupService.findGroupByIdUser(null, null, null);
		model.addAttribute("groups", groups);

		return "group/grouplist";
	}

	/**
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "mylist")
	public String listGroupByUser(Model model) {
		Authentication auth = SecurityContextHolder.getContext()
				.getAuthentication();
		UserDetails userDetail = (UserDetails) auth.getPrincipal();

		Integer idUser = (Integer) userService.findUserByEmail(
				userDetail.getUsername()).getIdUser();

		List<DBGroup> groups = groupService.findGroupByIdUser(idUser, null,
				null);
		model.addAttribute("groups", groups);
		if (userDetail.getAuthorities().toArray()[0].toString().equals(
				"ROLE_USER")) {

			System.out.println(userDetail.getAuthorities().toArray()[0]
					.toString());
			return "group/userlist";
		} else {
			System.out.println(userDetail.getAuthorities().toArray()[0]
					.toString());
			return "group/teacherlist";
		}
	}

	/**
	 * 
	 * @param model
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "enroll")
	public String enrollToGroup(Model model, @RequestParam int id) {
		// pobranie danych o zalogowanym u¿ytkowniku
		Authentication auth = SecurityContextHolder.getContext()
				.getAuthentication();
		UserDetails userDetail = (UserDetails) auth.getPrincipal();

		DBUser user = userService.findUserByEmail(userDetail.getUsername());
		DBGroup group = groupService.findGroupByIdGroup(id);
		ugService.addUserGroup(user, group);
		// model.addAttribute("message", "Zapisa³eœ siê do grupy" +
		// group.getNamegroups());

		return "redirect:mylist";
	}

	/**
	 * 
	 * @param model
	 * @param groupValidator
	 * @param result
	 * @return
	 */
	@RequestMapping(value = "editname")
	public String editnamePost(Model model,
			@Valid GroupForm groupValidator, BindingResult result) {
		if (result.hasErrors()) {

		} else {

		}
		return null;
	}

	/**
	 * 
	 * @param model
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "withdraw")
	public String delete(Model model, @RequestParam int id) {
		Authentication auth = SecurityContextHolder.getContext()
				.getAuthentication();
		UserDetails userDetail = (UserDetails) auth.getPrincipal();

		DBUser user = userService.findUserByEmail(userDetail.getUsername());

		return "redirect:mylist";
	}

	/**
	 * 
	 * @param model
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "users")
	public String users(Model model, @RequestParam int id) {
		List<DBUser> users = ugService.findUsers(id);
		model.addAttribute("users", users);
		model.addAttribute("groupId", id);
		return "group/listofusers";
	}

}
