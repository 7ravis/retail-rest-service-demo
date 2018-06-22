package com.travrog.retailrestservicedemo.data;

import java.util.Optional;

import com.travrog.retailrestservicedemo.domain.Price;
import com.travrog.retailrestservicedemo.domain.ProductPrice_MongoDbImpl;
import com.travrog.retailrestservicedemo.repository.ProductPrice_MongoRepository;

/**
 * retrieve product price from MongoDB NoSQL database
 */
public class ProductPriceGetter_MongoDbImpl implements ProductPriceGetter {
	private final ProductPrice_MongoRepository priceRepo;
	
	/**
	 * @param priceRepo non-null
	 */
	public ProductPriceGetter_MongoDbImpl(ProductPrice_MongoRepository priceRepo) {
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
