package com.web.app.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.web.app.entity.Employee;
import com.web.app.entity.UserInfo;
import com.web.app.service.EmployeeService;
import com.web.app.service.UserInfoService;





@Controller
public class MyController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@Autowired
	private UserInfoService userInfoService; 
	
	
	@RequestMapping("/all")
	public String showAllEmployees(Model model) {
		List<Employee> allEmployess = employeeService.getAllEmployees();
		
		model.addAttribute("allEmployees", allEmployess);
		
		return "all-employees";
	}
	
	
	@RequestMapping("/users")
	public String showAllUsersInfo(Model model) {
		
		List<UserInfo> infos = userInfoService.getAllUserInfo();
		
		model.addAttribute("infos", infos);
		model.addAttribute("number", 0);
		
		return "users-info";
	}
	
	@GetMapping("/addNewUser")
	public String addUser(Model model) {
		
		UserInfo userInfo = new UserInfo();
		model.addAttribute("userInfo", userInfo);
		
		return "add-user";
	}
	
	@PostMapping("/saveUser")
	public String saveNewUser(
			@ModelAttribute("userInfo") UserInfo userInfo,
			@RequestParam("img") MultipartFile file,
			Model model) {
		
		
		String name = null;

		if (!file.isEmpty()) {
			try {
				byte[] bytes = file.getBytes();

				name = file.getOriginalFilename();

				String rootPath = "C:\\Users\\Sheva\\eclipse-workspace\\test_web_app\\src\\main\\webapp";  
//				System.getProperty("catalina.home");
				File dir = new File(rootPath + File.separator + "loadFiles");

				if (!dir.exists()) {
					dir.mkdirs();
				}

				File uploadedFile = new File(dir.getAbsolutePath() + File.separator + name);

				BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(uploadedFile));
				stream.write(bytes);
				stream.flush();
				stream.close();
//				model.addAttribute("uploadedFile", dir.getAbsolutePath() + File.separator + name);

			} catch (Exception e) {
//				return "You failed to upload " + name + " => " + e.getMessage();
			}
		} else {
//			return "You failed to upload " + name + " because the file was empty.";
		};
		
		userInfo.setImgUrl("loadFiles/" + name);
		
		userInfoService.saveUserInfo(userInfo);
		
		
//		model.addAttribute("name", name);
//		model.addAttribute("userInfo", userInfo);
//		model.addAttribute("fileName", file.getOriginalFilename());
		
		
		
//		return "test";
		return "redirect:/users";
	}
	
	
	@GetMapping("/chenge")
	public String chengeUserInfo(@RequestParam("userInfoId") int id, Model model) {
		
		model.addAttribute("userInfo", userInfoService.getUserInfoById(id));
		
		return "add-user";
	}
	
	
}
