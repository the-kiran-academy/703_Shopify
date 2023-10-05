package com.jbk.service;

import java.util.List;

import com.jbk.model.Product;

public interface ProductService {
	
	public int saveProduct(Product product);
	public List<Product> deleteProduct(long productId);
	public Product getProductById(long productId);
	public List<Product> getAllProduct();
	public Product updateProduct(Product product);

}
