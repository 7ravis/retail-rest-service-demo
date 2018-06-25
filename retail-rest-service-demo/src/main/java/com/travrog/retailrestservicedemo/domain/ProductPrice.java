package com.travrog.retailrestservicedemo.domain;

/**
 * monetary price for a retail product. differs from {@link Price} because this class is intended to hold a product identifier and interface with a product data store.
 */
public interface ProductPrice {

	Price getCurrent_price();
	
}