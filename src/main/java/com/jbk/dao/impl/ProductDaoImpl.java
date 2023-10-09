package com.jbk.dao.impl;
import java.util.List;
import org.springframework.stereotype.Repository;
import com.jbk.dao.ProductDao;
import com.jbk.model.Product;

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
