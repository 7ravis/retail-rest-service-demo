package com.travrog.retailrestservicedemo.mediator;

import com.travrog.retailrestservicedemo.data.ProductNameGetter;
import com.travrog.retailrestservicedemo.data.ProductPriceGetter;
import com.travrog.retailrestservicedemo.domain.Price;
import com.travrog.retailrestservicedemo.domain.product.ClientFacingProduct;
import com.travrog.retailrestservicedemo.exception.IdNotFoundException;

public class GetProductById_Mediator {
	private final ProductPriceGetter priceGetter;
	private final ProductNameGetter nameGetter;
	
	/**
	 * @param priceGetter non-null
	 * @param nameGetter non-null
	 */
	public GetProductById_Mediator(ProductPriceGetter priceGetter, ProductNameGetter nameGetter) {
		if (priceGetter == null)
			throw new IllegalArgumentException("Price getter cannot be null.");
		if (nameGetter == null)
			throw new IllegalArgumentException("Name getter cannot be null.");
		
		this.priceGetter = priceGetter;
		this.nameGetter = nameGetter;
	}



	public ClientFacingProduct getProductById(String id) throws IdNotFoundException {
		if (id == null || id.trim().isEmpty())
			throw new IllegalArgumentException("Id cannot be null, empty, or contain only white space.");
		
		String name = nameGetter.getNameByProductId(id);
		Price price = priceGetter.getPriceByProductId(id);
		if (name == null || price == null)
			throw new IdNotFoundException();
		return new ClientFacingProduct(id, name, price);
	}

}