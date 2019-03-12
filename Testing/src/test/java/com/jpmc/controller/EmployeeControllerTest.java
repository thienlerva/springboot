package com.jpmc.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jpmc.models.Employee;
import com.jpmc.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
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
import org.springframework.util.StopWatch;

import java.sql.Time;
import java.time.LocalDateTime;
import java.util.*;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@Slf4j
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

    @Test
    public void shouldGetById() throws Exception {
        Employee employee = new Employee();

        employee.setId(1);
        employee.setName("Anthony");

        when(employeeService.findById(1)).thenReturn(employee);

        mockMvc.perform(get("/{id}", 1))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(jsonPath("$.id", is(1)))
                .andExpect(jsonPath("$.name", is("Anthony")));

        verify(employeeService, times(1)).findById(1);
        verifyNoMoreInteractions(employeeService);

    }

    @Test
    public void test_get_by_id_fail_404_not_found() throws Exception {

        when(employeeService.findById(3)).thenReturn(null);

        mockMvc.perform(get("/{id}", 3))
                .andExpect(status().isNotFound());

        verify(employeeService, times(1)).findById(3);
        verifyNoMoreInteractions(employeeService);
    }

    @Test
    public void shouldCreateEmployee() throws Exception {
        Employee employee = new Employee();
        employee.setName("Nga");
        employee.setId(3);

        when(employeeService.exists(employee)).thenReturn(false);
        doNothing().when(employeeService).create(employee);

        mockMvc.perform(post("/all")
        .contentType(MediaType.APPLICATION_JSON)
        .content(asJsonString(employee)))
                .andExpect(status().isCreated())
                .andExpect(header().string("location", containsString("http://localhost/all/")));

        verify(employeeService, times(1)).exists(employee);
        verify(employeeService, times(1)).create(employee);
        verifyNoMoreInteractions(employeeService);
    }

    @Test
    public void test_create_user_fail_409_conflict() throws Exception {
        Employee employee = new Employee();
        employee.setId(2);
        employee.setName("Jennifer");
        when(employeeService.exists(employee)).thenReturn(true);

        mockMvc.perform(
                post("/all")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(employee)))
                .andExpect(status().isConflict());

        verify(employeeService, times(1)).exists(employee);
        verifyNoMoreInteractions(employeeService);
    }

    // =========================================== Update Existing User ===================================

    @Test
    public void test_update_user_success() throws Exception {
        Employee employee = new Employee();
        employee.setId(1);
        employee.setName("Anthony Le");

        when(employeeService.findById(employee.getId())).thenReturn(employee);
        doNothing().when(employeeService).create(employee);

        mockMvc.perform(
                put("/update")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(employee)))
                .andExpect(status().isOk());

        verify(employeeService, times(1)).findById(employee.getId());
        verify(employeeService, times(1)).create(employee);
        verifyNoMoreInteractions(employeeService);
    }

    @Test
    public void test_update_user_fail_404_not_found() throws Exception {
        Employee employee = new Employee();
        employee.setId(4);
        employee.setName("employee not found");

        when(employeeService.findById(employee.getId())).thenReturn(null);

        mockMvc.perform(
                put("/{id}", employee.getId())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(employee)))
                .andExpect(status().isNotFound());

        verify(employeeService, times(1)).findById(employee.getId());
        verifyNoMoreInteractions(employeeService);
    }

    // =========================================== Delete User ============================================

    @Test
    public void test_delete_user_success() throws Exception {
        Employee employee = new Employee();
        employee.setId(2);
        employee.setName("Jennifer");

        when(employeeService.findById(employee.getId())).thenReturn(employee);
        doNothing().when(employeeService).delete(employee.getId());

        mockMvc.perform(
                delete("/delete/{id}", employee.getId()))
                .andExpect(status().isOk());

        verify(employeeService, times(1)).findById(employee.getId());
        verify(employeeService, times(1)).delete(employee.getId());
        verifyNoMoreInteractions(employeeService);
    }

    @Test
    public void test_delete_user_fail_404_not_found() throws Exception {
        Employee employee = new Employee();
        employee.setId(4);
        employee.setName("Thien");

        when(employeeService.findById(employee.getId())).thenReturn(null);

        mockMvc.perform(
                delete("/delete/{id}", employee.getId()))
                .andExpect(status().isNotFound());

        verify(employeeService, times(1)).findById(employee.getId());
        verifyNoMoreInteractions(employeeService);
    }

    // =========================================== CORS Headers ===========================================

    @Test
    public void test_cors_headers() throws Exception {
        mockMvc.perform(get("/all"))
                .andExpect(header().string("Access-Control-Allow-Origin", "*"))
                .andExpect(header().string("Access-Control-Allow-Methods", "POST, GET, PUT, OPTIONS, DELETE"))
                .andExpect(header().string("Access-Control-Allow-Headers", "*"))
                .andExpect(header().string("Access-Control-Max-Age", "3600"));
    }

    /*
     * converts a Java object into JSON representation
     */
    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    //@After
    public void cleanup() {
        LocalDateTime localDateTime = LocalDateTime.now();
        log.info("Time: {}", localDateTime);
        jdbcTemplate.update(cleanUpList.get(0));
        cleanUpList.stream().forEach(jdbcTemplate::update);
        Set<String> set = new HashSet<>();
    }
}