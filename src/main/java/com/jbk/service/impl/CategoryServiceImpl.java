package com.jbk.service.impl;

import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jbk.dao.CategoryDao;
import com.jbk.model.CategoryModel;
import com.jbk.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryDao dao;

	@Override
	public int addCategory(CategoryModel category) {

		return dao.addCategory(category);
	}

	@Override
	public CategoryModel getCategoryById(long categoryId) {
		return null;
	}

	@Override
	public List<CategoryModel> getAllCategory() {
		return null;
	}

	@Override
	public List<CategoryModel> deleteCategory() {
		return null;
	}

	@Override
	public CategoryModel updateCategory() {
		return null;
	}

}
