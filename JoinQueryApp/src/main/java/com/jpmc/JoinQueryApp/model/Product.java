package com.jpmc.JoinQueryApp.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;
import java.math.BigInteger;

@Data
@AllArgsConstructor
public class Product {

    BigInteger productId;
    String productName;
    BigDecimal price;
    BigInteger customerId;
}
