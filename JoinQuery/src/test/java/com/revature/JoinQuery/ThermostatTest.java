package com.revature.JoinQuery;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.revature.DeptEmpApp;
import com.revature.bean.Thermostat;
import com.revature.controller.ThermostatController;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = DeptEmpApp.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ThermostatTest {

	@Autowired
	ThermostatController thermostatController;
	
	@Test
	public void test() {
		//Thermostat.builder().id((long)10).color("green").build();
//		List<Thermostat> expectedList = Arrays.asList(Thermostat.builder().id((long)10).color("green").build());
//		System.out.println("First:" + expectedList);
//		System.out.println("Second:" + thermostatController.getGreen());
//		assertThat(expectedList, is(thermostatController.getGreen()));
	}

}
