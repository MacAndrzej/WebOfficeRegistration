package info.office.test;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import info.office.controllers.CertificatesController;

class CertificatesControllerTest {

	@Test
	public void testCertificatesTest() throws Exception {
		CertificatesController controller = new CertificatesController();
		MockMvc mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
		mockMvc.perform(get("/certificates")).andExpect(view().name("certificatesPage"));
	}

}
