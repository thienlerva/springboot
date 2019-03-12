package com.jpmc.service;

import com.jpmc.models.Employee;
import com.jpmc.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    public List<Employee> getAll() {
        return employeeRepository.findAll();
    }

    public Employee create(Employee employee) {
        return employeeRepository.save(employee);
    }

    public Employee findById(Integer id) {
        return employeeRepository.getOne(id);
    }

    public void delete(Integer id) {
         employeeRepository.deleteById(id);
    }

    public boolean exists(Employee employee) {
        List<Employee> employeeList = employeeRepository.findAll();
        if(employeeList.contains(employee)) {
            return true;
        }
        return false;
    }
}
