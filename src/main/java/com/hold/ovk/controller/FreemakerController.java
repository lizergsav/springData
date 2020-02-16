package com.hold.ovk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.hold.ovk.repository.TemporaryRegistrationRepository;

@Controller
public class FreemakerController {

	@Autowired
	private TemporaryRegistrationRepository registration;
	
	@GetMapping({"/","sms"})
	public String getSms(Model model) {
		model.addAttribute("registrations",registration.findAll());
		return "sms";
	}
	
}
