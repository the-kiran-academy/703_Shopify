package com.jbk.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jbk.exception.ResourceAlreadyExistsException;
import com.jbk.exception.ResourceNotExistsExceptions;
import com.jbk.service.CategoryService;
import com.jbk.model.Category;

@RestController
@RequestMapping("/category")
public class CategoryController {

	@Autowired
	private CategoryService service;

	@PostMapping("/add-category")
	public String addCategory(@RequestBody @Valid Category category) {

		int status = service.addCategory(category);

		if (status == 1) {

			return "Data Added Successfully.";
		} else if(status==2){
			throw new ResourceAlreadyExistsException("Category Already Exists check unique field");
		} else {
			return "something went wrong";
		}

	}
	
	@GetMapping("get-category-by-id/{id}")
	public Object getCategoryByID(@PathVariable("id") long id) {
		Category category = service.getCategoryById(id);
		if(category!=null) {
			return category;
		}else {
			throw new ResourceNotExistsExceptions("Category Not Exists With Id = "+id);
		}
		
	}
	
	
}
