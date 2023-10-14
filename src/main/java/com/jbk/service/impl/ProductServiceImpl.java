package com.jbk.service.impl;

import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jbk.dao.ProductDao;
import com.jbk.entity.ProductEntity;
import com.jbk.model.Product;
import com.jbk.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductDao dao;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public int addProduct(Product product) {

		return dao.addProduct(modelMapper.map(product, ProductEntity.class));
	}

	@Override
	public List<Product> deleteProduct(long productId) {
		List<ProductEntity> list = dao.deleteProduct(productId);
		return list.stream().map(productEntity -> modelMapper.map(productEntity, Product.class))
				.collect(Collectors.toList());
	}

	@Override
	public Product getProductById(long productId) {

		ProductEntity productEntity = dao.getProductById(productId);
		if (productEntity != null) {
			return modelMapper.map(productEntity, Product.class);
		} else {
			return null;
		}
	}

	@Override
	public List<Product> getAllProduct() {
		List<ProductEntity> list = dao.getAllProduct();
		return list.stream().map(productEntity -> modelMapper.map(productEntity, Product.class))
				.collect(Collectors.toList());
	}

	@Override
	public Product updateProduct(Product product) {
		ProductEntity updatedProduct = dao.updateProduct(modelMapper.map(product, ProductEntity.class));
		return modelMapper.map(updatedProduct, Product.class);
	}

}
