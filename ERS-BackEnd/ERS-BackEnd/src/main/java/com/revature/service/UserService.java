package com.revature.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.beans.User;
import com.revature.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository repo;
	
	public User validateUser(User u) {
		return repo.findByUsernamePassword(u.getUsername(), u.getPassword());
	}
	
	public List<User> findAllUsers() {
		return repo.findAll();
	}
	
	public Optional<User> findOneUser(Integer id) {
		return repo.findById(id);
	}
	
	public User save(User u) {
		return repo.save(u);
	}
	
	public void delete(Integer id) {
		repo.deleteById(id);
	}
}
