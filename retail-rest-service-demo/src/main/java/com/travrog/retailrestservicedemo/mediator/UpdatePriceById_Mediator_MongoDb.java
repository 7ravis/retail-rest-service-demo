package com.travrog.retailrestservicedemo.mediator;

import java.util.Optional;

import com.travrog.retailrestservicedemo.domain.Price;
import com.travrog.retailrestservicedemo.domain.ProductPrice_MongoDbImpl;
import com.travrog.retailrestservicedemo.exception.IdNotFoundException;
import com.travrog.retailrestservicedemo.repository.ProductPrice_MongoRepository;

public class UpdatePriceById_Mediator_MongoDb implements UpdatePriceById_Mediator {
	private final ProductPrice_MongoRepository repository;

	/**
	 * @param repository non-null
	 */
	public UpdatePriceById_Mediator_MongoDb(ProductPrice_MongoRepository repository) {
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
