package com.mt86.rest.exception;

/**
 * 
 * @author jack
 *
 */
public class ProductNotFoundException extends RuntimeException {
	private static final long serialVersionUID = -4372776309073614775L;

	public ProductNotFoundException(String productId) {
		super(productId);
	}
}
