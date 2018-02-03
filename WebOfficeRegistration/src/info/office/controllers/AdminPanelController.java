package info.office.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import info.office.entity.Parent;
import info.office.service.ParentService;

@Controller
@RequestMapping("/admin")
public class AdminPanelController {

	// @RequestMapping(value="/forVisits", method=RequestMethod.GET)
	// public String AdminPanelVisits() {
	// return "adminPanelVisitPage";
	// }

	@Autowired
	private ParentService parentService;

	@GetMapping("/forParent")
	public String listParents(Model theModel) {

		List<Parent> theParents = parentService.getParents();

		theModel.addAttribute("parents", theParents);

		return "list-parents";
	}

	// @RequestMapping(value="/forChild", method=RequestMethod.GET)
	// public String AdminPanelChild() {
	// return "adminPanelChildPage";
	// }

}
