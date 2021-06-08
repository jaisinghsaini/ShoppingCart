package com.jai.shoppingcart.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jai.shoppingcart.model.CartInfo;
import com.jai.shoppingcart.model.Products;
import com.jai.shoppingcart.service.ProductService;

@RestController
@RequestMapping("/api")
public class ShoppingCartController {

	@Autowired
	private ProductService productService;

	//Return all products in a Order. Single order is collection of products
	@GetMapping("/carts")
	public CartInfo getCart() {
		return productService.getOrders();
		
	}

	// Creating new Order
	@PostMapping("/carts")
	public String addProduct(@RequestBody CartInfo cartInfo) throws Exception {
		productService.saveProduct(cartInfo);
		return "Product has been added in order";
	}

	//Updating a product
	@PutMapping("/carts/{cartId}/products")
	public String updateProduct(@PathVariable("cartId") String cartId, @RequestBody CartInfo cartInfo) {
		productService.updateProduct(cartInfo, cartId);
		return "Product has been updated";
	}
	
	//Deleting a product
	@DeleteMapping("/carts/{cartId}/products")
	public String deleteProduct(@PathVariable("cartId") String cartId) {
		productService.deleteProductById(cartId);
		return "Product has been deleted";
	}

	// Fetching a product
	@GetMapping("/carts/{cartId}/products")
	public Products getProduct(@PathVariable("cartId") String cartId) {
		return productService.getProductById(cartId);
		
	}
}
