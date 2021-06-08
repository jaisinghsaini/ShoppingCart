package com.jai.shoppingcart.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.jai.shoppingcart.entity.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Integer> {

	@Query("SELECT p FROM Product p WHERE p.id = ?1")
	Product findById(String code);
	
	@Query("DELETE FROM Product p WHERE p.id = ?1")
	void deleteById(String code);

}
