package com.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/home")
public class HomeController {

	//http://localhost:8080/mvcspring/spring/home
	@RequestMapping
	public String handleRequest() {
		
		System.out.println("HomeController.handleRequest()");
		return "index";
	}
	
	//http://localhost:8080/mvcspring/spring/home/message?msg=abc
	
	//@RequestMapping(value = "/message", method = {RequestMethod.GET, RequestMethod.POST})
	@GetMapping("/message")
	public ModelAndView handleMessageRequest(@RequestParam("msg") String message, HttpServletResponse response) {
	
		System.out.println("HomeController.handleMessageRequest(): " + message);
		String fMessage = "Hello " + message;
		Cookie cookie = new Cookie("fMsgCookie", "Welcome:" + message);
		response.addCookie(cookie);
		System.out.println("HomeController.handleMessageRequest() saved cookie");
		return new ModelAndView("index", "formattedMessage", fMessage);
	}
	
	@GetMapping("/readcookie")
	public String handleCookieValue(@CookieValue("fMsgCookie") String msgCookie, Model model) {
		
		System.out.println("HomeController.handleCookieValue():" + msgCookie);
		model.addAttribute("msgCookie", msgCookie);
		return "index";
	}
	
}












