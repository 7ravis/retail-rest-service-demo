package com.travrog.retailrestservicedemo.domain;

/**
 * central location for product-related enums
 */
public class ProductEnums {

    public enum currency_code {
	USD("United States dollar");

	private final String fullName;

	private currency_code(String fullName) {
	    this.fullName = fullName;
	}

	public String getFullName() {
	    return fullName;
	}
    }

}
