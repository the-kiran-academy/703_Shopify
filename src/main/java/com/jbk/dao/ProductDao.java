package com.jbk.dao;

import java.util.List;
import com.jbk.entity.ProductEntity;

public interface ProductDao {

	public int addProduct(ProductEntity product);
	public ProductEntity getProductById(long productId);
	public List<ProductEntity> getAllProduct();
	public List<ProductEntity> deleteProduct(long productId);
	public ProductEntity updateProduct(ProductEntity productEntity);
	public List<ProductEntity> getAllProductsByOrder(String orderType, String propertyName);
	public ProductEntity getProductByName(String productName);
}
