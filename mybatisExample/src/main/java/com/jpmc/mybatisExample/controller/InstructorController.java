package com.jpmc.mybatisExample.controller;

import com.jpmc.mybatisExample.Mapper.InstructorMapper;
import com.jpmc.mybatisExample.models.Instructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class InstructorController {

//    @Autowired
//    InstructorMapper instructorMapper;
//
//    @GetMapping("/all")
//    public List<Instructor> findAll() {
//        return instructorMapper.findAllInstructors();
//    }
}
