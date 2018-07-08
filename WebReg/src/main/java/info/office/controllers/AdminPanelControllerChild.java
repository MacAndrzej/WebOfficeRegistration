package info.office.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import info.office.entity.Child;
import info.office.exception.IdNotFoundException;
import info.office.service.ChildService;

@Controller
@RequestMapping("/admin")
public class AdminPanelControllerChild {

	@Autowired
	private ChildService childService;

	@Autowired
	public AdminPanelControllerChild(ChildService childService) {
		this.childService = childService;
	}

	public AdminPanelControllerChild() {

	}

	@GetMapping("/listChildren")
	public String listChildren(Model theModel) {
		theModel.addAttribute("children", childService.getChildren());
		return "list-children";
	}

	@GetMapping("/showFormForAddChild")
	public String showformForAddChild(Model theModel) {
		theModel.addAttribute("children", new Child());
		return "child-form";
	}

	@PostMapping("/saveChild")
	public String saveChild(@Valid @ModelAttribute("children") Child theChild, BindingResult theBindingResult) {
		if (theBindingResult.hasErrors()) {
			return "child-form";
		}
		childService.saveChild(theChild);
		return "redirect:/admin/listChildren";
	}

	@GetMapping("/showFormForUpdateChild")
	public String updateChild(@RequestParam("childId") long theId, Model theModel) throws IdNotFoundException {
		Child theChild = childService.getChild(theId);
		theModel.addAttribute("children", theChild);
		return "child-form";
	}

	@GetMapping("/deleteChild")
	public String deleteChild(@RequestParam("childId") long theId) {
		childService.deleteChild(theId);
		return "redirect:/admin/listChildren";
	}

}

