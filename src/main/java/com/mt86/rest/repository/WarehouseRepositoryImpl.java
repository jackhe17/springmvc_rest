package com.mt86.rest.repository;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.springframework.stereotype.Repository;

import com.mt86.rest.model.Product;
import com.mt86.rest.model.Warehouse;


/**
 * A stub repository that uses dummy data for testing
 * @author jack
 *
 */
@Repository
public class WarehouseRepositoryImpl implements WarehouseRepository {
	private Map<Integer, Warehouse> warehouses;
	
	
	public WarehouseRepositoryImpl() {
		warehouses = new HashMap<Integer, Warehouse>();
		createDummyWarehouses();
	}

	public Warehouse getWarehouse(Integer id) {
		return warehouses.get(id);
	}

	public void createWarehouse(Warehouse warehouse) {
		warehouses.put(warehouse.getId(), warehouse);
	}

	public void removeWarehouse(int warehouseId) {
		warehouses.remove(warehouseId);
	}

	public Set<Product> getProducts(int warehouseId) {
		return warehouses.get(warehouseId).getProducts();
	}

	public Product getProduct(int warehouseId, int productId) {
		return warehouses.get(warehouseId).getProduct(productId);
	}

	public void addProduct(int warehouseId, Product product) {
		warehouses.get(warehouseId).addProduct(product);
	}

	public void removeProduct(int warehouseId, int productId) {
		warehouses.get(warehouseId).removeProduct(productId);
	}

	private void createDummyWarehouses() {
		Set<Product> products = new HashSet<Product>();
		Product product = new Product(1, "PROD_004");
		products.add(product);
		product = new Product(2, "PROD_015");
		products.add(product);
		product = new Product(3, "PROD_125");
		products.add(product);
		Warehouse warehouse = new Warehouse(1, "W_004", products);
		
		warehouses.put(1, warehouse);
	}
}
