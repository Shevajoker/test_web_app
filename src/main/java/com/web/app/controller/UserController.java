package com.web.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.web.app.entity.User;
import com.web.app.service.SecurityService;
import com.web.app.service.UserService;
import com.web.app.validator.UserValidator;


@Controller
public class UserController {

	@Autowired
	private UserService userService;

	@Autowired
	private SecurityService securityService;

	@Autowired
	private UserValidator 
	validator;

	@GetMapping("/registration")
	public String registration(Model model) {

		model.addAttribute("userForm", new User());

		return "registration";
	}

	@PostMapping("/registration")
	public String registration(@ModelAttribute("userForm") User user, 
			BindingResult bindingResult,
			Model model) {
		


		validator.validate(user, bindingResult);

		if (bindingResult.hasErrors()) {
			return "/registration";
		}

		userService.save(user);

		securityService.autoLogin(user.getUsername(), user.getPassword());

		return "redirect:/info";
	}

	@GetMapping("/login")
	public String login(Model model, String error, String logout) {

		if (error != null) {
			model.addAttribute("error", "Не верное имя пользователя или пароль!");
		}

		if (logout != null) {
			model.addAttribute("message", "Вы успешно вышли из аккаунта.");
		}

		return "login";
	}

	@GetMapping("/")
	public String indexPage (Model model) {
		
		return "redirect:/info";
	}
	
	@GetMapping("/admin")
	public String admin (Model model) {
		return "admin";
	}
	
}
