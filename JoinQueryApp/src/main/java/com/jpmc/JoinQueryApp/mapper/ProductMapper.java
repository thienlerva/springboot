package com.jpmc.JoinQueryApp.mapper;

import com.jpmc.JoinQueryApp.model.Product;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProductMapper {

    List<Product> findAll();

    Product findById(Integer id);

    Integer insert(Product product);
}
