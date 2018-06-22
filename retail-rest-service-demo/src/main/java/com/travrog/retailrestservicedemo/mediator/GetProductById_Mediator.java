package com.travrog.retailrestservicedemo.mediator;

import com.travrog.retailrestservicedemo.domain.product.ValidProduct;
import com.travrog.retailrestservicedemo.exception.IdNotFoundException;

/**
 * get a product by id
 */
public interface GetProductById_Mediator {

    /**
     * @param id
     *            product id. cannot be null, empty, or contain only white space.
     * @return product matching the provided id
     * @throws IdNotFoundException
     *             if provided id cannot be found in data source
     */
    ValidProduct getProductById(String id) throws IdNotFoundException;

}
