package com.travrog.retailrestservicedemo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.travrog.retailrestservicedemo.domain.product.ClientFacingProduct;

public interface ValidProductRepository extends MongoRepository<ClientFacingProduct, Long> {

}
