package com.travrog.retailrestservicedemo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.travrog.retailrestservicedemo.domain.product.ValidProduct;

public interface ValidProductRepository extends MongoRepository<ValidProduct, Long> {

}
