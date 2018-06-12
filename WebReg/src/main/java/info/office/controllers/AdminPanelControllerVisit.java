package info.office.controllers;

import java.time.LocalDate;

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

import info.office.entity.Visit;
import info.office.service.VisitService;

/**
 * 
 * @Created by am on 12 cze 2018 Controller to handling admin visit's options
 *
 */
@Controller
@RequestMapping("/admin")
public class AdminPanelControllerVisit {

	final static Logger logger = Logger.getLogger(AdminPanelControllerVisit.class);

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
		logger.info("Entering to controller admin/listVisits");
		theModel.addAttribute("visits", visitService.getVisits());
		return "list-visits";
	}

	@GetMapping("/showFormForAddVisit")
	public String showFormForAddVisit(Model theModel) {
		logger.info("Entering to controller admin/showFormForAddVisit");
		theModel.addAttribute("visits", new Visit());
		return "visit-form";
	}

	@PostMapping("/saveVisit")
	public String saveVisit(@Valid @ModelAttribute("visits") Visit theVisit, BindingResult theBindingResult) {
		logger.info("Entering to controller admin/saveVisit");
		if (theBindingResult.hasErrors()) {
			theBindingResult.getAllErrors().forEach(objectError -> {
				logger.info("Binding results error: " + theBindingResult);
			});
			return "visit-form";
		}
		visitService.save(theVisit);
		logger.info("Visit saved.");
		return "redirect:/admin/listVisits";
	}

	@GetMapping("/showFormForUpdateVisit")
	public String updateVisit(@RequestParam("visitId") long theId, Model theModel) {
		logger.info("Entering to controller admin/showFormForUpdateVisit");
		Visit theVisit = visitService.getVisit(theId);
		theModel.addAttribute("visits", theVisit);
		return "visit-form";
	}

	@GetMapping("/deleteVisit")
	public String deleteVisit(@RequestParam("visitId") long theId) {
		logger.info("Entering to controller admin/deleteVisit");
		visitService.deleteVisit(theId);
		return "redirect:/admin/listVisits";
	}

}
