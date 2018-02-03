package info.office.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class CertificatesController {

	@GetMapping("/certificates")
	public String Certificates() {
		return "certificatesPage";
	}

}
