package info.office.controllers;

import java.security.Principal;


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
import info.office.entity.CompositeParentChild;
import info.office.entity.Parent;
import info.office.entity.Visit;
import info.office.service.ChildService;
import info.office.service.ParentService;
import info.office.service.VisitService;

@Controller
@RequestMapping("/loggedUser")
public class LoggedUserController {

	@Autowired
	private VisitService visitService;

	@Autowired
	private ChildService childService;

	@Autowired
	private ParentService parentService;

	@GetMapping("/")
	private String showForLoggedUser() {
		return "logged-user";
	}

	@GetMapping("/showVisits")
	private String showUserVisits(Principal principal, Model theModel) {
		theModel.addAttribute("visits", visitService.getVisits());
		return "list-users-visits";
	}

	@GetMapping("/showFormForAddVisitByUser")
	private String addVisitByUser(Model theModel) {
		theModel.addAttribute("visits", new Visit());
		return "visit-form";
	}

	@PostMapping("/saveVisit")
	private String saveVisitByUser(@Valid @ModelAttribute("visits") Visit theVisit, BindingResult theBindingResult,
			Principal principal) {
		if (theBindingResult.hasErrors()) {
			return "visit-form";
		}
		String username = principal.getName();
		Parent theParent = parentService.findByName(username);
		Child theChild=new Child();
		theChild=childService.findByParent_id(theParent.getId());
		theVisit.setChild(theChild);
		visitService.save(theVisit);
		return "redirect:/loggedUser/showVisits";
	}

	@GetMapping("/showFormForUpdateVisit")
	private String updateVisitByUser(@RequestParam("visitId") long theId, Model theModel) {
		Visit theVisit = visitService.getVisit(theId);
		theModel.addAttribute("visits",theVisit);
		return "visit-form";
	}

	@GetMapping("/showFormForCompleteUserData")
	private String completeDataUser(Model theModel, Principal principal) {
		theModel.addAttribute("parentChild", new CompositeParentChild());
		return "parent-child-complete-data-form";
	}

	@PostMapping("/saveParentChild")
	private String saveParentChildData(
			@Valid @ModelAttribute("parentChild") CompositeParentChild theCompositeParentChild, Principal principal,
			BindingResult theBindingResult) {
		if (theBindingResult.hasErrors()) {
			return "parent-child-complete-data-form";
		}
		Parent theParent = new Parent();
		Child theChild = new Child();
		theParent = theCompositeParentChild.getParent();
		theChild = theCompositeParentChild.getChild();
		theChild.setParent(theParent);
		childService.saveChild(theChild);
		return "redirect:/loggedUser/userData";
	}

	@GetMapping("/userData")
	private String dataUser(Principal principal, Model theModel) {
		String username = principal.getName();
		Parent theParent = parentService.findByName(username);
		theModel.addAttribute("user", theParent);
		return "user-data";
	}

}
