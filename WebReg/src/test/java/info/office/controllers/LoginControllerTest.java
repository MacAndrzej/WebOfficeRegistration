package info.office.controllers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.view.InternalResourceView;

public class LoginControllerTest {

	private MockMvc mockMvc;

	@Test
	public void testShowMyLoginPage() throws Exception {
		LoginController loginController = new LoginController();
		mockMvc = MockMvcBuilders.standaloneSetup(loginController).build();
		mockMvc.perform(get("/login")).andExpect(view().name("login-form")).andExpect(status().isOk()).andDo(print());
	}

	@Test
	public void testShowAccessDenied() throws Exception {
		LoginController loginController = new LoginController();
		mockMvc = MockMvcBuilders.standaloneSetup(loginController)
				.setSingleView(new InternalResourceView("/WEB-INF/views/access-denied.jsp")).build();
		mockMvc.perform(get("/access-denied")).andExpect(view().name("access-denied")).andExpect(status().isOk())
				.andDo(print());
	}

}
