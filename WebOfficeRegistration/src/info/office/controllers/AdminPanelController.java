package info.office.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import info.office.entity.Child;
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

	@GetMapping("/listParents")
	public String listParents(Model theModel) {

		List<Parent> theParents = parentService.getParents();

		theModel.addAttribute("parents", theParents);

		return "list-parents";
	}
	
	@GetMapping("/listChildren")
	public String listChildren(Model theModel) {
		
//		List<Child> theChild= childService.getChildren();
		
		return "list-children";
	}

	@GetMapping("/showFormForAddParent")
	public String showFormForAddParent(Model theModel) {

		Parent theParent = new Parent();

		theModel.addAttribute("parents", theParent);

		return "parent-form";
	}

	@PostMapping("/saveParent")
	public String saveParent(@ModelAttribute("parents") Parent theParent) {

		parentService.saveParent(theParent);

		return "redirect:/admin/listParents";
	}

	@GetMapping("/showFormForUpdateParent")
	public String updateParent(@RequestParam("parentId") long theId, Model theModel) {

		Parent theParent = parentService.getParent(theId);

		theModel.addAttribute("parents", theParent);

		return "parent-form";
	}
	
	@GetMapping("/deleteParent")
	public String delete(@RequestParam("parentId") long theId) {
		
		parentService.deleteParent(theId);
		
		return "redirect:/admin/listParents";
	}
	

	// @RequestMapping(value="/forChild", method=RequestMethod.GET)
	// public String AdminPanelChild() {
	// return "adminPanelChildPage";
	// }

}
