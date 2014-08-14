package com.jl.spring;

import java.util.List;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.jl.spring.data.DBBundle;
import com.jl.spring.service.BundleService;
import com.jl.spring.service.CardService;
import com.jl.spring.service.UserService;
import com.jl.spring.util.VISIBLE;
import com.jl.spring.validator.BundleValidator;
import com.jl.spring.validator.SearchValidator;

@Controller
@RequestMapping("bundle")
public class BundleController {

	@Autowired
	private BundleService bundleService;

	@Autowired
	private UserService userService;

	@Autowired
	private CardService cardService;

	/**
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String bundleList(Model model) {
		List<DBBundle> bundles = bundleService.getAllPublicBundles();
		SearchValidator searchValidator = new SearchValidator();
		model.addAttribute("search", searchValidator);
		model.addAttribute("bundles", bundles);
		return "/bundle/bundlelist";
	}

	/**
	 * 
	 * @param bundleValidator
	 * @param result
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/add")
	public String addBundlePost(@Valid BundleValidator bundleValidator,
			BindingResult result, Model model) {

		DBBundle bundle = new DBBundle();
		model.addAttribute("bundle", bundle);
		model.addAttribute("visible", VISIBLE.values());
		if (result.hasErrors()) {

			model.addAttribute("message", result.getFieldErrors().toString());
			return "/bundle/addbundle";

		} else {
			Authentication auth = SecurityContextHolder.getContext()
					.getAuthentication();
			UserDetails userDetail = (UserDetails) auth.getPrincipal();

			Integer id = (Integer) userService.findUserByEmail(
					userDetail.getUsername()).getIdUser();
			System.out.println("TAK "
					+ result.getFieldValue("visible").toString().equals("TAK"));
			int idBundle = bundleService.add(id, result.getFieldValue("name")
					.toString(), result.getFieldValue("visible").toString()
					.equals("TAK") ? true : false);

			return "redirect:listbundle";
		}
	}

	/**
	 * 
	 * @param bundleValidator
	 * @param result
	 * @param model
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/edit")
	public String editBundle(@Valid BundleValidator bundleValidator,
			BindingResult result, Model model, @RequestParam int id) {
		DBBundle bundle = bundleService.findBundleById(id);
		model.addAttribute("bundle", bundle);
		model.addAttribute("visible", VISIBLE.values());
		if (result.hasErrors()) {
			return "bundle/editbundle";
		} else {
			bundle.setNameBundle(result.getFieldValue("name").toString());
			bundle.setVisible(result.getFieldValue("visible").toString()
					.equals("TAK") ? true : false);
			bundleService.update(bundle);
			return "redirect:listbundle";
		}

	}

	/**
	 * 
	 * @param model
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/delete")
	public String deleteBundle(Model model, @RequestParam int id) {

		bundleService.deleted(id);
		return "redirect:listbundle";
	}

	/**
	 * 
	 * @param model
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/reallydelete")
	public String deleteConfirmationBundle(Model model, @RequestParam int id) {

		model.addAttribute("id", id);
		return "bundle/deletebundle";
	}

	/**
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/listbundle")
	public String listById(Model model) {
		Authentication auth = SecurityContextHolder.getContext()
				.getAuthentication();
		UserDetails userDetail = (UserDetails) auth.getPrincipal();

		Integer id = (Integer) userService.findUserByEmail(
				userDetail.getUsername()).getIdUser();

		List<DBBundle> bundles = bundleService.findByUserId(id, null, null);
		SearchValidator searchValidator = new SearchValidator();
		model.addAttribute("search", searchValidator);
		model.addAttribute("bundles", bundles);

		return "/bundle/mybundlelist";
	}

	/**
	 * 
	 * @param searchValidator
	 * @param result
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/searchOwn", method = RequestMethod.POST)
	public String searchBundlePost(@Valid SearchValidator searchValidator,
			BindingResult result, Model model) {
		// Pobranie id zalogowanego u¿ytkownika
		Authentication auth = SecurityContextHolder.getContext()
				.getAuthentication();

		UserDetails userDetail = (UserDetails) auth.getPrincipal();

		Integer id = (Integer) userService.findUserByEmail(
				userDetail.getUsername()).getIdUser();

		List<DBBundle> bundles = bundleService.findByUserIdBundleName(id,
				searchValidator.getSearchText(), null, null);
		searchValidator.setSearchText("");
		model.addAttribute("search", searchValidator);
		model.addAttribute("bundles", bundles);
		return "/bundle/bundlelist";
	}

	/**
	 * 
	 * @param modele
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/copy")
	public String copyBundle(Model modele, @RequestParam int id) {
		// Pobranie id zalogowanego u¿ytkownika
		Authentication auth = SecurityContextHolder.getContext()
				.getAuthentication();

		UserDetails userDetail = (UserDetails) auth.getPrincipal();

		Integer idUser = (Integer) userService.findUserByEmail(
				userDetail.getUsername()).getIdUser();
		DBBundle bundle = bundleService.findBundleById(id);
		cardService.copyCardList(bundle, idUser);
		return null;
	}

}
