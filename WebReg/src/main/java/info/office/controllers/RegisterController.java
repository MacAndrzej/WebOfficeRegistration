package info.office.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import info.office.entity.Child;
import info.office.entity.Parent;
import info.office.service.ChildService;
import info.office.service.ParentService;

@Controller
public class RegisterController {
	
	@Autowired
	ParentService parentService;
	
	@Autowired
	ChildService childService;

	@GetMapping("/showRegisterFormOne")
	public String showFormForRegister(Model theModel) {

		Parent theParent = new Parent();
		theModel.addAttribute("parent", theParent);
		
		return "register-form-step-one";
	}
	
	@GetMapping("/showRegisterFormTwo")
	public String showFormForRegisterUser(Model theModel) {

		Parent theParent = new Parent();
		theModel.addAttribute("parent", theParent);
		
		return "register-form-step-one";
	}

	@PostMapping("/saveParent")
	public String saveParent(@Valid @ModelAttribute("parents") Parent theParent, BindingResult theBindingResult) {
		if (theBindingResult.hasErrors()) {
			return "parent-form";
		}
		parentService.saveParent(theParent);

		return "redirect:/admin/listParents";
	}

	@PostMapping("/saveChild")
	public String saveChild(@Valid @ModelAttribute("children") Child theChild, BindingResult theBindingResult) {

		if (theBindingResult.hasErrors()) {
			return "child-form";
		}
		// sprawdzić czy nie warto byłoby dodać dodatkowy view child-confirmation
		childService.saveChild(theChild);

		return "redirect:/admin/listChildren";
	}

}
