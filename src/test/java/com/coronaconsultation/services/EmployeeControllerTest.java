package com.coronaconsultation.services;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.coronaconsultation.controller.EmployeeController;
import com.coronaconsultation.entities.Employee;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest(EmployeeController.class)
class EmployeeControllerTest {

	@Autowired
	private MockMvc mockMvc;

	// LEARNING 1 :: DUMMY OBJECT :: MOCK OBJECT
	@MockBean
	private IEmployeeMaster employeeService;

	@Test
	void findEmployeeTest() throws Exception {

		Employee e = new Employee();
		e.setName("Amit");
		e.setEmail("amit@gmail.com");

		Mockito.when(employeeService.getEmployee(Mockito.anyInt())).thenReturn(e);

		mockMvc.perform(get("/api/employee/1")).andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$.name").value("Amit"));
	}

	@Test
	void createEmployeeTest() throws Exception {

		Employee e = new Employee();
		e.setName("Amit");
		e.setEmail("amit@gmail.com");

		Mockito.when(employeeService.createEmployee(Mockito.any())).thenReturn(true);

		mockMvc.perform(post("/api/employee/").contentType(MediaType.APPLICATION_JSON)
				.content(new ObjectMapper().writeValueAsString(e)))
				.andExpect(MockMvcResultMatchers.status().isCreated())
				.andExpect(MockMvcResultMatchers.jsonPath("$.name").value("Amit"));
	}

}