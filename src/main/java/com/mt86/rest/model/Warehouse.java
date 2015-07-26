package com.mt86.rest.model;

import java.io.Serializable;
import java.util.Set;

import com.mt86.rest.exception.ProductNotFoundException;


/**
 *Each warehouse can contain several products.
 * @author jack
 *
 */
public class Warehouse implements Serializable {
	private static final long serialVersionUID = 3944671568023013152L;
	private Integer id;
	private String name;
	private Set<Product> products;
	
	
	public Warehouse() {
		
	}
	
	public Warehouse(int id, String name) {
		this.id = id;
		this.name = name;
	}
	
	public Warehouse(int id, String name, Set<Product> products) {
		this.id = id;
		this.name = name;
		this.products = products;
	}

	
	
	public Integer getId() {
		return id;
	}

	
	public void setId(Integer id) {
		this.id = id;
	}

	
	public String getName() {
		return name;
	}

	
	public void setName(String name) {
		this.name = name;
	}

	public Set<Product> getProducts() {
		return products;
	}

	public void setProducts(Set<Product> products) {
		this.products = products;
	}
	
	/**
	 * Returns a product by its id. Throws an exception if the product can't be found.
	 * @param productId
	 * @return the requested product
	 */
	public Product getProduct(int productId) {
		for (Product product:products) {
			if (productId == product.getId()) {
				return product;
			}
		}
		throw new ProductNotFoundException(String.valueOf(productId));
	}
	
	/**
	 * Adds a product to the warehouse's inventory
	 * @param product
	 */
	public void addProduct(Product product) {
		products.add(product);
	}
	
	/**
	 * Removes an existing product from the warehouse's inventory
	 * @param productId
	 */
	public void removeProduct(int productId) {
		for (Product product:products) {
			if (productId == product.getId()) {
				products.remove(product);
				return;
			}
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Warehouse other = (Warehouse) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
}
