package com.jai.shoppingcart.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.jai.shoppingcart.entity.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {

	@Query("SELECT o FROM Order o WHERE o.userId = ?1")
	Order getByUserId(String userId);
	@Query("FROM Order o, Product p WHERE p.id = ?1")
	Order getByProductId(String productId);
	
}