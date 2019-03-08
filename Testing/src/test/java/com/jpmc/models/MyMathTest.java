package com.jpmc.models;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class MyMathTest {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Test
    public void sumTest() {

        MyMath myMath = new MyMath();
        int[] num = {1,2,3};
        assertThat(myMath.sum(num), is(6));
    }


}