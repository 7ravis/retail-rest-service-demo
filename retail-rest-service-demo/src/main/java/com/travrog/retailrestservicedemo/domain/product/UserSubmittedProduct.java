package com.travrog.retailrestservicedemo.domain.product;

import com.travrog.retailrestservicedemo.domain.Price;

/**
 * {@link Product} implementation for data submitted by the user/client. data
 * may be missing or erroneous.
 */
public class UserSubmittedProduct implements Product {
    private long id;
    private String name;
    private Price current_price;

    /**
     * @param id
     *            not validated
     * @param name
     *            not validated
     * @param current_price
     *            not validated
     */
    public UserSubmittedProduct(long id, String name, Price current_price) {
	this.id = id;
	this.name = name;
	this.current_price = current_price;
    }

    @Override
    public long getId() {
	return id;
    }

    @Override
    public String getName() {
	return name;
    }

    @Override
    public Price getCurrent_price() {
	return current_price;
    }

    public void setId(long id) {
	this.id = id;
    }

    public void setName(String name) {
	this.name = name;
    }

    public void setCurrent_price(Price current_price) {
	this.current_price = current_price;
    }

    @Override
    public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((current_price == null) ? 0 : current_price.hashCode());
	result = prime * result + (int) (id ^ (id >>> 32));
	result = prime * result + ((name == null) ? 0 : name.hashCode());
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
	UserSubmittedProduct other = (UserSubmittedProduct) obj;
	if (current_price == null) {
	    if (other.current_price != null)
		return false;
	} else if (!current_price.equals(other.current_price))
	    return false;
	if (id != other.id)
	    return false;
	if (name == null) {
	    if (other.name != null)
		return false;
	} else if (!name.equals(other.name))
	    return false;
	return true;
    }

    @Override
    public String toString() {
	return "UserSubmittedProduct [id=" + id + ", name=" + name + ", current_price=" + current_price + "]";
    }

}
