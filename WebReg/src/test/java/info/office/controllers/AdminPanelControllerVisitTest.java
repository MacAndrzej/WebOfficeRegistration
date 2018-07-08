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

import info.office.entity.Visit;
import info.office.service.VisitService;

public class AdminPanelControllerVisitTest {

	private MockMvc mockMvc;
	
	@Test
	public void testListVisits() throws Exception {

		List<Visit> visits = new ArrayList<>();
		visits.add(new Visit());
		visits.add(new Visit());

		VisitService mockVisitService = mock(VisitService.class);
		when(mockVisitService.getVisits()).thenReturn(visits);

		AdminPanelControllerVisit controller = new AdminPanelControllerVisit(mockVisitService);
		mockMvc = MockMvcBuilders.standaloneSetup(controller)
				.setSingleView(new InternalResourceView("/WEB-INF/views/list-visits.jsp")).build();

		mockMvc.perform(get("/admin/listVisits")).andExpect(view().name("list-visits")).andExpect(status().isOk())
				.andDo(print());
	}
	
	@Test
	public void testShowFormForAddVisit() throws Exception {
		MockMvc mockMvc = MockMvcBuilders.standaloneSetup(new AdminPanelControllerVisit()).build();

		mockMvc.perform(get("/admin/showFormForAddVisit")).andExpect(view().name("visit-form"))
				.andExpect(status().isOk()).andExpect(model().attribute("visits", instanceOf(Visit.class)))
				.andDo(print());
	}
	
}
