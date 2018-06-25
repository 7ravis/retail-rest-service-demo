package com.travrog.retailrestservicedemo.domain;

import org.springframework.data.annotation.Id;

/**
 * data transfer object for use with {@link ProductPriceGetter_MongoDb}
 */
public class ProductPrice_MongoDbImpl implements ProductPrice {
    @Id
    private final String id;
    private final Price current_price;
    
	/**
	 * @param id product id. cannot be null, empty, or contain only white space.
	 * @param current_price non-null
	 */
	public ProductPrice_MongoDbImpl(String id, Price current_price) {
		if (id  == null || id.trim().isEmpty())
			throw new IllegalArgumentException("id cannot be null, empty, or contain only white space: id=" + id);
		if (current_price == null)
		    throw new IllegalArgumentException("price cannot be null: id=" + id);
		
		this.id = id;
		this.current_price = current_price;
	}

	public String getId() {
		return id;
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
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		ProductPrice_MongoDbImpl other = (ProductPrice_MongoDbImpl) obj;
		if (current_price == null) {
			if (other.current_price != null)
				return false;
		} else if (!current_price.equals(other.current_price))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ProductPrice [id=" + id + ", current_price=" + current_price + "]";
	}

}
