package com.csi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class ApplicationController {
	
	@GetMapping
	public String sayWelcome() {
		return "WELCOME TO GREAT LEARNING";
	}
	
	@GetMapping("/services")
	public String sayServices() {
		return "FULL STACK DEVELOPMENT";
	}

}
