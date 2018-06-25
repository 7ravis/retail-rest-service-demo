package com.travrog.retailrestservicedemo.mediator;

import com.travrog.retailrestservicedemo.data.IdNotFoundException;
import com.travrog.retailrestservicedemo.domain.Price;

/**
 * update a product's price
 */
public interface UpdatePriceById {

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
