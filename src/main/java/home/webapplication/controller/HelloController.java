package home.webapplication.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController{
	@RequestMapping("/")
	public String printWelcome(ModelMap model) {
		model.addAttribute("greeting", "Welcome to CRUD web application!");
		model.addAttribute("tagline", "My first application!!!");
		return "hello";
	}
}
