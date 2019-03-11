package com.jpmc.controller;

import com.jpmc.models.Employee;
import com.jpmc.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.jpmc.repository.EmployeeRepository;
import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    EmployeeService employeeService;

    @GetMapping("/all")
    public List<Employee> getAll() {
        return employeeService.getAll();
    }

    @PostMapping("/create")
    public Employee create(@Validated @RequestBody Employee employee) {
        return employeeService.create(employee);
    }
}
