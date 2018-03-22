package info.office.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class LoginController {
	
	@GetMapping("/login")
	private String showMyLoginPage() {
		return "login-form";
	}

	@GetMapping("/access-denied")
	private String showAccessDenied() {
		return "access-denied";
	}
	
}
