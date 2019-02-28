package com.revature.JoinQuery;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.containsString;

import org.junit.Test;

public class LombokTest {

	@Test
	public void test() {
		//fail("Not yet implemented");
		int expectedValue = 2;
		int actualValue = 2;
		assertThat(expectedValue, is(actualValue));
	}
	
	@Test
	public void containTest() {
		assertThat("Do you see me", containsString("Do you"));
	}

}
