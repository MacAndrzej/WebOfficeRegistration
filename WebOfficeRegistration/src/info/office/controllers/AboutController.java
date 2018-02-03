package info.office.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class AboutController {
	
	@GetMapping(value="/about")
	public String About() {
		return "aboutPage";
	}
}
