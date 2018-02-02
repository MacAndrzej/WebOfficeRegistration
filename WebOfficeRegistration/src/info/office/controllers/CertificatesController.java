package info.office.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CertificatesController {

	@RequestMapping("/certificates")
	public String Certificates() {
		return "certificatesPage";
	}

}
