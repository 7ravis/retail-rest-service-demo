package com.travrog.retailrestservicedemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.travrog.retailrestservicedemo.data.IdNotFoundException;
import com.travrog.retailrestservicedemo.domain.Price;
import com.travrog.retailrestservicedemo.domain.Product_ClientFacing;
import com.travrog.retailrestservicedemo.mediator.GetProductById;
import com.travrog.retailrestservicedemo.mediator.UpdatePriceById;

@RestController
@RequestMapping("/products")
public class ProductController {

	@Autowired
	UpdatePriceById updatePriceByIdMediator;

	@Autowired
	GetProductById getProductByIdMediator;


	@GetMapping("/{id}")
	ResponseEntity<?> findProductById(@PathVariable String id) {
		try {
			Product_ClientFacing product = getProductByIdMediator.getProductById(id);
			return new ResponseEntity(product, HttpStatus.OK);
		} catch (IdNotFoundException e) {
			e.printStackTrace();
			return new ResponseEntity("The resource for the provided id could not be located.", HttpStatus.BAD_REQUEST);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity("An unexpected problem occurred. Please contact support.", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/{id}")
	ResponseEntity<?> updateProductById(@RequestBody Price
			price, @PathVariable String id) {
		try {
			updatePriceByIdMediator.updatePriceById(id, price);
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		} catch (IdNotFoundException e) {
			e.printStackTrace();
			return new ResponseEntity("The resource for the provided id could not be located.", HttpStatus.BAD_REQUEST);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity("An unexpected problem occurred. Please contact support.", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
