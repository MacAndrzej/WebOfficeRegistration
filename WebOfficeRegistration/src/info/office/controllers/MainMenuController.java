package info.office.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class MainMenuController {

	@RequestMapping(value="/")
	public String Majn() {
		return "main-menu";
	}
}
