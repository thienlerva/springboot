package com.revature.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.bean.Thermostat;

@Repository
public interface ThermostatRepository extends JpaRepository<Thermostat, Long> {

}
