package com.jbk.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jbk.model.Product;
import com.jbk.service.ProductService;
import com.jbk.service.impl.ProductServiceImpl;

@RestController
public class ProductController 
{
	@Autowired
	private ProductService service;
	
	@PostMapping("/save-product")
	public String addProduct(@RequestBody @Valid Product product) 
	{
		return null;
	}
	
	@DeleteMapping("delete-product/{id}")
	public String deleteProduct(@PathVariable() long pid)
	{
		return null;
		
	}
	
	@GetMapping("/get-product-by-id/{pid}")
    public ResponseEntity<?> getProductById(@PathVariable long pid)
	{
        Product product = service.getProductById(pid);
        
        System.out.println(product);

        if (product == null) 
        {
            // Return a 404 Not Found response with a custom message
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Invalid Product ID");
        }

        // Return a 200 OK response with the product
        return ResponseEntity.ok(product);
    }
	
	@GetMapping("/get-all-product")
	public List<Product> getAllProduct(){
		return null;
		
	}
}
