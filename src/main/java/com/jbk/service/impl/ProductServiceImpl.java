package com.jbk.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jbk.dao.ProductDao;
import com.jbk.entity.ProductEntity;
import com.jbk.model.Product;
import com.jbk.service.ProductService;
import com.jbk.utility.EntityToModel;
import com.jbk.utility.ModelToEntity;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductDao dao;

	@Autowired
	private EntityToModel entityToModel;

	@Autowired
	private ModelToEntity modelToEntity;

	@Override
	public int addProduct(Product product) {

		return dao.addProduct(modelToEntity.convertToEntity(product));
	}

	@Override
	public List<Product> deleteProduct(long productId) {
		List<ProductEntity> list = dao.deleteProduct(productId);
		List<Product> modelList = new ArrayList<>();
		modelList = list.stream().map(entityToModel::convertToModel).collect(Collectors.toList());
		return modelList;
	}

	@Override
	public Product getProductById(long productId) {

		ProductEntity productEntity = dao.getProductById(productId);
		if (productEntity != null) {
			return entityToModel.convertToModel(productEntity);
		} else {
			return null;
		}
	}

	@Override
	public List<Product> getAllProduct() {
		List<ProductEntity> list = dao.getAllProduct();
		List<Product> modelList = new ArrayList<>();
		modelList = list.stream().map(entityToModel::convertToModel).collect(Collectors.toList());
		return modelList;
	}

	@Override
	public Product updateProduct(Product product) {
		ProductEntity updatedProduct = dao.updateProduct(modelToEntity.convertToEntity(product));
		return entityToModel.convertToModel(updatedProduct);
	}

}
