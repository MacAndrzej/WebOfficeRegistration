package info.office.controllers;



import static org.hamcrest.CoreMatchers.instanceOf;


import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.view.InternalResourceView;


import info.office.entity.Child;
import info.office.entity.Parent;
import info.office.service.ParentService;

public class AdminPanelControllerParentTest {

	private MockMvc mockMvc;

	@Test
	public void testListParents() throws Exception {

		List<Parent> parents = new ArrayList<>();
		parents.add(new Parent());
		parents.add(new Parent());

		ParentService mockParentService = mock(ParentService.class);
		when(mockParentService.getParents()).thenReturn(parents);

		AdminPanelControllerParent controller = new AdminPanelControllerParent(mockParentService);
		mockMvc = MockMvcBuilders.standaloneSetup(controller)
				.setSingleView(new InternalResourceView("/WEB-INF/views/list-parents.jsp")).build();

		mockMvc.perform(get("/admin/listParents")).andExpect(view().name("list-parents")).andExpect(status().isOk())
				.andDo(print());
	}

	@Test
	public void testShowFormForAddParent() throws Exception {
		MockMvc mockMvc = MockMvcBuilders.standaloneSetup(new AdminPanelControllerParent()).build();

		mockMvc.perform(get("/admin/showFormForAddParent")).andExpect(view().name("parent-form"))
				.andExpect(status().isOk()).andExpect(model().attribute("parents", instanceOf(Parent.class)))
				.andDo(print());
	}

	@Test
	public void testSaveParentBindingResultError() throws Exception {
		ParentService mockParentService = mock(ParentService.class);

		Child child = new Child(1L, "robert", "klon", LocalDate.now());

		AdminPanelControllerParent controller = new AdminPanelControllerParent(mockParentService);
		MockMvc mockMvc = MockMvcBuilders.standaloneSetup(controller).build();

		mockMvc.perform(post("/admin/saveParent").param("surname", "klon").param("name", "sebastian")
				.param("telephoneNumber", "9999999").param("email", "abd@oo.pl").param("child", child.toString()))
				.andExpect(MockMvcResultMatchers.model().hasErrors()).andExpect(view().name("parent-form"));
	}
}
