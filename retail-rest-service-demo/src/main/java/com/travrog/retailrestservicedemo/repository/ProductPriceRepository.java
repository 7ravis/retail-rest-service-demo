package com.travrog.retailrestservicedemo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.travrog.retailrestservicedemo.domain.ProductPrice;

public interface ProductPriceRepository extends MongoRepository<ProductPrice, Long>{

}
