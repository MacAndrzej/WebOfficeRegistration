package info.office.controllers;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.request;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.security.Principal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import info.office.dto.VisitEntityBuilderImpl;
import info.office.entity.Visit;
import info.office.service.VisitService;

/**
 * 
 * @Created by am on 3 cze 2018
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
public class LoggedUserControllerTest {

	private MockMvc mockMvc;

	@Mock
	VisitService visitService;

	@InjectMocks
	LoggedUserController controller;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
	}

	@Test
	public void testShowVisits() throws Exception {

		mockMvc.perform(get("/loggedUser/")).andExpect(view().name("logged-user")).andExpect(status().is(200));
	}

	@Test
	public void testShowForLoggedUser() throws Exception {
		// for
		Visit first = new VisitEntityBuilderImpl().id(1L).build();
		Visit second = new VisitEntityBuilderImpl().id(2L).build();
		List<Visit> visits = Arrays.asList(first, second);

		// when
		when(visitService.getVisits()).thenReturn(visits);

		// then
		mockMvc.perform(get("/loggedUser/showVisits")).andExpect(view().name("list-users-visits"))
				.andExpect(status().is(200)).andExpect(model().size(1)).andExpect(model().attribute("visits", visits));
		verify(visitService, times(1)).getVisits();
	}

	@Test
	public void testAddVisitByUser() throws Exception {

		mockMvc.perform(get("/loggedUser/showFormForAddVisitByUser")).andExpect(view().name("visit-form"))
				.andExpect(status().is(200)).andExpect(model().attributeExists("visits"));
	}

	@Test
	@Ignore
//	@WithMockUser
	public void testSaveVisitByUser_NoErrorsAfterValidation() throws Exception {
		// for
		Visit first = new VisitEntityBuilderImpl().id(1L).dateOfVisitPlanned(LocalDate.of(2024, Month.AUGUST, 26))
				.timeOfVisitPlanned(LocalTime.of(10, 10)).build();
		Principal principal=mock(Principal.class);
		
		
		// when
		when(visitService.save(first)).thenReturn(first);

		visitService.save(first);

		// then
		mockMvc.perform(post("/loggedUser/saveVisit").param("id", "1")
				.param("dateOfVisitPlanned", LocalDate.of(2024, Month.AUGUST, 26).toString())
				.param("timeOfVisitPlanned", LocalTime.of(10, 10).toString()))
				.andExpect(view().name("redirect:/loggedUser/showVisits"));
	}

}






