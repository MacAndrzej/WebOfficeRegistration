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
import info.office.entity.CompositeModel;
import info.office.entity.Parent;
import info.office.service.ChildService;
import info.office.service.ParentService;


@Controller
public class RegisterController {

	@Autowired
	ParentService parentService;

	@Autowired
	ChildService childService;

//	@Autowired
//	UserService userService;

	@GetMapping("/showRegisterForm")
	public String showFormForRegister(Model theModel) {

		CompositeModel compositeModel = new CompositeModel();
		compositeModel.setParent(new Parent());
		compositeModel.setChild(new Child());

		theModel.addAttribute("composite", compositeModel);

		return "register-form";
	}

//	@PostMapping("/saveComposite")
//	public String saveParent(@Valid @ModelAttribute("composite") CompositeModel theComposite,
//			BindingResult theBindingResult) {
//
//		if (theBindingResult.hasErrors()) {
//			return "register-form";
//		}
//		
//		User user = new User();
//		user.setUserName(theComposite.getParent().getEmail());
//		user.setPassword(theComposite.getPassword());
//		parentService.saveParent(theComposite.getParent());
//		userService.saveUser(user);
//		childService.saveChild(theComposite.getChild());
//
//		return "register-confirmation";
//	}

}
