package info.office.test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import info.office.controllers.ContactController;

class ContactControllerTest {

	@Test
	public void testContactPage() throws Exception {
		ContactController controller = new ContactController();
		MockMvc mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
		mockMvc.perform(get("/contact")).andExpect(view().name("contactPage"));
	}

}
