package com.mybatis.model;

import lombok.Data;

@Data
public class Student {

    Integer id;
    String name;
    String phone;
    String email;
    Integer courseId;
}
