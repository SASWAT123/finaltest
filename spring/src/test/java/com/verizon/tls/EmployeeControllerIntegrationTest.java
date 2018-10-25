package com.verizon.tls;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.verizon.tls.model.Employee;
import com.verizon.tls.service.IEmployeeService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EmployeeControllerIntegrationTest {
	private MockMvc mockMvc;
	
	@Autowired
	private WebApplicationContext webApplicationContext;
	
	@Autowired
	private IEmployeeService empService;
	
	@Before
	public void setUp(){
		mockMvc=MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}
	@Test
	public void testListEmployees() throws Exception{
		assertThat(this.empService).isNotNull();		
		
		List<Employee> empList=empService.listEmployees();
		
		mockMvc.perform(get("/listEmps"))
		.andExpect(status().isOk())
		.andExpect(view().name("empList"))
		.andExpect(model().attributeExists("emps"))
		.andExpect(model().attribute("emps",empList))
		.andDo(print());
	}

}
