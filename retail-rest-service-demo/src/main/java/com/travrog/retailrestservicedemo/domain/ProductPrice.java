package com.travrog.retailrestservicedemo.domain;

import org.springframework.data.annotation.Id;

/**
 * return value used with {@link ProductPriceGetter}
 */
public class ProductPrice {
    @Id
    private long id;
    private Price current_price;
    
    public ProductPrice() {}
    
	/**
	 * @param id product id number. cannot be less than 1.
	 * @param current_price non-null
	 */
	public ProductPrice(long id, Price current_price) {
		if (id < 1)
			throw new IllegalArgumentException("id cannot be less than 1: id=" + id);
		if (current_price == null)
		    throw new IllegalArgumentException("price cannot be null: id=" + id);
		
		this.current_price = current_price;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Price getCurrent_price() {
		return current_price;
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
		ProductPrice other = (ProductPrice) obj;
		if (current_price == null) {
			if (other.current_price != null)
				return false;
		} else if (!current_price.equals(other.current_price))
			return false;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ProductPrice [id=" + id + ", current_price=" + current_price + "]";
	}
    
}
