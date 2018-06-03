package info.office.controllers;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import info.office.entity.Parent;
import info.office.service.ParentService;

@Controller
@RequestMapping("/admin")
public class AdminPanelControllerParent {

	final static Logger logger = Logger.getLogger(AdminPanelControllerParent.class);

	
	@Autowired
	private ParentService parentService;

	@Autowired
	public AdminPanelControllerParent(ParentService parentService) {
		this.parentService = parentService;
	}

	public AdminPanelControllerParent() {
	}

	@GetMapping("/listParents")
	public String listParents(Model theModel) {
		logger.info("Entering to controller admin/listParents");
		theModel.addAttribute("parents", parentService.getParents());
		return "list-parents";
	}

	@GetMapping("/showFormForAddParent")
	public String showFormForAddParent(Model theModel) {
		logger.info("Entering to controller admin/showFormForAddParent");
		theModel.addAttribute("parents", new Parent());
		return "parent-form";
	}

	@PostMapping("/saveParent")
	public String saveParent(@Valid @ModelAttribute("parents") Parent theParent, BindingResult theBindingResult) {
		logger.info("Entering to controller admin/saveParent");
		if (theBindingResult.hasErrors()) {
			return "parent-form";
		}
		parentService.saveParent(theParent);
		return "redirect:/admin/listParents";
	}

	@GetMapping("/showFormForUpdateParent")
	public String updateParent(@RequestParam("parentId") long theId, Model theModel) {
		logger.info("Entering to controller admin/showFormForUpdateParent");
		Parent theParent = parentService.getParent(theId);
		theModel.addAttribute("parents", theParent);
		return "parent-form";
	}

	@GetMapping("/deleteParent")
	public String delete(@RequestParam("parentId") long theId) {
		logger.info("Entering to controller admin/deleteParent");
		parentService.deleteParent(theId);
		return "redirect:/admin/listParents";
	}
}
