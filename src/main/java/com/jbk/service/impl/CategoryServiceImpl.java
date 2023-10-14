package com.jbk.service.impl;

import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jbk.dao.CategoryDao;
import com.jbk.entity.CategoryEntity;
import com.jbk.model.Category;
import com.jbk.service.CategoryService;

@Service("categoryServiceImpl")

public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryDao dao;

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
			return modelMapper.map(categoryEntity, Category.class);
		}
		return null;
	}

	@Override
	public List<Category> getAllCategory() {

		List<CategoryEntity> list = dao.getAllCategory();
//	for (CategoryEntity categoryEntity : list) {
//			Category category = entityToModel.convertToModel(categoryEntity);
//			modelList.add(category);
//		}

		// modelList = list.stream().map(modelMapper.map(modelList,
		// null)).collect(Collectors.toList());

		return list.stream().map(categoryEntity -> modelMapper.map(categoryEntity, Category.class))
				.collect(Collectors.toList());
	}

	@Override
	public List<Category> deleteCategory(long categoryId) {

		List<CategoryEntity> list = dao.deleteCategory(categoryId);
		// modelList =
		// list.stream().map(entityToModel::convertToModel).collect(Collectors.toList());

		

		return list.stream().map(categoryEntity -> modelMapper.map(categoryEntity, Category.class))
				.collect(Collectors.toList());

	}

	@Override
	public Category updateCategory(Category category) {

		CategoryEntity updatedCategoryEntity = dao.updateCategory(modelMapper.map(category, CategoryEntity.class));

		return modelMapper.map(updatedCategoryEntity, Category.class);
	}

	@Override
	public Category getCategoryByName(String categoryName) {
		
		CategoryEntity categoryEntity = dao.getCategoryByName(categoryName);
		if(categoryEntity!=null) {
		return	modelMapper.map(categoryEntity, Category.class);
		}else {
			return null;
		}
		
		 
	}

}
