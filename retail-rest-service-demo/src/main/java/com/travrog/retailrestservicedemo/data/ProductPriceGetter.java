package com.travrog.retailrestservicedemo.data;

import com.travrog.retailrestservicedemo.domain.Price;

public interface ProductPriceGetter {

	/**
	 * @param productId cannot be null, empty, or contain only white space
	 * @return product price, or null if unable to obtain
	 */
	Price getPriceByProductId(String productId);
	
}
