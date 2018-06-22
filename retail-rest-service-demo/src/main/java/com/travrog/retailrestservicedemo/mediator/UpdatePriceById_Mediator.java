package com.travrog.retailrestservicedemo.mediator;

import com.travrog.retailrestservicedemo.domain.Price;
import com.travrog.retailrestservicedemo.exception.IdNotFoundException;

/**
 * update a product's price
 */
public interface UpdatePriceById_Mediator {

    /**
     * @param id
     *            Product id. Cannot be null, empty, or contain only white space.
     * @param price
     *            New price. Non-null.
     * @throws IdNotFoundException
     *             if provided id cannot be found in data source
     */
    void updatePriceById(String id, Price price) throws IdNotFoundException;

}
