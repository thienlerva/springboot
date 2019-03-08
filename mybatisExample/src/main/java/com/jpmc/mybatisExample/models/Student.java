package com.jpmc.mybatisExample.models;

import lombok.Data;

@Data
public class Student {

    Long id;
    String name;
    String passport;
    Long instructorId;
}
