package com.infinitefashion.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Cart")
public class Cart {
	
	@Id
	private int id;
	private String productName;
	private String Description;
	private double price;
	
	public Cart() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Cart(int id, String productName, String description, double price) {
		super();
		this.id = id;
		this.productName = productName;
		Description = description;
		this.price = price;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}

	
	
}
