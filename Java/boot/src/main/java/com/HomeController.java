package com;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/home")
public class HomeController {

	
	// /home/hell?msg=abc
	@RequestMapping("/hello")
	public String sayHello(@RequestParam("msg") String msg) {
		
		System.out.println("HomeController.sayHello() " + msg);
		return "index";
	}
}
