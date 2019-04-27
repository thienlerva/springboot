package com.jpmc.JoinQueryApp.controller;

import com.jpmc.JoinQueryApp.mapper.CustomerMapper;
import com.jpmc.JoinQueryApp.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/customer")
public class CustomerController {

    @Autowired
    CustomerMapper customerMapper;

    @GetMapping("/all")
    List<Customer> findAll() {
        return customerMapper.findAll();
    }
}
