package com.travrog.retailrestservicedemo.data.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.travrog.retailrestservicedemo.domain.ProductPrice_MongoDbImpl;

/**
 * Spring-implemented interface for interacting with MongoDB database for {@link ProductPrice_MongoDbImpl} objects
 */
public interface ProductPriceRepository_MongoDb extends MongoRepository<ProductPrice_MongoDbImpl, String>{

}
