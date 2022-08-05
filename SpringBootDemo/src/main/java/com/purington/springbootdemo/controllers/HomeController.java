package com.purington.springbootdemo.controllers;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	@RequestMapping("/")
	public String index(Model model) {
		model.addAttribute("firstName", "Patrick");
		model.addAttribute("lastName", "Purington");
		return "index.jsp";
	}
	
//	@RequestMapping("/pizza/{number}")
//	public String pizza(@PathVariable("number") int number) {
//		return "I like pizza this much x " + number;
//	}
	
	// ...
    @RequestMapping("/dojos")
    public String dojos(Model model) {
        ArrayList<String> dojos = new ArrayList<String>();
        dojos.add("Burbank");
        dojos.add("Chicago");
        dojos.add("Bellevue");
        model.addAttribute("dojosFromMyController", dojos);
        return "index.jsp";
    }
// ...


}
