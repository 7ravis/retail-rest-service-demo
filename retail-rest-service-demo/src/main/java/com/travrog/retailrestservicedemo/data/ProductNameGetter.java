package com.travrog.retailrestservicedemo.data;

public interface ProductNameGetter {

	/**
	 * @param productId
	 * @return product name, or null if unable to obtain
	 */
	String getNameByProductId(long productId);
	
}
