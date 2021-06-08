package com.jai.shoppingcart.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jai.shoppingcart.entity.Order;
import com.jai.shoppingcart.entity.Product;
import com.jai.shoppingcart.model.CartInfo;
import com.jai.shoppingcart.model.Products;
import com.jai.shoppingcart.repository.OrderRepository;
import com.jai.shoppingcart.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private OrderRepository orderRepository;

	@Override
	public void saveProduct(CartInfo cartInfo) throws Exception {
		Product product = null;
		Order order = null;
		
		if (cartInfo.getUserId() != null) {
			order = orderRepository.getByUserId(cartInfo.getUserId());
		} else {
			throw new Exception("UserId is null, Please enter UserId");
		}
		
		if (null != order) {
			product = new Product();
			product.setCreated(cartInfo.getProducts().get(0).getCreated());
			product.setUpdated(cartInfo.getProducts().get(0).getUpdated());

			product.setId(cartInfo.getProducts().get(0).getId());
			product.setPrice(cartInfo.getProducts().get(0).getPrice());
			product.setDescription(cartInfo.getProducts().get(0).getDescription());
			product.setCategory(cartInfo.getProducts().get(0).getCategory());
			product.setOrder(order);

			productRepository.save(product);

		} else {
			// If User Id is not present, creating new order
			order = new Order();
			
			product = new Product();
			product.setCreated(cartInfo.getProducts().get(0).getCreated());
			product.setUpdated(cartInfo.getProducts().get(0).getUpdated());

			product.setId(cartInfo.getProducts().get(0).getId());
			product.setPrice(cartInfo.getProducts().get(0).getPrice());
			product.setDescription(cartInfo.getProducts().get(0).getDescription());
			product.setCategory(cartInfo.getProducts().get(0).getCategory());
			product.setOrder(order);

			order.getProducts().add(product);
			order.setUserId(cartInfo.getUserId());
			order.setCountryCode(cartInfo.getCountryCode());
			order.setCurrency(cartInfo.getCurrency());
			order.setCreated(cartInfo.getCreated());
			order.setUpdated(cartInfo.getCreated());

			orderRepository.save(order);

		}

	}

	@Override
	public CartInfo getOrders() {

		Order order = orderRepository.getByUserId("jai");

		CartInfo cartInfo = new CartInfo();
		cartInfo.setUserId(order.getUserId());
		cartInfo.setCountryCode(order.getCountryCode());
		cartInfo.setCurrency(order.getCurrency());
		cartInfo.setCreated(order.getCreated());
		cartInfo.setUpdated(order.getUpdated());
		List<Products> products = new ArrayList<>();

		for (Product product : order.getProducts()) {
			Products pro = new Products();
			pro.setId(product.getId());
			pro.setDescription(product.getDescription());
			pro.setPrice(product.getPrice());
			pro.setCreated(product.getCreated());
			pro.setUpdated(product.getUpdated());
			pro.setCategory(product.getCategory());
			products.add(pro);
		}
		cartInfo.setProducts(products);
		return cartInfo;

	}

	@Override
	public void updateProduct(CartInfo cartInfo, String productId) {

	Order order = this.orderRepository.getByProductId(productId);
		
		if (order != null) {
			Product product = order.getProducts().get(0);
			product.setCreated(cartInfo.getProducts().get(0).getCreated());
			product.setUpdated(cartInfo.getProducts().get(0).getUpdated());
			product.setPrice(cartInfo.getProducts().get(0).getPrice());
			product.setDescription(cartInfo.getProducts().get(0).getDescription());
			product.setCategory(cartInfo.getProducts().get(0).getCategory());
			List<Product> products = new ArrayList<>();
			products.add(product);
			order.setProducts(products);
			order.setUpdated(cartInfo.getUpdated());
			orderRepository.save(order);

		}

	}

	@Override
	public void deleteProductById(String productId) {
		Product product = null;
		if (productId != null) {
			product = this.productRepository.findById(productId);
		}
		if (product != null) {
			productRepository.delete(product);

		}

	}

	@Override
	public Products getProductById(String productId) {
		Product product = null;
		Products pro = null;
		if (productId != null) {
			product = this.productRepository.findById(productId);
		}
		if (product != null) {
			pro = new Products();
			pro.setId(product.getId());
			pro.setDescription(product.getDescription());
			pro.setPrice(product.getPrice());
			pro.setCreated(product.getCreated());
			pro.setUpdated(product.getUpdated());
			pro.setCategory(product.getCategory());

		}
		return pro;
	}

}
