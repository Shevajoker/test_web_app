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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;


import com.web.app.entity.People;
import com.web.app.service.PeopleService;
import com.web.app.service.SecurityService;





@Controller
public class PeopleController {
	
	
	
	@Autowired
	private PeopleService peopleService; 
	
	
	
	
	
	
	@RequestMapping("/info")
	public String showAllPeople(Model model) {
		
		List<People> peoples = peopleService.getAllPeople();
		
		model.addAttribute("infos", peoples);
		model.addAttribute("number", 0);
		
		return "people-info";
	}
	
	@GetMapping("/addNewPeople")
	public String addPeople(Model model) {
		
		People people = new People();
		model.addAttribute("peopleInfo", people);
		
		return "people-add";
	}
	
	@PostMapping("/savePeople")
	public String saveNewPeople(
			@ModelAttribute("peopleInfo") People people,
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
		
		people.setImgUrl("loadFiles/" + name);
		
		peopleService.savePeople(people);

		return "redirect:/info";
	}
	
	
	@GetMapping("/chenge")
	public String chengePeople(@RequestParam("peopleId") int id, Model model) {
		
		model.addAttribute("peopleInfo", peopleService.getPeopleById(id));
		
		return "people-add";
	}
	
	@GetMapping("/delete")
	public String deletePeople(@RequestParam("peopleId") int id) {
		
		peopleService.deletePeople(id);
		
		return "redirect:/info";
	}
	
	
}
