package info.office.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoggedUserController {
	
	@GetMapping("/loggedUser")
	private String showForLoggedUser() {
		return "logged-user";
	}

}
