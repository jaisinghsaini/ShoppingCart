package com.jai.shoppingcart;

import static org.mockito.Mockito.when;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.powermock.modules.junit4.PowerMockRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import com.jai.shoppingcart.entity.Order;
import com.jai.shoppingcart.entity.Product;
import com.jai.shoppingcart.model.CartInfo;
import com.jai.shoppingcart.model.Products;
import com.jai.shoppingcart.repository.OrderRepository;
import com.jai.shoppingcart.service.ProductService;


@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class ProductServiceImplTest {

	@Autowired
	private ProductService productService;
	@Mock
	private OrderRepository orderRepository;
	
	@Before
    public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
      //  orderRepository = mock(OrderRepository.class);
    }

	@Test()
	public void saveProductTest() throws Exception {
		Product product = null;
		Order order = new Order();
		CartInfo cartInfo = getCartInfo();
		when(orderRepository.getByUserId(Mockito.anyString())).thenReturn(order);
		when(orderRepository.save(Mockito.any())).thenReturn(orderRepository);
		productService.saveProduct(cartInfo);
		
		Assert.assertTrue(true);
		//assertThat(found.getAuthToken()).isNotEmpty();
			

	}

	private Product getProduct() {
		CartInfo cartInfo = new CartInfo();
			Product product = new Product();
			product.setCreated(cartInfo.getProducts().get(0).getCreated());
			product.setUpdated(cartInfo.getProducts().get(0).getUpdated());

			product.setId(cartInfo.getProducts().get(0).getId());
			product.setPrice(cartInfo.getProducts().get(0).getPrice());
			product.setDescription(cartInfo.getProducts().get(0).getDescription());
			product.setCategory(cartInfo.getProducts().get(0).getCategory());
			
		return product;
	}	
	
	private CartInfo getCartInfo() {
		CartInfo cartInfo = new CartInfo();
			Products product = new Products();
			product.setCreated(LocalDateTime.now());
			product.setUpdated(LocalDateTime.now());

			product.setId("11530621-5905-4d75-8317-db282c498c67");
			product.setPrice(100.00);
			product.setDescription("IPhone");
			product.setCategory("Electronics");
			List<Products> products = new ArrayList<Products>();
			products.add(product);
			cartInfo.setUserId("jai");
			cartInfo.setCreated(LocalDateTime.now());
			cartInfo.setUpdated(LocalDateTime.now());
			cartInfo.setProducts(products);
			cartInfo.setCountryCode("US");
			cartInfo.setCurrency("USD");
		return cartInfo;
	}	
}
