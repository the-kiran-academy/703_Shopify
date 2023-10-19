package com.jbk.service;

import java.util.List;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import com.jbk.model.Product;

public interface ProductService {
	
	public int addProduct(Product product);
	public List<Product> deleteProduct(long productId);
	public Product getProductById(long productId);
	public Product getproductByName(String productName);
	public List<Product> getAllProduct();
	public Product updateProduct(Product product);
	
	public List<Product>  getAllProductsByOrder(String orderType,String propertyName);
	
	public Map<String, Object> uploadSheet(MultipartFile file);
	
	
}
