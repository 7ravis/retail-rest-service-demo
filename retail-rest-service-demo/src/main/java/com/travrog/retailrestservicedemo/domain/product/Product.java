package com.travrog.retailrestservicedemo.domain.product;

import com.travrog.retailrestservicedemo.domain.Price;

public interface Product {

    long getId();

    String getName();

    Price getCurrent_price();

}