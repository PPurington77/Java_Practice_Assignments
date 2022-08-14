package com.purington.authentication.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.purington.authentication.models.LoginUser;
import com.purington.authentication.models.User;
import com.purington.authentication.services.UserService;

@Controller
public class HomeController {
    
    // Add once service is implemented:
     @Autowired
     private UserService userService;
    
//     public String index(@ModelAttribute("newUser" )User newUser, @ModelAttribute("newLogin")LoginUser newLogin) this is the exact same as below
    @GetMapping("/")
    public String index(Model model, HttpSession session) {
    	
    	//checks it user is already logged in
    	if(session.getAttribute("uuid") != null) {
    		return "redirect:/home";
    	}
    	
        // Bind empty User and LoginUser objects to the JSP
        // to capture the form input
        model.addAttribute("newUser", new User());
        model.addAttribute("newLogin", new LoginUser());
        return "index.jsp";
    }
    
    @PostMapping("/register")
    public String register(@Valid @ModelAttribute("newUser") User newUser, 
            BindingResult result, Model model, HttpSession session) {
        
    	User user =  userService.register(newUser, result);
    	
    	if(result.hasErrors()) {
    		model.addAttribute("newLogin", new LoginUser());
    		
    		return "index.jsp";
    	}
    	
    	session.setAttribute("uuid", user.getId());

    
        return "redirect:/home";
    }
    
    @PostMapping("/login")
    public String login(@Valid @ModelAttribute("newLogin") LoginUser newLogin, 
            BindingResult result, Model model, HttpSession session) {
        
        User user = userService.login(newLogin, result);
    
        if(result.hasErrors()) {
            model.addAttribute("newUser", new User());
            
            return "index.jsp";
        }
    
        session.setAttribute("uuid", user.getId());
    
        return "redirect:/home";
    }
    
    @GetMapping("/logout")
    public String logout(HttpSession session) {
    	session.removeAttribute("uuid");
    	
    	return "redirect:/";
    }
    
    @GetMapping("/home")
    public String home(HttpSession session, Model model) {
    	
    	//check if there is a user in session
    	if(session.getAttribute("uuid") == null) {
    		return "redirect:/";
    	}
    	
    	Long userId = (Long) session.getAttribute("uuid");
    	model.addAttribute("user", userService.getOne(userId));
    	
    	return "home.jsp";
    }
}
