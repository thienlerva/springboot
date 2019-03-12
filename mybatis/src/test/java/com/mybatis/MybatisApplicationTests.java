package com.mybatis;

import com.mybatis.model.Student;
import com.mybatis.repository.StudentMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.notNullValue;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MybatisApplicationTests {

//	@Autowired
//	StudentMapper studentMapper;
//
//	@Test
//	public void shouldGetAll() {
//		List<Student> studentList = studentMapper.findAll();
//		assertThat(studentList.size(), is(1));
//	}

}
