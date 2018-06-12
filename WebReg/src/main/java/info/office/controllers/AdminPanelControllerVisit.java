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

import info.office.entity.Visit;
import info.office.exception.IdNotFoundException;
import info.office.service.VisitService;

@Controller
@RequestMapping("/admin")
public class AdminPanelControllerVisit {

	@Autowired
	private VisitService visitService;
	
	@Autowired
	public AdminPanelControllerVisit(VisitService visitService) {
		this.visitService = visitService;
	}
	
	public AdminPanelControllerVisit() {

	}
	
	@GetMapping("/listVisits")
	public String listVisits(Model theModel) {
		theModel.addAttribute("visits", visitService.getVisits());
		return "list-visits";
	}
	
	@GetMapping("/showFormForAddVisit")
	public String showFormForAddVisit(Model theModel) {
		theModel.addAttribute("visits", new Visit());
		return "visit-form";
	}
	
	@PostMapping("/saveVisit")
	public String saveVisit(@Valid @ModelAttribute("visits") Visit theVisit, BindingResult theBindingResult) {
		if (theBindingResult.hasErrors()) {
			return "visit-form";
		}
		visitService.save(theVisit);
		return "redirect:/admin/listVisits";
	}
	
	@GetMapping("/showFormForUpdateVisit")
	public String updateVisit(@RequestParam("visitId") long theId, Model theModel) throws IdNotFoundException {
		Visit theVisit = visitService.getVisit(theId);
		theModel.addAttribute("visits", theVisit);
		return "visit-form";
	}
	
	@GetMapping("/deleteVisit")
	public String deleteVisit(@RequestParam("visitId") long theId) {
		visitService.deleteVisit(theId);
		return "redirect:/admin/listVisits";
	}
	
}
