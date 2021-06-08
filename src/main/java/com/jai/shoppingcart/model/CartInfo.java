package com.jai.shoppingcart.model;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

public class CartInfo {
	private String userId;
	private String countryCode;
	private String currency;
	private LocalDateTime created;
	private LocalDateTime updated;
	private List<Products> products;
	
	
	
	public CartInfo(String orderId, String userId, String countryCode, String currency, LocalDateTime created,
			LocalDateTime updated, List<Products> products) {
		this.userId = userId;
		this.countryCode = countryCode;
		this.currency = currency;
		this.created = created;
		this.updated = updated;
		this.products = products;
	}
	
	public CartInfo() {
		// TODO Auto-generated constructor stub
	}

	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getCountryCode() {
		return countryCode;
	}
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
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

	public List<Products> getProducts() {
		return products;
	}
	public void setProducts(List<Products> products) {
		this.products = products;
	}

	
}
