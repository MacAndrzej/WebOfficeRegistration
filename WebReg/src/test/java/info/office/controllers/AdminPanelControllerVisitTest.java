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
import java.time.LocalTime;
import java.time.Month;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import info.office.dto.VisitEntityBuilderImpl;
import info.office.entity.Visit;
import info.office.service.VisitService;

public class AdminPanelControllerVisitTest {

	private MockMvc mockMvc;

	@Mock
	VisitService visitService;

	@InjectMocks
	AdminPanelControllerVisit controller;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
	}

	@Test
	public void testListVisits_ListIsNotEmpty() throws Exception {
		// for
		Visit first = new VisitEntityBuilderImpl().id(1L).build();
		Visit second = new VisitEntityBuilderImpl().id(2L).build();
		List<Visit> visits = Arrays.asList(first, second);

		// when
		when(visitService.getVisits()).thenReturn(visits);

		// then
		mockMvc.perform(get("/admin/listVisits")).andExpect(view().name("list-visits")).andExpect(status().isOk())
				.andExpect(model().attributeExists("visits")).andExpect(model().size(1))
				.andExpect(model().attribute("visits", visits));
	}

	@Test
	public void testListParents_ListIsEmpty() throws Exception {
		// for
		List<Visit> visits = null;

		// when
		when(visitService.getVisits()).thenReturn(visits);

		// then
		mockMvc.perform(get("/admin/listVisits")).andExpect(view().name("list-visits")).andExpect(status().isOk())
				.andExpect(model().size(1)).andExpect(model().attribute("visits", visits));
	}

	@Test
	public void testShowFormForAddVisit() throws Exception {

		mockMvc.perform(get("/admin/showFormForAddVisit")).andExpect(view().name("visit-form"))
				.andExpect(status().isOk()).andExpect(model().attribute("visits", instanceOf(Visit.class)))
				.andExpect(view().name("visit-form"));
	}

	@Test
	public void testSaveVisit_NoErrorsAfterValidation() throws Exception {
		// for
		Visit first = new VisitEntityBuilderImpl().id(1L).dateOfVisitPlanned(LocalDate.of(2024, Month.AUGUST, 26))
				.timeOfVisitPlanned(LocalTime.of(10, 10)).build();		

		// when
		when(visitService.save(first)).thenReturn(first);

		// then
		mockMvc.perform(post("/admin/saveVisit").param("id", "1")
				.param("dateOfVisitPlanned", LocalDate.of(2024, Month.AUGUST, 26).toString())
				.param("timeOfVisitPlanned", LocalTime.of(10, 10).toString()))
				.andExpect(view().name("redirect:/admin/listVisits")).andExpect(status().is3xxRedirection());
	}

	@Test
	public void testSaveParent_ErrorsAfterValidation() throws Exception {
		// for
		Visit first = new VisitEntityBuilderImpl().id(2L).build();

		// when
		when(visitService.save(first)).thenReturn(first);

		// then
		mockMvc.perform(post("/admin/saveVisit").param("id", "2")).andExpect(view().name("visit-form"));
	}

	@Test
	public void testUpdateVisit() throws Exception {
		// for
		Visit first = new VisitEntityBuilderImpl().id(1L).build();

		// when
		when(visitService.getVisit(anyLong())).thenReturn(first);

		// then
		mockMvc.perform(get("/admin/showFormForUpdateVisit?visitId=1")).andExpect(status().isOk())
				.andExpect(view().name("visit-form"));
	}

	@Test
	public void testDeleteVisit() throws Exception {

		mockMvc.perform(get("/admin/deleteVisit?visitId=1")).andExpect(status().is3xxRedirection())
				.andExpect(view().name("redirect:/admin/listVisits"));

		verify(visitService, times(1)).deleteVisit(anyLong());
	}

}