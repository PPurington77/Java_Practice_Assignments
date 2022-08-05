package com.purington.hellohuman;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	
	@RequestMapping("/")
	public String index(@RequestParam(value="q", required=false) String firstName) {
		if(firstName == null) {
			return "Hello Human";
		}
		else {return "Hello " + firstName;}
	}
}
