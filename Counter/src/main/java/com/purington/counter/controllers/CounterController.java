package com.purington.counter.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CounterController {
	
	@RequestMapping("/")
	public String index(HttpSession session, Model model) {
		if(session.getAttribute("count") == null) {
			session.setAttribute("count", 0);
		}
		else {
			Integer counting = (Integer) session.getAttribute("count");
			counting++;
			session.setAttribute("count", counting);
		}
		return "index.jsp";
	}
	
	@RequestMapping("/counter")
	public  String counter(HttpSession session, Model model, HttpServletRequest request) {
		Integer counting = 0;
		if(session.getAttribute("count") == null) {
			return "index.jsp";
		}
		else {
			counting = (Integer) session.getAttribute("count");
		}
		//gets the url of this page i.e. localhost:8080/counter
		String indexUrl = request.getRequestURL().toString();
		model.addAttribute("count", counting);
		//removes the last 8 characters from index url to match localhost:8080
		model.addAttribute("home", indexUrl.substring(0, indexUrl.length() - 8));
		return "Counter.jsp";
	}
	
}
