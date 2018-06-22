package com.travrog.retailrestservicedemo.data;

import java.util.Optional;

import com.travrog.retailrestservicedemo.domain.Price;
import com.travrog.retailrestservicedemo.domain.ProductPrice;
import com.travrog.retailrestservicedemo.repository.ProductPriceRepository;

/**
 * retrieve product price from MongoDB NoSQL database
 */
public class ProductPriceGetter_MongoDbImpl implements ProductPriceGetter {
	private final ProductPriceRepository priceRepo;
	
	/**
	 * @param priceRepo non-null
	 */
	public ProductPriceGetter_MongoDbImpl(ProductPriceRepository priceRepo) {
		if (priceRepo == null)
			throw new IllegalArgumentException("price repository cannot be null");
		
		this.priceRepo = priceRepo;
	}



	@Override
	public Price getPriceByProductId(long productId) {
		Optional<ProductPrice> optional = priceRepo.findById(productId);
		if (optional.isPresent()) {
			return optional.get().getCurrent_price();
		} else {
			return null;
		}
	}

}
