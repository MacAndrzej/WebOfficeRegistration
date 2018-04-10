package info.office.controllers;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.time.LocalDate;

import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import info.office.dao.ParentDAO;
import info.office.entity.CompositeParentChild;
import info.office.entity.Parent;
import info.office.service.ParentService;

public class RegisterControllerTest {

	@Test
	public void testRegisterForm() throws Exception {
		RegisterController controller = new RegisterController();
		MockMvc mockMvc = MockMvcBuilders.standaloneSetup(controller).build();

		mockMvc.perform(get("/showRegisterForm")).andExpect(status().isOk()).andExpect(view().name("register-form"))
				.andExpect(model().attribute("composite", instanceOf(CompositeParentChild.class)));
	}

//	@Test
//	public void testSaveParent() throws Exception {
//		ParentDAO mockRepository = mock(ParentDAO.class);
//
//		Parent unsaved = new Parent("maciejuk", "andrzej", "5555555", "fff@ko.pl");
//		Parent saved = new Parent("maciejuk", "andrzej", "5555555", "fff@ko.pl");
//		when(mockRepository.save(unsaved)).thenReturn(saved);
//
//		RegisterController controller = new RegisterController();
//		MockMvc mockMvc = MockMvcBuilders.standaloneSetup(controller).build();

		// mockMvc.perform(post("/saveComposite")

		// .param("surname", "maciejuk").param("name", "andrzej")
		// .param("telephone_number", "5555555").param("email", "fff@ko.pl"));
		// .andExpect(redirectedUrl("register-confirmation"));
		// verify(mockRepository, atLeastOnce()).save(unsaved);
//	}

}
