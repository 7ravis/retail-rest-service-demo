package com.travrog.retailrestservicedemo.data.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.travrog.retailrestservicedemo.domain.ProductPrice_MongoDbImpl;

public interface ProductPriceRepository_MongoDb extends MongoRepository<ProductPrice_MongoDbImpl, String>{

}
