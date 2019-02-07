package com.revature.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;

import com.revature.beans.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

	@Query("select u from User u where lower(u.username) = lower(:username) and u.password = :password")
	public User findByUsernamePassword(@Param("username") String username, @Param("password") String password);
}
