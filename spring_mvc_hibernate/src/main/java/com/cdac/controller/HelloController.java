package com.cdac.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {

	public HelloController() {
		// TODO Auto-generated constructor stub
		System.out.println("in ctor of "+ getClass());
	}

	@RequestMapping("/") //mandatory method level annotation to declare
	// req handling method : equivalent to service(rq,rs)
	public String renderWelcomePage() {
		System.out.println("in render welcome page ....");
		return "index";
	}
}
