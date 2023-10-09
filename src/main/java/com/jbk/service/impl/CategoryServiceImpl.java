package com.jbk.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jbk.dao.CategoryDao;
import com.jbk.entity.CategoryEntity;
import com.jbk.model.Category;
import com.jbk.service.CategoryService;
import com.jbk.utility.EntityToModel;
import com.jbk.utility.ModelToEntity;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryDao dao;

	@Autowired
	private EntityToModel entityToModel;
	
	@Autowired
	private ModelToEntity modelToEntity;

	@Override
	public int addCategory(Category category) {

		return dao.addCategory(category);
	}

	@Override
	public Category getCategoryById(long categoryId) {
		return dao.getCategoryById(categoryId);
	}

	@Override
	public List<Category> getAllCategory() {

		List<CategoryEntity> list = dao.getAllCategory();
		List<Category> modelList = new ArrayList<>();

//	for (CategoryEntity categoryEntity : list) {
//			Category category = entityToModel.convertToModel(categoryEntity);
//			modelList.add(category);
//		}

		modelList = list.stream().map(entityToModel::convertToModel).collect(Collectors.toList());

		return modelList;
	}

	@Override
	public List<Category> deleteCategory(long categoryId) {

		List<CategoryEntity> list = dao.deleteCategory(categoryId);
		List<Category> modelList = new ArrayList<>();

		modelList = list.stream().map(entityToModel::convertToModel).collect(Collectors.toList());

		return modelList;
	}

	@Override
	public Category updateCategory(Category category) {
		
		CategoryEntity categoryEntity = modelToEntity.convertToEntity(category);
		
		CategoryEntity updatedCategoryEntity = dao.updateCategory(categoryEntity);
		
		return entityToModel.convertToModel(updatedCategoryEntity);
	}

}
