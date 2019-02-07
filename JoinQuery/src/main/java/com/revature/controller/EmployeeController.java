package com.revature.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.bean.DeptEmpDto;
import com.revature.bean.Employee;
import com.revature.repository.DepartmentRepository;
import com.revature.repository.EmployeeRepository;

@RestController
@RequestMapping("/join")
public class EmployeeController {

	@Autowired
	private DepartmentRepository repo;
	
	@Autowired
	private EmployeeRepository empRepo;
	
	@GetMapping("/home")
	public String welcome() {
		return "Welcome home";
	}
	
	@GetMapping("/emp")
	public List<DeptEmpDto> deptEmp() {
		return repo.fetchEmpDeptDataJoin();
	}
	
	@GetMapping("/all") 
	public List<Employee> getAllEmployee() {
		return empRepo.findAll();
	}
}
