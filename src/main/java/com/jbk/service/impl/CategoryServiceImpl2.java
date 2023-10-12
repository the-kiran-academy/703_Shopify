package com.jbk.service.impl;

import java.util.List;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.jbk.model.Category;
import com.jbk.service.CategoryService;

@Service("categoryServiceImpl2")

public class CategoryServiceImpl2 implements CategoryService {

	@Override
	public int addCategory(Category category) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Category getCategoryById(long categoryId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Category> getAllCategory() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Category> deleteCategory(long categoryId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Category updateCategory(Category category) {
		// TODO Auto-generated method stub
		return null;
	}

}
