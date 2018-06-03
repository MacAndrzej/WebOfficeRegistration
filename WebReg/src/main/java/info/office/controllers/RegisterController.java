package info.office.controllers;

import java.util.List;
import java.util.logging.Logger;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import info.office.entity.Users;

@Controller
@RequestMapping("/register")
public class RegisterController {

	@Autowired
	private UserDetailsManager userDetailsManager;

	private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

	private Logger logger = Logger.getLogger(getClass().getName());

	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
		dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
	}

	@GetMapping("/showRegistrationForm")
	public String showMyLoginPage(Model theModel) {
		theModel.addAttribute("user", new Users());
		return "registration-form";
	}

	@PostMapping("/processRegistrationForm")
	public String processRegistrationForm(@Valid @ModelAttribute("user") Users theUser,
			BindingResult theBindingResult, Model theModel) {
		// form validation

		String userName = theUser.getUserName();
		logger.info("Processing registration form for: " + userName);

		if (theBindingResult.hasErrors()) {
			theModel.addAttribute("user", new Users());
			theModel.addAttribute("registrationError", "Nazwa użykownika/hasło nie mogą być puste.");
			logger.warning("User name/password can not be empty.");
			return "registration-form";
		}

		boolean userExists = doesUserExist(userName);
		if (userExists) {
			theModel.addAttribute("user", new Users());
			theModel.addAttribute("registrationError", "Użytkownik o podanym loginie juz istnieje.");

			logger.warning("User name already exists.");

			return "registration-form";
		}

		String encodedPassword = passwordEncoder.encode(theUser.getPassword());

		List<GrantedAuthority> authorities = AuthorityUtils.createAuthorityList("ROLE_USER");

		User tempUser = new User(userName, encodedPassword, authorities);

		userDetailsManager.createUser((UserDetails) tempUser);

		logger.info("Successfully created user: " + userName);

		return "register-confirmation";
	}

	private boolean doesUserExist(String userName) {

		logger.info("Checking if user exists: " + userName);

		boolean exists = userDetailsManager.userExists(userName);

		logger.info("User: " + userName + ", exists: " + exists);

		return exists;
	}
	// @Autowired
	// ParentService parentService;
	//
	// @Autowired
	// ChildService childService;

	// @Autowired
	// UserService userService;

	// @GetMapping("/showRegisterForm")
	// public String showFormForRegister(Model theModel) {
	//
	// CompositeModel compositeModel = new CompositeModel();
	// compositeModel.setParent(new Parent());
	// compositeModel.setChild(new Child());
	//
	// theModel.addAttribute("composite", compositeModel);
	//
	// return "register-form";
	// }

	// @PostMapping("/saveComposite")
	// public String saveParent(@Valid @ModelAttribute("composite") CompositeModel
	// theComposite,
	// BindingResult theBindingResult) {
	//
	// if (theBindingResult.hasErrors()) {
	// return "register-form";
	// }
	//
	// User user = new User();
	// user.setUserName(theComposite.getParent().getEmail());
	// user.setPassword(theComposite.getPassword());
	// parentService.saveParent(theComposite.getParent());
	// userService.saveUser(user);
	// childService.saveChild(theComposite.getChild());
	//
	// return "register-confirmation";
	// }

}
