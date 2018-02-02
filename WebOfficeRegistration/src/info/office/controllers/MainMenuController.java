package info.office.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainMenuController {

	@RequestMapping(value="/", method=RequestMethod.GET)
	public String Majn() {
		return "main-menu";
	}
}
