package com.revature.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.beans.User;
import com.revature.service.UserService;

@RestController
@RequestMapping("/user")
@CrossOrigin("*")
public class UserController {

	@Autowired
	private UserService service;
	
	@PostMapping("/login")
	public ResponseEntity<User> validateUser(@RequestBody User u) {
		
		u = service.validateUser(u);
		
		if (u==null) {
			
			return new ResponseEntity<User>(HttpStatus.I_AM_A_TEAPOT);
		} else {
			
			return new ResponseEntity<User>(u, HttpStatus.OK);
		}
	}
	
	@GetMapping("/all")
	public List<User> findAllUsers() {
		return service.findAllUsers();
	}
	
	@GetMapping("/{id}")
	public Optional<User> findOneUser(@PathVariable Integer id) {
		return service.findOneUser(id);
	}
	
	@PostMapping("/create")
	public ResponseEntity<User> createUser(@RequestBody User u) {
		u = service.save(u);
		if(u==null) {
			return new ResponseEntity<User>(HttpStatus.CONFLICT);
		} else {
			return new ResponseEntity<User>(u, HttpStatus.CREATED);
		}
	}
}
