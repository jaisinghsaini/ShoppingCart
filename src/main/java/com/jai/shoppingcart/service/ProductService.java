package com.jai.shoppingcart.service;

import com.jai.shoppingcart.model.CartInfo;
import com.jai.shoppingcart.model.Products;

public interface ProductService {

	void saveProduct(CartInfo cartInfo) throws Exception;

	CartInfo getOrders();
	
	void deleteProductById(String code);

	void updateProduct(CartInfo cartInfo, String cartId);

	Products getProductById(String cartId);

}
