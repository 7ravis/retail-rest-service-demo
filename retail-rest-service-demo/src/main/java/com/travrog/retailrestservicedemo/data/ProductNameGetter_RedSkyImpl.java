package com.travrog.retailrestservicedemo.data;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.web.client.RestTemplate;

/**
 * retrieve product name from redsky web service
 */
public class ProductNameGetter_RedSkyImpl implements ProductNameGetter {
	public static final String BASE_URL = "https://redsky.target.com/v2/pdp/tcin/";
	public static final String EXCLUSIONS = "?excludes=taxonomy,price,promotion,bulk_ship,rating_and_review_reviews,rating_and_review_statistics,question_answer_statistics,deep_red_labels,available_to_promise_network";

	@SuppressWarnings("rawtypes")
	@Override
	public String getNameByProductId(String productId) {
		String name = null;
		try {
			RestTemplate restTemplate = new RestTemplate();
			Map map = restTemplate.getForObject(constructDefaultEndpoint(productId), Map.class);
			LinkedHashMap product = (LinkedHashMap)map.get("product");
			LinkedHashMap item = (LinkedHashMap)product.get("item");
			LinkedHashMap description = (LinkedHashMap)item.get("product_description");
			name = (String) description.get("title");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return name;
	}

	private String constructDefaultEndpoint(String productId) {
		return BASE_URL + productId + EXCLUSIONS;
	}

}
