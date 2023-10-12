package com.jbk.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import com.jbk.dao.CategoryDao;
import com.jbk.entity.CategoryEntity;
import com.jbk.model.Category;
import com.jbk.service.CategoryService;
import com.jbk.utility.EntityToModel;
import com.jbk.utility.ModelToEntity;

@Service("categoryServiceImpl")

public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryDao dao;

	@Autowired
	private EntityToModel entityToModel;

	@Autowired
	private ModelToEntity modelToEntity;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public int addCategory(Category category) {

		CategoryEntity categoryEntity = modelMapper.map(category, CategoryEntity.class);

		return dao.addCategory(categoryEntity);
	}

	@Override
	public Category getCategoryById(long categoryId) {
		CategoryEntity categoryEntity = dao.getCategoryById(categoryId);
		
		
		if (categoryEntity != null) {
			return  modelMapper.map(categoryEntity, Category.class);
		}
		return null;
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

		CategoryEntity updatedCategoryEntity = dao.updateCategory(modelToEntity.convertToEntity(category));

		return entityToModel.convertToModel(updatedCategoryEntity);
	}

}
