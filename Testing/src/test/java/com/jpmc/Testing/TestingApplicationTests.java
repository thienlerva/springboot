package com.jpmc.Testing;

import com.jpmc.models.MyMath;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestingApplicationTests {

	@Test
	public void contextLoads() {
	}

	@Test
	public void sumTest() {
		MyMath myMath = new MyMath();
		int[] num = {1,2,3};
		assertThat(myMath.sum(num), is(6));
	}

}
