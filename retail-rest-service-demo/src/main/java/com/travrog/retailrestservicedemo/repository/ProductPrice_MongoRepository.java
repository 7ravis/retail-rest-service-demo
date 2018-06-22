package com.travrog.retailrestservicedemo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.travrog.retailrestservicedemo.domain.ProductPrice_MongoDbImpl;

public interface ProductPrice_MongoRepository extends MongoRepository<ProductPrice_MongoDbImpl, String>{

}
