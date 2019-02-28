package com.revature.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.revature.bean.Employee;
import com.revature.bean.Thermostat;
import com.revature.repository.ThermostatRepository;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class ThermostatController {
	
	@Autowired
	ThermostatRepository repo;
	
	
	
	@GetMapping("home")
	public String home() {
		return "HOme";
	}
	
	@GetMapping("all")
	public List<Thermostat> getAll() {
		Employee emp = new Employee();
		emp.setId(12);
		log.debug("inhere---------- {} ", 1234343);
		return repo.findAll();
	}
	
	@GetMapping("green")
	public List<Thermostat> getGreen() {
		List<Thermostat> thermostat = repo.findAll();
		return thermostat.stream().filter(t->t.getColor().equalsIgnoreCase("green")).collect(Collectors.toList());
	}
	
	@GetMapping("{id}")
	public Optional<Thermostat> getOne(@PathVariable Long id) {
		return repo.findById(id);
	}

}
