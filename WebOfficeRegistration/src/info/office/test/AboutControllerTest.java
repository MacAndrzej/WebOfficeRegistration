package info.office.test;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import info.office.controllers.AboutController;

class AboutControllerTest {

	@Test
	public void testAboutPage() throws Exception {
		AboutController controller=new AboutController();
		MockMvc mockMvc=MockMvcBuilders.standaloneSetup(controller).build();
		mockMvc.perform(get("/about")).andExpect(view().name("aboutPage"));
		
	}

}
