package com.csi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class ApplicationController {
	
	@RequestMapping
	public String sayWelcome(ModelMap map) {
		map.addAttribute("message", "WELCOME TO GREAT LEARNING INDIA");
		
		return "welcome";
	}
	
	@RequestMapping(value = "/services", method = RequestMethod.GET)
	public String sayServices(ModelMap map) {
		map.addAttribute("message", "SOFTWARE DEVELOPMENT SERVICES");
		
		return "welcome";
	}
	
	@RequestMapping(value = "/address", method = RequestMethod.GET)
	public String sayAddress(ModelMap map) {
		map.addAttribute("message", "PUNE | INDIA");
		
		return "welcome";
	}
	
	@RequestMapping(value = "/glindia", method = RequestMethod.GET)
	public String sayGLIndiaServices(ModelMap map) {
		map.addAttribute("message", "FULL STACK DEVELOPMENT");
		
		return "welcome";
	}
	

}
