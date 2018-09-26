package com.example.demo.com.example.demo.controller;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PageController {
	@RequestMapping("/viral")
	public String viral() {
		return "viral";
	}
	
	@RequestMapping("/challenge")
	public String challenge(@RequestParam(value = "name", required = false) String name, Model model) {
		model.addAttribute("name", name);
		return "challenge";
	}
	
	@RequestMapping("/challenge/{name}")
	public String challengePath(@PathVariable Optional<String> name, Model model) {
		if (name.isPresent()) {
			model.addAttribute("name", name.get());
		} else {
			model.addAttribute("name", "KB");
		}
		return "challenge";
	}
	
	@RequestMapping("/generator")
	public String challenge(@RequestParam(value="a", required=false, defaultValue="0") int a, 
		@RequestParam(value="b", required=false, defaultValue="0") int b, Model model) {
		
		String result = "";
		String temp = "h";
		
		if (a==0 || a==1) {
			temp += "m";
		} else {
			for (int i = 0; i < a; i++) {
				temp += "m";
			}
		}
		
		if (b == 0 || b == 1) {
			result += temp;
		} else {
			result += temp;
			for (int i = 0; i < b-1; i++) {
				result += (" " + temp);  
			}
		}
		
		model.addAttribute("a", a);
		model.addAttribute("b", b);
		model.addAttribute("result", result);
		
		return "generator";
	}
}
