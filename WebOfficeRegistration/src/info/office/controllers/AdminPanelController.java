package info.office.controllers;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import info.office.entity.Child;
import info.office.entity.Parent;
import info.office.service.ChildService;
import info.office.service.ParentService;

@Controller
@RequestMapping("/admin")
public class AdminPanelController {

	@Autowired
	private ParentService parentService;

	@Autowired
	private ChildService childService;

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

	@GetMapping("/showFormForUpdateParent")
	public String updateParent(@RequestParam("parentId") long theId, Model theModel) {

		Parent theParent = parentService.getParent(theId);

		theModel.addAttribute("parents", theParent);

		return "parent-form";
	}
	
	@GetMapping("/showFormForUpdateChild")
	public String updateChild(@RequestParam("childId") long theId, Model theModel) {
	
		Child theChild=childService.getChild(theId);
		
		theModel.addAttribute("children", theChild);
		
		return "child-form";
	}

	@GetMapping("/deleteParent")
	public String delete(@RequestParam("parentId") long theId) {

		parentService.deleteParent(theId);

		return "redirect:/admin/listParents";
	}

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");
		sdf.setLenient(true);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));
	}

	// @RequestMapping(value="/forChild", method=RequestMethod.GET)
	// public String AdminPanelChild() {
	// return "adminPanelChildPage";
	// }

}
