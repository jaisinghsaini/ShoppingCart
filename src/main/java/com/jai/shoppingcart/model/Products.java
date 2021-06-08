package com.jai.shoppingcart.model;

import java.time.LocalDateTime;
import java.util.Date;

public class Products {
	private String id;
	private String description;
	private String category;
	private double price;
	private LocalDateTime created;
	private LocalDateTime updated;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}
	
	public LocalDateTime getCreated() {
		return created;
	}

	public void setCreated(LocalDateTime created) {
		this.created = created;
	}

	public LocalDateTime getUpdated() {
		return updated;
	}

	public void setUpdated(LocalDateTime updated) {
		this.updated = updated;
	}

	public Products() {
	}

	public Products(String id, String description, String category, double price, LocalDateTime created,
			LocalDateTime updated) {
		super();
		this.id = id;
		this.description = description;
		this.category = category;
		this.price = price;
		this.created = created;
		this.updated = updated;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

}
