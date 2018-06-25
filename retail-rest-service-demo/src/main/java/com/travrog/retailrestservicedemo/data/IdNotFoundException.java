package com.travrog.retailrestservicedemo.data;

/**
 * for operations that depend on an entity's id, but that id cannot be found in
 * the data source
 */
public class IdNotFoundException extends Exception {

    /**
     * for operations that depend on an entity's id, but that id cannot be found in
     * the data source
     */
    public IdNotFoundException() {
	super();
    }

}
