package info.office.controllers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

public class WebControllerTest {

	private MockMvc mockMvc;

	@Test
	public void testAbout() throws Exception {
		WebController controller = new WebController();
		mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
		mockMvc.perform(get("/about")).andExpect(MockMvcResultMatchers.view().name("aboutPage"));
	}

	@Test
	public void testCertificates() throws Exception {
		WebController controller = new WebController();
		mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
		mockMvc.perform(get("/certificates")).andExpect(view().name("certificatesPage"));
	}

	@Test
	public void testContact() throws Exception {
		WebController controller = new WebController();
		mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
		mockMvc.perform(get("/contact")).andExpect(view().name("contactPage"));
	}

	@Test
	public void testShowMainPage() throws Exception {
		WebController controller = new WebController();
		mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
		mockMvc.perform(get("/home", "/")).andExpect(view().name("main-menu"));
	}

	@Test
	public void testRegister() throws Exception {
		WebController controller = new WebController();
		mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
		mockMvc.perform(get("/registerForm")).andExpect(view().name("register-form"));
	}

}
