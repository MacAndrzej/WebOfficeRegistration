package info.office.controllers;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.view.InternalResourceView;

import info.office.entity.Child;
import info.office.service.ChildService;

public class AdminPanelControllerChildTest {

	private MockMvc mockMvc;
	
	@Test
	public void testListChildren() throws Exception {

		List<Child> children = new ArrayList<>();
		children.add(new Child());
		children.add(new Child());

		ChildService mockChildService = mock(ChildService.class);
		when(mockChildService.getChildren()).thenReturn(children);

		AdminPanelControllerChild controller = new AdminPanelControllerChild(mockChildService);
		mockMvc = MockMvcBuilders.standaloneSetup(controller)
				.setSingleView(new InternalResourceView("/WEB-INF/views/list-children.jsp")).build();

		mockMvc.perform(get("/admin/listChildren")).andExpect(view().name("list-children")).andExpect(status().isOk())
				.andDo(print());
	}
	
	@Test
	public void testShowFormForAddChild() throws Exception {
		MockMvc mockMvc = MockMvcBuilders.standaloneSetup(new AdminPanelControllerChild()).build();

		mockMvc.perform(get("/admin/showFormForAddChild")).andExpect(view().name("child-form"))
				.andExpect(status().isOk()).andExpect(model().attribute("children", instanceOf(Child.class)))
				.andDo(print());
	}
	
	
	
	
}
