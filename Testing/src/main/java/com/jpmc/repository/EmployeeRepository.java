package com.jpmc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.jpmc.models.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
