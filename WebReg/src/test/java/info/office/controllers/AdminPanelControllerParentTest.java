package info.office.controllers;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import info.office.dto.ParentEntityBuilderImpl;
import info.office.entity.Parent;
import info.office.service.ParentService;

public class AdminPanelControllerParentTest {

	private MockMvc mockMvc;

	@Mock
	ParentService parentService;

	@InjectMocks
	AdminPanelControllerParent controller;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
	}

	@Test
	public void testListParents_ListIsNotEmpty() throws Exception {
		// for
		Parent first = new ParentEntityBuilderImpl().id(1L).build();
		Parent second = new ParentEntityBuilderImpl().id(2L).build();
		List<Parent> parents = Arrays.asList(first, second);

		// when
		when(parentService.getParents()).thenReturn(parents);

		// then
		mockMvc.perform(get("/admin/listParents")).andExpect(view().name("list-parents")).andExpect(status().isOk())
				.andExpect(model().attributeExists("parents")).andExpect(model().size(1))
				.andExpect(model().attribute("parents", parents));
	}

	@Test
	public void testListParents_ListIsEmpty() throws Exception {
		// for
		List<Parent> parents = null;

		// when
		when(parentService.getParents()).thenReturn(parents);

		// then
		mockMvc.perform(get("/admin/listParents")).andExpect(view().name("list-parents")).andExpect(status().isOk())
				.andExpect(model().size(1)).andExpect(model().attribute("parents", parents));
	}

	@Test
	public void testShowFormForAddParent() throws Exception {

		mockMvc.perform(get("/admin/showFormForAddParent")).andExpect(view().name("parent-form"))
				.andExpect(status().isOk()).andExpect(model().attribute("parents", instanceOf(Parent.class)))
				.andExpect(view().name("parent-form"));
	}

	@Test
	public void testSaveParent_NoErrorsAfterValidation() throws Exception {
		// for
		Parent first = new ParentEntityBuilderImpl().id(1L).email("cokolwiek@op.pl").name("rob").surname("roy")
				.telephoneNumber("5555555").child(null).build();
		

		// when
		when(parentService.saveParent(first)).thenReturn(first);

		// then
		mockMvc.perform(
				post("/admin/saveParent").param("id", "1").param("email", "cokolwiek@op.pl").param("name", "rob")
						.param("surname", "roy").param("telephoneNumber", "5555555"))
				.andExpect(view().name("redirect:/admin/listParents")).andExpect(status().is3xxRedirection());
	}

	@Test
	public void testSaveParent_ErrorsAfterValidation() throws Exception {
		// for
		Parent first = new ParentEntityBuilderImpl().id(1L).build();

		// when
		when(parentService.saveParent(first)).thenReturn(first);

		// then
		mockMvc.perform(post("/admin/saveParent").param("id", "1")).andExpect(view().name("parent-form"));
	}

	@Test
	public void testUpdateParent() throws Exception {
		// for
		Parent first = new ParentEntityBuilderImpl().id(1L).build();

		// when
		when(parentService.getParent(anyLong())).thenReturn(first);

		// then
		mockMvc.perform(get("/admin/showFormForUpdateParent?parentId=1")).andExpect(status().isOk())
				.andExpect(view().name("parent-form"));
	}

	@Test
	public void testDeleteParent() throws Exception {

		mockMvc.perform(get("/admin/deleteParent?parentId=1")).andExpect(status().is3xxRedirection())
				.andExpect(view().name("redirect:/admin/listParents"));

		verify(parentService, times(1)).deleteParent(anyLong());
	}

}