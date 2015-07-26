package com.mt86.rest.test;

import static org.junit.Assert.*;

import java.net.URI;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.mt86.rest.model.Product;
import com.mt86.rest.model.Warehouse;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:context/*-context.xml")
public class WareHourseTest {
	private static final int WAREHOUSE_ID = 1;
	private static final int PRODUCT_ID = 4;
	@Autowired
	RestTemplate restTemplate ;
	
	@Test
	public void getWarehouse(){
		String uri="http://localhost:8080/springmvc_rest/spring/w/{wid}";
		Warehouse warehouse  = restTemplate.getForObject(uri, Warehouse.class,WAREHOUSE_ID);
		
		assertNotNull(warehouse);
		assertEquals("W_004", warehouse.getName());
	}
	/*
	@Test
	public void addProduct() {
		String uri = "http://localhost:8080/springmvc_rest/spring/w/{wid}/p";
		Product product = new Product(PRODUCT_ID, "PROD_999");
		URI newProductLocation = restTemplate.postForLocation(uri, product, WAREHOUSE_ID);
		
		Product createdProduct = restTemplate.getForObject(newProductLocation, Product.class);
		assertEquals(product, createdProduct);
		assertNotNull(createdProduct.getId());
	}
	
	@Test
	public void removeProduct() {
		String uri = "http://localhost:8080/springmvc_rest/spring/w/{wid}/p/{pid}";
		restTemplate.delete(uri, WAREHOUSE_ID, PRODUCT_ID);
		
		try {
			restTemplate.getForObject(uri, Product.class, WAREHOUSE_ID, PRODUCT_ID);
			throw new AssertionError("Should have returned an 404 error code");
		} catch (HttpClientErrorException e) {
			assertEquals(HttpStatus.NOT_FOUND, e.getStatusCode());
		}
	}*/
}
