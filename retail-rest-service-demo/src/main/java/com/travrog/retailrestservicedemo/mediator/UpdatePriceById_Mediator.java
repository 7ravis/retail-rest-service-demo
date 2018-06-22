package com.travrog.retailrestservicedemo.mediator;

import com.travrog.retailrestservicedemo.domain.Price;
import com.travrog.retailrestservicedemo.exception.IdNotFoundException;

/**
 * update a product's price
 */
public interface UpdatePriceById_Mediator {

    /**
     * @param id
     *            product id. cannot be null, empty, or contain only white space.
     * @param price
     *            new price. non-null.
     * @return updated product
     * @throws IdNotFoundException
     *             if provided id cannot be found in data source
     */
    void updatePriceById(String id, Price price) throws IdNotFoundException;

}
