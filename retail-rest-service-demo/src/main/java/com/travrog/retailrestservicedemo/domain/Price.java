package com.travrog.retailrestservicedemo.domain;

import java.math.BigDecimal;

import com.travrog.retailrestservicedemo.domain.ProductEnums.currency_code;

/**
 * monetary price. differs from {@link ProductPrice} implementations because this class is not intended to contain any product identifier.
 */
public class Price {
    private final BigDecimal value;
    private final currency_code currency_code;

    public Price(BigDecimal value, currency_code currency_code) {
	this.value = value;
	this.currency_code = currency_code;
    }

    public BigDecimal getValue() {
	return value;
    }

    public currency_code getCurrency_code() {
	return currency_code;
    }

    @Override
    public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((currency_code == null) ? 0 : currency_code.hashCode());
	result = prime * result + ((value == null) ? 0 : value.hashCode());
	return result;
    }

    @Override
    public boolean equals(Object obj) {
	if (this == obj)
	    return true;
	if (obj == null)
	    return false;
	if (getClass() != obj.getClass())
	    return false;
	Price other = (Price) obj;
	if (currency_code != other.currency_code)
	    return false;
	if (value == null) {
	    if (other.value != null)
		return false;
	} else if (!value.equals(other.value))
	    return false;
	return true;
    }

    @Override
    public String toString() {
	return "Price [value=" + value + ", currency_code=" + currency_code + "]";
    }

}
