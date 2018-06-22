package com.travrog.retailrestservicedemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.travrog.retailrestservicedemo.data.ProductNameGetter;
import com.travrog.retailrestservicedemo.data.ProductNameGetter_RedSkyImpl;
import com.travrog.retailrestservicedemo.data.ProductPriceGetter;
import com.travrog.retailrestservicedemo.data.ProductPriceGetter_MongoDbImpl;
import com.travrog.retailrestservicedemo.mediator.GetProductById_Mediator;
import com.travrog.retailrestservicedemo.mediator.UpdatePriceById_Mediator;
import com.travrog.retailrestservicedemo.mediator.UpdatePriceById_Mediator_MongoDb;
import com.travrog.retailrestservicedemo.repository.ProductPrice_MongoRepository;

@Configuration
public class Beans {
	
	@Autowired
	ProductPrice_MongoRepository productPriceMongoRepository;

	@Bean
	UpdatePriceById_Mediator updatePriceByIdMediator() {
		return new UpdatePriceById_Mediator_MongoDb(productPriceMongoRepository);
	}
	
	@Bean
	ProductPriceGetter priceGetter() {
		return new ProductPriceGetter_MongoDbImpl(productPriceMongoRepository);
	}
	
	@Bean
	ProductNameGetter nameGetter() {
		return new ProductNameGetter_RedSkyImpl();
	}
	
	@Bean
	GetProductById_Mediator getProductByIdMediator() {
		return new GetProductById_Mediator(priceGetter(), nameGetter());
	}
	
}
