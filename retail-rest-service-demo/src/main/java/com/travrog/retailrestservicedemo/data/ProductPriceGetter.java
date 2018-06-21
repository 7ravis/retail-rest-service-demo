package com.travrog.retailrestservicedemo.data;

import com.travrog.retailrestservicedemo.domain.Price;

public interface ProductPriceGetter {

	Price getPriceByProductId(long productId);
	
}
