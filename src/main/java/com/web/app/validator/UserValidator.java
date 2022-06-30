package com.web.app.validator;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.web.app.entity.User;
import com.web.app.service.UserService;

@Component
public class UserValidator implements Validator{

	@Autowired
	private UserService userService;
	
	
	
	
	@Override
	public boolean supports(Class<?> clazz) {
	
		return User.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		
		User user = (User) target;

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "","Поле обязательно к заполнению.");
		
		if (user.getUsername().length()<3 || user.getUsername().length() > 20) {
			errors.rejectValue("username", "","Поле должно содержать более 3 и менее 20 символов");
		}
		
		if (userService.findByUsernameValidator(user.getUsername()) != null) {
			errors.rejectValue("username", "","Пользователь уже существует!");
		}
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "", "Поле обязательно к заполнению.");
		
		if (user.getPassword().length() < 6 || user.getPassword().length() > 20) {
			errors.rejectValue("password", "", "Поле должно содержать более 6 и менее 20 символов");
		}
		
		if (!user.getConfirmPassword().equals(user.getPassword())) {
			errors.rejectValue("confirmPassword", "", "Не верный пароль!");
		}
		
		
	}

	
}
