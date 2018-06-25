package com.travrog.retailrestservicedemo.domain;

/**
 * interface for retail products
 */
public interface Product {

    String getId();

    String getName();

    Price getCurrent_price();

}
