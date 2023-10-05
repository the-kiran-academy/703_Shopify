package com.jbk.dao;

import java.util.List;

import com.jbk.model.Product;

public interface ProductDao {

	public int addProduct(Product product);
	public Product getProductById(long productId);
	public List<Product> getAllProduct();
	public List<Product> deleteProduct();
	public Product updateProduct();
}
