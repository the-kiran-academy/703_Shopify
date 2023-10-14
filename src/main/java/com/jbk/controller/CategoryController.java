package com.jbk.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jbk.exception.ResourceAlreadyExistsException;
import com.jbk.exception.ResourceNotExistsExceptions;
import com.jbk.service.CategoryService;
import com.jbk.model.Category;
import com.jbk.model.Supplier;

@RestController
@RequestMapping("/category")
public class CategoryController {

	@Autowired
	@Qualifier("categoryServiceImpl")
	private CategoryService service;

//	@Autowired
//	@Qualifier("categoryServiceImpl2")
//	private CategoryService xyz;

	@PostMapping("/add-category")
	public String addCategory(@RequestBody @Valid Category category) {

		int status = service.addCategory(category);

		if (status == 1) {

			return "Data Added Successfully.";
		} else if (status == 2) {
			throw new ResourceAlreadyExistsException("Category Already Exists check unique field");
		} else {
			return "something went wrong";
		}

	}

	@GetMapping("get-category-by-id/{id}")
	public Category getCategoryByID(@PathVariable("id") long id) {
		Category category = service.getCategoryById(id);
		if (category != null) {
			return category;
		} else {
			throw new ResourceNotExistsExceptions(
					"Category Not Exists With Id = " + id + " : /get-category-by-id/" + id);
		}

	}

	@GetMapping("/get-all-category")
	public List<Category> getAllCategory() {
		List<Category> list = service.getAllCategory();

		if (!list.isEmpty()) {
			return list;
		} else {
			throw new ResourceNotExistsExceptions("Category Not Exists  : /get-all-category");
		}

	}

	@DeleteMapping("/delete-category")
	public List<Category> deleteCategory(@RequestParam long id) {
		List<Category> list = service.deleteCategory(id);
		if (!list.isEmpty()) {
			return list;
		} else {
			throw new ResourceNotExistsExceptions("Category Not Exists  : /delete-category");
		}
	}

	@PutMapping("/update-category")
	public Category updateCategory(@RequestBody Category category) {
		Category updatedCategory = service.updateCategory(category);
		if (updatedCategory != null) {
			return updatedCategory;
		} else {
			throw new ResourceNotExistsExceptions("Category Not Exists To Update : /update-category");
		}
	}

	@GetMapping("get-category-by-name/{name}")
	public Category getCategoryByName(@PathVariable("name") String categoryName) {
		Category category = service.getCategoryByName(categoryName);
		if (category != null) {
			return category;
		} else {
			throw new ResourceNotExistsExceptions(
					"Category Not Exists With Name = " + categoryName + " : /get-category-by-name/" + categoryName);
		}

	}

}
