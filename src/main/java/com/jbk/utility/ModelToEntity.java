package com.jbk.utility;

import org.springframework.stereotype.Component;

import com.jbk.entity.Category;
import com.jbk.model.CategoryModel;

@Component
public class ModelToEntity {

	public Category  modelToEntity(CategoryModel categoryModel){
		Category categoryEntity=new Category();
		
		categoryEntity.setCategoryId(categoryModel.getCategoryId());
		categoryEntity.setCategoryName(categoryModel.getCategoryName());
		categoryEntity.setDeliveryCharges(categoryModel.getDeliveryCharges());
		categoryEntity.setDiscount(categoryModel.getDiscount());
		categoryEntity.setDiscription(categoryModel.getDiscription());
		categoryEntity.setGst(categoryModel.getGst());
		
		return categoryEntity;
		
	}
}
