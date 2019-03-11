package com.jpmc.controller;

import com.jpmc.models.Employee;
import com.jpmc.service.EmployeeService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.*;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(MockitoJUnitRunner.class)
public class EmployeeControllerTest {


    MockMvc mockMvc;

    List<String> cleanUpList = new ArrayList<>();

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Mock
    EmployeeService employeeService;

    @InjectMocks
    EmployeeController employeeController;

    @Before
    public void init(){
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders
                .standaloneSetup(employeeController)
                .build();
    }

    @Test
    public void shouldGetAllEmployees() throws Exception {
        Employee employee1 = new Employee();
        employee1.setId(1);
        employee1.setName("Anthony");

        Employee employee2 = new Employee();
        employee2.setId(2);
        employee2.setName("Jennifer");

        cleanUpList.add("DELETE FROM EMPLOYEE WHERE id = 1");

        List<Employee> employeeList = Arrays.asList(
                employee1, employee2);

        when(employeeService.getAll()).thenReturn(employeeList);
        mockMvc.perform(get("/all"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))

                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].id", is(1)))
                .andExpect(jsonPath("$[0].name", is("Anthony")))
                .andExpect(jsonPath("$[1].id", is(2)))
                .andExpect(jsonPath("$[1].name", is("Jennifer")));

        verify(employeeService, times(1)).getAll();
        verifyNoMoreInteractions(employeeService);
    }

    @After
    public void cleanup() {
        jdbcTemplate.update(cleanUpList.get(0));
        cleanUpList.stream().forEach(jdbcTemplate::update);
        Set<String> set = new HashSet<>();

    }
}