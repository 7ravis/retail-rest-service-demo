package com.travrog.retailrestservicedemo.mediator;

import java.util.Optional;

import com.travrog.retailrestservicedemo.data.IdNotFoundException;
import com.travrog.retailrestservicedemo.data.repository.ProductPriceRepository_MongoDb;
import com.travrog.retailrestservicedemo.domain.Price;
import com.travrog.retailrestservicedemo.domain.ProductPrice_MongoDbImpl;

public class UpdatePriceById_MongoDb implements UpdatePriceById {
	private final ProductPriceRepository_MongoDb repository;

	/**
	 * @param repository non-null
	 */
	public UpdatePriceById_MongoDb(ProductPriceRepository_MongoDb repository) {
		if (repository == null) {
			throw new IllegalArgumentException("Repository cannot be null.");
		}
		this.repository = repository;
	}

	@Override
	public void updatePriceById(String id, Price price) throws IdNotFoundException {
		if (id == null || id.trim().isEmpty())
			throw new IllegalArgumentException("Id cannot be null, empty, or contain only white space: id=" + id);
		if (price == null)
			throw new IllegalArgumentException("Price cannot be null.");

		Optional<ProductPrice_MongoDbImpl> optional = repository.findById(id);
		if (!optional.isPresent())
			throw new IdNotFoundException();
		
		ProductPrice_MongoDbImpl productPrice = new ProductPrice_MongoDbImpl(id, price);
		repository.save(productPrice);
	}

}
