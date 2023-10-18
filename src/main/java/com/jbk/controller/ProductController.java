package com.jbk.controller;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.jbk.exception.ResourceAlreadyExistsException;
import com.jbk.exception.ResourceNotExistsExceptions;
import com.jbk.model.Product;
import com.jbk.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {
	@Autowired
	private ProductService service;

	@PostMapping("/add-product")
	public String addProduct(@RequestBody @Valid Product product) {

		int status = service.addProduct(product);
		if (status == 1) {

			return "Data Added Successfully.";
		} else if (status == 2) {
			throw new ResourceAlreadyExistsException("Product Already Exists check unique field");
		} else {
			return "something went wrong";
		}
	}

	@DeleteMapping("delete-product/{id}")
	public List<Product> deleteProduct(@PathVariable long id) {
		List<Product> list = service.deleteProduct(id);
		if (!list.isEmpty()) {
			return list;
		} else {
			throw new ResourceNotExistsExceptions("Product Not Exists  : /delete-product");
		}

	}

	@GetMapping("/get-product-by-id/{id}")
	public Product getProductById(@PathVariable long id) {
		Product product = service.getProductById(id);
		if (product != null) {
			return product;
		} else {
			throw new ResourceNotExistsExceptions("Product Not Exists With Id = " + id + " : /get-product-by-id/" + id);
		}
	}

	@GetMapping("/get-all-product")
	public List<Product> getAllProduct() {
		List<Product> list = service.getAllProduct();
		if (!list.isEmpty()) {
			return list;
		} else {
			throw new ResourceNotExistsExceptions("Product Not Exists  : /get-all-product");
		}
	}

	@PutMapping("/update-product")
	public Product updateProduct(@RequestBody Product product) {
		Product updatedProduct = service.updateProduct(product);
		if (updatedProduct != null) {
			return updatedProduct;
		} else {
			throw new ResourceNotExistsExceptions("Product Not Exists To Update : /update-product");
		}
	}

	@GetMapping("/get-all-product-by-order")
	public List<Product> getAllProductByName(@RequestParam String orderType, @RequestParam String propertyName) {
		List<Product> list = service.getAllProductsByOrder(orderType, propertyName);
		if (!list.isEmpty()) {
			return list;
		} else {
			throw new ResourceNotExistsExceptions("Product Not Exists  : /get-all-product-by-order");
		}
	}

	@PostMapping("/upload-sheet")
	public Map<String, Object> uploadSheet(@RequestParam MultipartFile myFile) {
		
		Map<String, Object> map = service.uploadSheet(myFile);
		return map;
		
	}

}
