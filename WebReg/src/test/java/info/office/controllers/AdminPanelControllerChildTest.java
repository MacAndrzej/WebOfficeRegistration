package info.office.controllers;

import static org.hamcrest.CoreMatchers.any;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.validation.BindingResult;

import info.office.dto.ChildEntityBuilderImpl;
import info.office.dto.ParentEntityBuilderImpl;
import info.office.dto.VisitEntityBuilderImpl;
import info.office.entity.Child;
import info.office.entity.Parent;
import info.office.entity.Visit;
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
		mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
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
	 public void testShowFormForAddChild() throws Exception {
	
	 mockMvc.perform(get("/admin/showFormForAddChild")).andExpect(view().name("child-form"))
	 .andExpect(status().isOk()).andExpect(model().attribute("children",
	 instanceOf(Child.class)))
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
		
		verify(childService,times(1)).saveChild(first);
	}

	 @Test
	 public void testSaveChild_ErrorsAfterValidation() throws Exception {
	 // for
	 Child first = new ChildEntityBuilderImpl().id(2L).build();
	
	 // when
	 when(childService.saveChild(first)).thenReturn(first);
	
	 // then
	 mockMvc.perform(post("/admin/saveChild").param("id",
	 "2")).andExpect(view().name("child-form"));
	 }
	
	 @Test
	 public void testUpdateChild() throws Exception {
	 // for
	 Child first = new ChildEntityBuilderImpl().id(1L).build();
	
	 // when
	 when(childService.getChild(anyLong())).thenReturn(first);
	
	 // then
	 mockMvc.perform(get("/admin/showFormForUpdateChild?childId=1")).andExpect(status().isOk())
	 .andExpect(view().name("child-form"));
	 }
	
	 @Test
	 public void testDeleteChild() throws Exception {
	
	 mockMvc.perform(get("/admin/deleteChild?childId=1")).andExpect(status().is3xxRedirection())
	 .andExpect(view().name("redirect:/admin/listChildren"));
	
	 verify(childService, times(1)).deleteChild(anyLong());
	 }

}
