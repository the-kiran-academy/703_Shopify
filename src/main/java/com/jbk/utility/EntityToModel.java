package com.jbk.utility;

import org.springframework.stereotype.Component;

import com.jbk.entity.CategoryEntity;
import com.jbk.entity.ProductEntity;
import com.jbk.entity.SupplierEntity;
import com.jbk.model.Category;
import com.jbk.model.Product;
import com.jbk.model.Supplier;

@Component
public class EntityToModel {

	public Category convertToModel(CategoryEntity entity) {

		Category category = new Category();
		category.setCategoryId(entity.getCategoryId());
		category.setCategoryName(entity.getCategoryName());
		category.setDeliveryCharge(entity.getDeliveryCharge());
		category.setDiscount(entity.getDiscount());
		category.setDiscription(entity.getDiscription());
		category.setGst(entity.getGst());

		return category;

	}

	public Supplier convertToModel(SupplierEntity entity) {
		Supplier supplier = new Supplier();
		

		supplier.setSupplierId(entity.getSupplierId());
		supplier.setSupplierName(entity.getSupplierName());
		supplier.setPostalCode(entity.getPostalCode());
		supplier.setMobileNo(entity.getMobileNo());
		supplier.setCountryName(entity.getCountryName());
		supplier.setCity(entity.getCity());

		return supplier;

	}

	public Product convertToModel(ProductEntity entity) {
		Product product = new Product();

		product.setProductId(entity.getProductId());
		product.setProductName(entity.getProductName());
		product.setProductPrice(entity.getProductPrice());
		product.setProductQty(entity.getProductQty());

		product.setCategory(convertToModel(entity.getCategory()));
		product.setSupplier(convertToModel(entity.getSupplier()));

		return product;
	}

}
