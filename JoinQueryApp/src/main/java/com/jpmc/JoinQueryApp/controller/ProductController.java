package com.jpmc.JoinQueryApp.controller;

import com.jpmc.JoinQueryApp.mapper.ProductMapper;
import com.jpmc.JoinQueryApp.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.List;
import java.util.Random;


@RestController
@RequestMapping(value="/product")
public class ProductController {

    @Autowired
    ProductMapper productMapper;


    @GetMapping("/all")
    List<Product> findAll() {
        return productMapper.findAll();
    }

    @PostMapping("/insert")
    Integer insert(@RequestBody @Validated Product product) {
        Random random = new Random();

        product.setProductId(BigInteger.valueOf(random.nextInt(1000)));
        return productMapper.insert(product);
    }
}
