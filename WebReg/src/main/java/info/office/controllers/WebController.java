package info.office.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebController {
	
	@GetMapping(value="/about")
	public String About() {
		return "aboutPage";
	}
	
	@GetMapping("/certificates")
	public String Certificates() {
		return "certificatesPage";
	}
	
	@GetMapping("/contact")
	public String Contact() {
		return "contactPage";
	}
	
	@GetMapping({"/home","/"})
	public String ShowMainPage() {
		return "main-menu";
	}
	
	@GetMapping("/registerForm")
	public String Register() {
		return "register-form";
	}
	

}
