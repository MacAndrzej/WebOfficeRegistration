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
import info.office.entity.Visit;
import info.office.service.ChildService;
import info.office.service.ParentService;
import info.office.service.VisitService;

@Controller
@RequestMapping("/admin")
public class AdminPanelController {

	@Autowired
	private ParentService parentService;

	@Autowired
	private ChildService childService;

	@Autowired
	private VisitService visitService;

	@GetMapping("/listParents")
	public String listParents(Model theModel) {

		List<Parent> theParents = parentService.getParents();

		theModel.addAttribute("parents", theParents);

		return "list-parents";
	}

	@GetMapping("/listChildren")
	public String listChildren(Model theModel) {

		List<Child> theChild = childService.getChildren();

		theModel.addAttribute("children", theChild);

		return "list-children";
	}

	@GetMapping("/listVisits")
	public String listVisits(Model theModel) {

		List<Visit> theVisit = visitService.getVisits();

		theModel.addAttribute("visits", theVisit);

		theModel.addAttribute(theModel);

		return "list-visits";
	}

	@GetMapping("/showFormForAddChild")
	public String showformForAddChild(Model theModel) {

		Child theChild = new Child();

		theModel.addAttribute("children", theChild);

		return "child-form";
	}

	@GetMapping("/showFormForAddParent")
	public String showFormForAddParent(Model theModel) {

		Parent theParent = new Parent();

		theModel.addAttribute("parents", theParent);

		return "parent-form";
	}

	@GetMapping("/showFormForAddVisit")
	public String showFormForAddVisit(Model theModel) {

		Visit theVisit = new Visit();
		
		
		theModel.addAttribute("visits", theVisit);
	

		return "visit-form";
	}

	@PostMapping("/saveParent")
	public String saveParent(@ModelAttribute("parents") Parent theParent) {

		parentService.saveParent(theParent);

		return "redirect:/admin/listParents";
	}

	@PostMapping("/saveChild")
	public String saveChild(@ModelAttribute("children") Child theChild) {

		childService.saveChild(theChild);

		return "redirect:/admin/listChildren";
	}

	@PostMapping("/saveVisit")
	public String saveVisit(@ModelAttribute("visits") Visit theVisit) {

		
		visitService.save(theVisit);

		return "redirect:/admin/listVisits";
	}

	@GetMapping("/showFormForUpdateParent")
	public String updateParent(@RequestParam("parentId") long theId, Model theModel) {

		Parent theParent = parentService.getParent(theId);

		theModel.addAttribute("parents", theParent);

		return "parent-form";
	}

	@GetMapping("/showFormForUpdateChild")
	public String updateChild(@RequestParam("childId") long theId, Model theModel) {

		Child theChild = childService.getChild(theId);

		theModel.addAttribute("children", theChild);

		return "child-form";
	}

	@GetMapping("/showFormForUpdateVisit")
	public String updateVisit(@RequestParam("visitId") long theId, Model theModel) {

		Visit theVisit = visitService.getVisit(theId);

		theModel.addAttribute("visits", theVisit);

		return "visit-form";

	}

	@GetMapping("/deleteParent")
	public String delete(@RequestParam("parentId") long theId) {

		parentService.deleteParent(theId);

		return "redirect:/admin/listParents";
	}

	@GetMapping("/deleteChild")
	public String deleteChild(@RequestParam("childId") long theId) {

		childService.deleteChild(theId);

		return "redirect:/admin/listChildren";
	}
	
	@GetMapping("/deleteVisit")
	public String deleteVisit(@RequestParam("visitId") long theId ) {
		
		visitService.deleteVisit(theId);
		
		return "redirect:/admin/listVisits";
	}

	@GetMapping("/showParentForChild")
	public String showParentForChild(@RequestParam("childId") long theId, Model theModel) {

		Child theChild = childService.getChild(theId);

		theModel.addAttribute("child", theChild);

		return "parent-for-child";
	}

	@GetMapping("/showChildForParent")
	public String showChildForParent(@RequestParam("parentId") long theId, Model theModel) {

		Parent theParent = parentService.getParent(theId);

		List<Child> children = theParent.getChildren();

		theModel.addAttribute("parent", theParent);
		theModel.addAttribute("child", children);

		return "child-for-parent";
	}

	//// @InitBinder
	//// public void initBinder(WebDataBinder binder) {
	//// SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");
	//// sdf.setLenient(true);
	//// binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));
	// }

	// @RequestMapping(value="/forChild", method=RequestMethod.GET)
	// public String AdminPanelChild() {
	// return "adminPanelChildPage";
	// }

	// @InitBinder
	// protected void initBinder(WebDataBinder binder) {
	// binder.registerCustomEditor(LocalDate.class, new PropertyEditorSupport() {
	// @Override
	// public void setAsText(String text) throws IllegalArgumentException{
	// setValue(LocalDate.parse(text, DateTimeFormatter.ofPattern("yyyy-MM-dd")));
	// }
	//
	// @Override
	// public String getAsText() throws IllegalArgumentException {
	// return DateTimeFormatter.ofPattern("yyyy-MM-dd").format((LocalDate)
	// getValue());
	// }
	// });
	// }

}
