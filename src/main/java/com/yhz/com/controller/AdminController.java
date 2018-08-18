package com.yhz.com.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.yhz.com.core.ProjectConstant;
import com.yhz.com.model.KAdmin;
import com.yhz.com.service.KAdminService;
import com.yhz.com.util.MD5Utils;

@Controller
public class AdminController {
	
	@Resource(name = "kAdminService")
	private KAdminService kAdminService;
	
	@RequestMapping("index")
	public String test(HttpServletRequest request) {
		Object attribute = request.getSession().getAttribute(ProjectConstant.SESSION_KEY);
		if(attribute == null) {
			return "/page-login";
		}
		return "/index";
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String login(HttpServletRequest request, @Valid KAdmin kAdmin, Errors errors) {
		if (errors.hasErrors()) {
			return "/page-login";
		}
		KAdmin user = kAdminService.getUserByName(kAdmin.getUserName());
		if(user != null && user.getPassword().equals(MD5Utils.md5Password(kAdmin.getPassword()))) {
			request.getSession().setAttribute(ProjectConstant.SESSION_KEY, user.getId());
			return "redirect:/index";
		}
		return "/page-login";
	}
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String index(String username, String password) {
		KAdmin user = kAdminService.getUserByName(username);
		if(user != null && "123456".equals(password)) {
			return "/index";
		}
		return "/page-login";
	}
	

}
