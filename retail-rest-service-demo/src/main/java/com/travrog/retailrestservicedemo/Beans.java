package com.travrog.retailrestservicedemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.travrog.retailrestservicedemo.data.ProductNameGetter;
import com.travrog.retailrestservicedemo.data.ProductNameGetter_RedSky;
import com.travrog.retailrestservicedemo.data.ProductPriceGetter;
import com.travrog.retailrestservicedemo.data.ProductPriceGetter_MongoDb;
import com.travrog.retailrestservicedemo.data.repository.ProductPriceRepository_MongoDb;
import com.travrog.retailrestservicedemo.mediator.GetProductById;
import com.travrog.retailrestservicedemo.mediator.UpdatePriceById;
import com.travrog.retailrestservicedemo.mediator.UpdatePriceById_MongoDb;

/**
 * define dependencies/plugins for main application
 */
@Configuration
public class Beans {
	
	@Autowired
	ProductPriceRepository_MongoDb productPriceMongoRepository;

	@Bean
	UpdatePriceById updatePriceByIdMediator() {
		return new UpdatePriceById_MongoDb(productPriceMongoRepository);
	}
	
	@Bean
	ProductPriceGetter priceGetter() {
		return new ProductPriceGetter_MongoDb(productPriceMongoRepository);
	}
	
	@Bean
	ProductNameGetter nameGetter() {
		return new ProductNameGetter_RedSky();
	}
	
	@Bean
	GetProductById getProductByIdMediator() {
		return new GetProductById(priceGetter(), nameGetter());
	}
	
}
