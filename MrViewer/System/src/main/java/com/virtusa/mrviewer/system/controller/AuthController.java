package com.virtusa.mrviewer.system.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.virtusa.mrviewer.system.dto.UserDTO;
import com.virtusa.mrviewer.system.service.IUserService;

@Controller
public class AuthController {

	@Autowired
	private IUserService userService;
	
	@GetMapping("/")
	@ResponseBody
	public String ffkas() {
		return "Home";
	}
	
	@GetMapping("/user/signup")
	public String signupForm(Model model) {
		model.addAttribute("user", new UserDTO());
		return "registrationForm";
	}

	@PostMapping("/user/signup")
	public String signup(@Valid @ModelAttribute UserDTO dto, BindingResult result, Model model) {
		if(result.hasErrors()) {
			System.out.println("BindingResult ERROR!!!");
			result.getAllErrors().stream().forEach(e->System.out.println(e.getDefaultMessage()));
			model.addAttribute("user", dto);
			return "registrationForm";
		}
		try {
			userService.addUser(dto);
			return "redirect:/";
		}catch(RuntimeException exception) {
			exception.printStackTrace();
			result.rejectValue("email", "Duplicate entry", "User already exists with this email");
			model.addAttribute("user", dto);			
			return "registrationForm";
		}
	}
	
	// TEST
	
	@GetMapping("/user/home")
	@ResponseBody
	public String home() {
		return "HomePage";
	}
	
	@GetMapping("/admin/home")
	@ResponseBody
	public String adminHome() {
		return "Admin Home";
	}
}
