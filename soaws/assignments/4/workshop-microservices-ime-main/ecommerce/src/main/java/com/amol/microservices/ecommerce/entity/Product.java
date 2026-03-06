package com.amol.microservices.ecommerce.entity;

import lombok.Setter;
import lombok.Getter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class Product {

	private Long id;
	private int productId;
	private String name;
	private String description;
	private double price;

	// Getters and setters generated with lombok
}
