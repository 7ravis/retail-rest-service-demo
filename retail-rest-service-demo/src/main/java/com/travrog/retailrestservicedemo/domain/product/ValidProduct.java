package com.travrog.retailrestservicedemo.domain.product;

import org.springframework.data.annotation.Id;

import com.travrog.retailrestservicedemo.domain.Price;

/**
 * {@link Product} implementation for complete and valid products (not product
 * queries or incomplete products)
 */
public class ValidProduct implements Product {
    @Id
    private final long id;
    private final String name;
    private final Price current_price;

    /**
     * @param id
     *            cannot be less than 1
     * @param name
     *            cannot be null, empty, or contain only white space
     * @param current_price
     *            cannot be null
     */
    public ValidProduct(long id, String name, Price current_price) {
	// validate input
	if (id < 1)
	    throw new IllegalArgumentException("id cannot be less than 1: id=" + id + " name=" + name);
	if (name == null || name.trim().isEmpty())
	    throw new IllegalArgumentException(
		    "name cannot be null, empty, or contain only white space: id=" + id + " name=" + name);
	if (current_price == null)
	    throw new IllegalArgumentException("price cannot be null: id=" + id + " name=" + name);

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
	ValidProduct other = (ValidProduct) obj;
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
	return "ValidProduct [id=" + id + ", name=" + name + ", current_price=" + current_price + "]";
    }

}
