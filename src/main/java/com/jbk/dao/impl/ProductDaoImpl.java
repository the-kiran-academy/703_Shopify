package com.jbk.dao.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.jbk.dao.ProductDao;
import com.jbk.model.Address;
import com.jbk.model.CategoryModel;
import com.jbk.model.Product;
import com.jbk.model.Supplier;

@Repository

public class ProductDaoImpl implements ProductDao {


	

	@Override
	public int addProduct(Product product) {
		
		return 0;
	}

	@Override
	public Product getProductById(long productId) 
	{
		
		
		return null;

	}

	@Override
	public List<Product> getAllProduct() {

		return null;
	}

	@Override
	public List<Product> deleteProduct() {
	
		return null;
	}

	@Override
	public Product updateProduct() {
		return null;
	}

}
