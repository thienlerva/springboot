package com.jpmc.JoinQueryApp.model;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.math.BigInteger;

@Getter
@Setter
public class JoinProduct {

    BigInteger productId;
    String productName;
    BigDecimal price;
    BigInteger customerId;
    String customerName;
}
