package com.jpmc.mybatisExample.Mapper;

import com.jpmc.mybatisExample.models.Instructor;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
public interface InstructorMapper {

    void insertInstructor(Instructor instructor);
    Instructor findInstructorById(Integer id);
    List<Instructor> findAllInstructors();
}
