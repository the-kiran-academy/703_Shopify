package com.jbk.dao.impl;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.PersistenceException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.jbk.dao.CategoryDao;
import com.jbk.entity.Category;
import com.jbk.model.CategoryModel;
import com.jbk.utility.ModelToEntity;

@Repository
public class CategoryDaoImpl implements CategoryDao {
	// 1) SessionFactory
	// 2) Session
	// 3) now we can perform all operation using session

	@Autowired
	private SessionFactory sessionFactory;

	@Autowired
	private ModelToEntity modelToEntity;

	@Override
	public int addCategory(CategoryModel categoryModel) {
		int status = 0;
		try (Session session = sessionFactory.openSession()) {

			Category categoryEntity = modelToEntity.modelToEntity(categoryModel);

			//Category category = session.get(Category.class, categoryEntity.getCategoryId());
			
			//if(category==null) {
				session.save(categoryEntity);
				session.beginTransaction().commit();
				status = 1;	
//			}else {
//				status=2;
//			}
			
			
		}
		catch (PersistenceException e) {
			status=2;
			System.out.println("1111111");
		}
		
		catch (Exception e) {
			e.printStackTrace();
			status = 3;
		}
		return status;
	}

	@Override
	public CategoryModel getCategoryById(long categoryId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CategoryModel> getAllCategory() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CategoryModel> deleteCategory(long categoryId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CategoryModel updateCategory(CategoryModel category) {
		// TODO Auto-generated method stub
		return null;
	}

}
