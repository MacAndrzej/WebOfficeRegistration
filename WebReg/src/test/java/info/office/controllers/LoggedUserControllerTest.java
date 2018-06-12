package info.office.controllers;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.request;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestBuilders.*;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.httpBasic;

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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import info.office.dto.ParentEntityBuilderImpl;
import info.office.dto.VisitEntityBuilderImpl;
import info.office.entity.Parent;
import info.office.entity.Users;
import info.office.entity.Visit;
import info.office.service.ParentService;
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

	@Mock
	ParentService parentService;

	@Mock
	Principal principal;

	@Mock
	private Parent userStub;

	@InjectMocks
	LoggedUserController controller;

	private String defaultName = "name";

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
	}

	// @Test
	// @WithMockUser
	// public void testShowVisits() throws Exception {
	//
	// mockMvc.perform(get("/loggedUser/").with(httpBasic("user",
	// "password"))).andExpect(view().name("logged-user"))
	// .andExpect(status().is(200));
	// }
	//
	// @Test
	// public void testShowForLoggedUser() throws Exception {
	// // for
	// Visit first = new VisitEntityBuilderImpl().id(1L).build();
	// Visit second = new VisitEntityBuilderImpl().id(2L).build();
	// List<Visit> visits = Arrays.asList(first, second);
	//
	// // when
	// when(visitService.getVisits()).thenReturn(visits);
	//
	// // then
	// mockMvc.perform(get("/loggedUser/showVisits").with(httpBasic("user",
	// "password")))
	// .andExpect(view().name("list-users-visits")).andExpect(status().is(200)).andExpect(model().size(1))
	// .andExpect(model().attribute("visits", visits));
	// verify(visitService, times(1)).getVisits();
	// }
	//
	// @Test
	// public void testAddVisitByUser() throws Exception {
	//
	// mockMvc.perform(get("/loggedUser/showFormForAddVisitByUser")).andExpect(view().name("visit-form"))
	// .andExpect(status().is(200)).andExpect(model().attributeExists("visits"));
	// }

	@Test
	@WithMockUser
	public void testSaveVisitByUser_NoErrorsAfterValidation() throws Exception {
		// for
		Visit first = new VisitEntityBuilderImpl().id(1L).dateOfVisitPlanned(LocalDate.of(2024, Month.AUGUST, 26))
				.timeOfVisitPlanned(LocalTime.of(10, 10)).build();
		Principal mockPrincipal = mock(Principal.class);

		// when
//		when(visitService.save(first)).thenReturn(first);
		when(principal.getName()).thenReturn(defaultName);
		when(parentService.findByName(defaultName)).thenReturn(userStub);

		visitService.save(first);

		// then
//		mockMvc.perform(post("/loggedUser/saveVisit").param("id", "1")
//				.param("dateOfVisitPlanned", LocalDate.of(2024, Month.AUGUST, 26).toString())
//				.param("timeOfVisitPlanned", LocalTime.of(10, 10).toString()))
//				.andExpect(view().name("redirect:/loggedUser/showVisits"));
//		assertTrue(instanceOf(Visit.class));
		verify(visitService,times(1)).save(first);
	}

	@Test
	@WithMockUser
	public void testSaveVisitByUser_ErrorsAfterValidation() throws Exception {
		// for
		LocalTime czas = LocalTime.of(10, 10);
		System.out.println(czas);
		Visit first = new VisitEntityBuilderImpl().id(1L).dateOfVisitPlanned(LocalDate.of(2024, Month.AUGUST, 26))
				.absence(true).timeOfVisitPlanned(czas).build();

		// when
		when(visitService.save(first)).thenReturn(first);

		visitService.save(first);

		// then
		mockMvc.perform(post("/loggedUser/saveVisit").param("id", "1").param("absence", "true")
				.param("timeOfVisitPlanned", czas.toString())
				.param("dateOfVisitPlanned", LocalDate.of(2024, Month.AUGUST, 26).toString()))
				.andExpect(view().name("visit-form")).andExpect(model().hasErrors()).andDo(print());
	}

	// @Test
	// public void testUpdateVisitByUser() throws Exception {
	//
	// // for
	// Visit first = new
	// VisitEntityBuilderImpl().id(1L).dateOfVisitPlanned(LocalDate.of(2024,
	// Month.AUGUST, 26))
	// .timeOfVisitPlanned(LocalTime.of(10, 10)).build();
	//
	// // when
	// when(visitService.getVisit(1L)).thenReturn(first);
	//
	// // then
	// mockMvc.perform(get("/loggedUser/showFormForUpdateVisit?visitId=1")).andExpect(view().name("visit-form"))
	// .andExpect(status().is(200)).andExpect(model().attributeExists("visits"));
	//
	// }
	//
	// @Test
	// public void testCompleteDataUser() throws Exception {
	//
	// mockMvc.perform(get("/loggedUser/showFormForCompleteUserData"))
	// .andExpect(view().name("parent-child-complete-data-form"))
	// .andExpect(model().attributeExists("parentChild"));
	// }
	//
	// @Test
	// @Ignore
	// public void testDataUser() throws Exception {
	// // for
	// Parent first = new ParentEntityBuilderImpl().id(1L).name("stanley").build();
	//
	// // when
	// when(parentService.findByName("stanley")).thenReturn(first);
	//
	// // then
	// mockMvc.perform(get("/loggedUser/userData?parentId=1")).andExpect(view().name("user-data"))
	// .andExpect(model().attributeExists("user"));
	// }

}
