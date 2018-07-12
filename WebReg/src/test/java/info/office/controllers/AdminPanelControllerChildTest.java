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

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
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
import info.office.exception.IdNotFoundException;
import info.office.service.ChildService;

public class AdminPanelControllerChildTest {

	private MockMvc mockMvc;

	@Mock
	ChildService childService;

	@InjectMocks
	AdminPanelControllerChild controller;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(controller).setControllerAdvice(new ControllerExceptionHandler()).build();
	}

	@Test
	public void testListChildren_ListIsNotEmpty() throws Exception {
		// for
		Child first = new ChildEntityBuilderImpl().id(1L).build();
		Child second = new ChildEntityBuilderImpl().id(2L).build();
		List<Child> children = Arrays.asList(first, second);

		// when
		when(childService.getChildren()).thenReturn(children);

		// then
		mockMvc.perform(get("/admin/listChildren")).andExpect(view().name("list-children")).andExpect(status().isOk())
				.andExpect(model().attributeExists("children")).andExpect(model().size(1))
				.andExpect(model().attribute("children", children));
	}

	@Test
	public void testListChildren_ListIsEmpty() throws Exception {
		// for
		List<Child> children = new ArrayList<>();

		// when
		when(childService.getChildren()).thenReturn(children);

		// then
		mockMvc.perform(get("/admin/listChildren")).andExpect(view().name("list-children")).andExpect(status().isOk())
				.andExpect(model().attributeExists("children")).andExpect(model().size(1))
				.andExpect(model().attribute("children", children));
	}

	@Test
	public void testListChildren_ListIsNull() throws Exception {
		// for
		List<Child> children = null;

		// when
		when(childService.getChildren()).thenReturn(children);

		// then
		mockMvc.perform(get("/admin/listChildren")).andExpect(view().name("list-children")).andExpect(status().isOk())
				.andExpect(model().attributeDoesNotExist("children")).andExpect(model().size(1))
				.andExpect(model().attribute("children", children));
	}

	@Test
	public void testShowFormForAddChild() throws Exception {

		mockMvc.perform(get("/admin/showFormForAddChild")).andExpect(view().name("child-form"))
				.andExpect(status().isOk()).andExpect(model().attribute("children", instanceOf(Child.class)))
				.andExpect(view().name("child-form"));
	}

	@Test
	public void testSaveChild_NoErrorsAfterValidation() throws Exception {
		// for
		Child first = new ChildEntityBuilderImpl().id(2L).dateOfBirth(LocalDate.of(1974, 8, 26)).name("andrzej")
				.surname("andrzej").visit(null).parent(null).build();

		// when
		when(childService.saveChild(first)).thenReturn(first);

		childService.saveChild(first);

		// then
		mockMvc.perform(
				post("/admin/saveChild").param("id", "2").param("dateOfBirth", LocalDate.of(1974, 8, 26).toString())
						.param("name", "andrzej").param("surname", "andrzej"))
				.andExpect(view().name("redirect:/admin/listChildren")).andExpect(status().is3xxRedirection());

		verify(childService, times(1)).saveChild(first);
	}

	@Test
	public void testSaveChild_ErrorsAfterValidation() throws Exception {
		// for
		Child first = new ChildEntityBuilderImpl().id(2L).build();

		// when
		when(childService.saveChild(first)).thenReturn(first);

		// then
		mockMvc.perform(post("/admin/saveChild").param("id", "2")).andExpect(view().name("child-form"));
	}

	@Test
	public void testUpdateChild_EntryExists() throws Exception {
		// for
		Child first = new ChildEntityBuilderImpl().id(1L).build();

		// when
		when(childService.getChild(anyLong())).thenReturn(first);

		// then
		mockMvc.perform(get("/admin/showFormForUpdateChild?childId=1")).andExpect(status().isOk())
				.andExpect(view().name("child-form"));
	}

	@Test
	public void testUpdateChild_EntryDoesNotExists() throws Exception {

		// when
		when(childService.getChild(5L)).thenThrow(IdNotFoundException.class);

		// then
		mockMvc.perform(get("/admin/showFormForUpdateChild?childId=1")).andExpect(status().isNotFound())
				.andExpect(view().name("404error"));
	}

	@Test
	public void testUpdateChild_NumberFormatException() throws Exception {

		mockMvc.perform(get("/admin/showFormForUpdateChild?childId=ff")).andExpect(status().isBadRequest())
				.andExpect(view().name("400error"));
	}

	@Test
	public void testDeleteChild() throws Exception {

		mockMvc.perform(get("/admin/deleteChild?childId=1")).andExpect(status().is3xxRedirection())
				.andExpect(view().name("redirect:/admin/listChildren"));

		verify(childService, times(1)).deleteChild(anyLong());
	}

}