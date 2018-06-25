package com.travrog.retailrestservicedemo.data;

import java.util.Optional;

import com.travrog.retailrestservicedemo.data.repository.ProductPriceRepository_MongoDb;
import com.travrog.retailrestservicedemo.domain.Price;
import com.travrog.retailrestservicedemo.domain.ProductPrice_MongoDbImpl;

/**
 * retrieve product price from MongoDB NoSQL database
 */
public class ProductPriceGetter_MongoDb implements ProductPriceGetter {
	private final ProductPriceRepository_MongoDb priceRepo;
	
	/**
	 * @param priceRepo non-null
	 */
	public ProductPriceGetter_MongoDb(ProductPriceRepository_MongoDb priceRepo) {
		if (priceRepo == null)
			throw new IllegalArgumentException("price repository cannot be null");
		
		this.priceRepo = priceRepo;
	}



	@Override
	public Price getPriceByProductId(String productId) {
		Optional<ProductPrice_MongoDbImpl> optional = priceRepo.findById(productId);
		if (optional.isPresent()) {
			return optional.get().getCurrent_price();
		} else {
			return null;
		}
	}

}
