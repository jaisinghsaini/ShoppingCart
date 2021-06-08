package com.jai.shoppingcart.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "products")
public class Product implements Serializable {

	private static final long serialVersionUID = 787523665600241461L;

	@Id
	@Column(name = "id", length = 36, nullable = false)
	private String id;

	@Column(name = "description", length = 255, nullable = false)
	private String description;

	@Column(name = "category", length = 25, nullable = false)
	private String category;

	@Column(name = "price", nullable = false)
	private double price;

	@Column(name = "created", nullable = false)
	private LocalDateTime created;

	@Column(name = "updated", nullable = false)
	private LocalDateTime updated;
	
		
	/*
	 * @ManyToOne(fetch = FetchType.LAZY, optional = false)
	 * 
	 * @JoinColumn(name = "order_id", nullable = false)
	 */
	@ManyToOne
	@JoinColumn(name="order_id")
	private Order order;
	
	/*
	 * @ManyToOne
	 * 
	 * @JoinColumn(name = "order_id") private Product product;
	 */
	

	public Product() {
	}
	
	

	public Product(String id, String description, String category, double price, LocalDateTime created,
			LocalDateTime updated, Order order) {
		super();
		this.id = id;
		this.description = description;
		this.category = category;
		this.price = price;
		this.created = created;
		this.updated = updated;
		this.order = order;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

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
	
	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}
	
}
