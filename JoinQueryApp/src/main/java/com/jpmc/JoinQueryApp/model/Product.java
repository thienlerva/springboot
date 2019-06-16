package com.jpmc.JoinQueryApp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.math.BigInteger;

@Getter
@Setter
@AllArgsConstructor
public class Product {

    BigInteger productId;
    String productName;
    BigDecimal price;
    BigInteger customerId;
}
