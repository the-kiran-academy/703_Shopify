package com.jbk.dao;

import java.util.List;

import com.jbk.entity.CategoryEntity;
import com.jbk.model.Category;

public interface CategoryDao {

	public int addCategory(Category category);
	public Category getCategoryById(long categoryId);
	public List<CategoryEntity> getAllCategory();
	public List<CategoryEntity> deleteCategory(long categoryId);
	public CategoryEntity updateCategory(CategoryEntity category);
}
