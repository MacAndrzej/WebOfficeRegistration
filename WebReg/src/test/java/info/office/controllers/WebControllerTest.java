package info.office.controllers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

public class WebControllerTest {

	private MockMvc mockMvc;
	
	@InjectMocks
	WebController controller;
	
	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
	}

	@Test
	public void testAbout() throws Exception {
		
		mockMvc.perform(get("/about")).andExpect(MockMvcResultMatchers.view().name("aboutPage"));
	}

	@Test
	public void testCertificates() throws Exception {
		
		mockMvc.perform(get("/certificates")).andExpect(view().name("certificatesPage"));
	}

	@Test
	public void testContact() throws Exception {
		
		mockMvc.perform(get("/contact")).andExpect(view().name("contactPage"));
	}

	@Test
	public void testShowMainPage() throws Exception {
		
		mockMvc.perform(get("/home", "/")).andExpect(view().name("main-menu"));
	}


}
