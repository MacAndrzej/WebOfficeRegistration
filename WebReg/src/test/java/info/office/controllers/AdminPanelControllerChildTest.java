package info.office.controllers;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import info.office.dto.ChildEntityBuilderImpl;
import info.office.entity.Child;
import info.office.service.ChildService;

public class AdminPanelControllerChildTest {

	private MockMvc mockMvc;

	@Mock
	private ChildService childService;

	@InjectMocks
	private AdminPanelControllerChild adminPanelControllerChild;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(adminPanelControllerChild).build();
	}

	@Test
	public void testListChildren_ListIsNotEmpty() throws Exception {
		// given
		List<Child> children = new ArrayList<>();
		children.add(new Child());
		children.add(new Child());

		// when
		when(childService.getChildren()).thenReturn(children);

		// then
		mockMvc.perform(get("/admin/listChildren")).andExpect(view().name("list-children")).andExpect(status().isOk());
		
		verify(childService, times(1)).getChildren();
	}

	@Test
	public void testListChildren_ListIsEmpty() throws Exception {
		// given
		List<Child> children = new ArrayList<>();

		// when
		when(childService.getChildren()).thenReturn(children);

		// then
		mockMvc.perform(get("/admin/listChildren")).andExpect(model().size(1)).andExpect(view().name("list-children"))
				.andExpect(status().isOk());
		
		verify(childService, times(1)).getChildren();
	}

	@Test
	public void testShowFormForAddChild() throws Exception {
		
		mockMvc.perform(get("/admin/showFormForAddChild")).andExpect(view().name("child-form"))
				.andExpect(status().isOk()).andExpect(model().attribute("children", instanceOf(Child.class)))
				.andDo(print());
	}
	
	@Test
	public void testShowFormForUpdateChild_EntryExists() throws Exception {
//		given
		Child first=new ChildEntityBuilderImpl().id(1L).build();
		
//		when
		when(childService.findByParent_id(1L)).thenReturn(first);
		
//		then
		mockMvc.perform(get("/admin/listChildren?childrenId=1")).andExpect(view().name("list-children"))
				.andExpect(status().isOk()).andExpect(model().attributeExists("children"))
				.andDo(print());
	}
	

}
