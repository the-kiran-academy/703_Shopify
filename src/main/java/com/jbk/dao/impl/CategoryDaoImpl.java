package com.jbk.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.PersistenceException;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.jbk.dao.CategoryDao;
import com.jbk.entity.CategoryEntity;
import com.jbk.model.Category;
import com.jbk.utility.EntityToModel;
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

	@Autowired
	private EntityToModel entityToModel;

	@Override
	public int addCategory(Category categoryModel) {
		int status = 0;
		try (Session session = sessionFactory.openSession()) {

			CategoryEntity categoryEntity = modelToEntity.convertToEntity(categoryModel);

			// Category category = session.get(Category.class,
			// categoryEntity.getCategoryId());

			// if(category==null) {
			session.save(categoryEntity);
			session.beginTransaction().commit();
			status = 1;
//			}else {
//				status=2;
//			}

		} catch (PersistenceException e) {
			status = 2;
		}

		catch (Exception e) {
			e.printStackTrace();
			status = 3;
		}
		return status;
	}

	@Override
	public Category getCategoryById(long categoryId) {
		Category categoryModel = null;

		try (Session session = sessionFactory.openSession()) {
			CategoryEntity categoryEntity = session.get(CategoryEntity.class, categoryId);
			if (categoryEntity != null) {
				categoryModel = entityToModel.convertToModel(categoryEntity);
			}
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		return categoryModel;
	}

	@Override
	public List<CategoryEntity> getAllCategory() {
		List<CategoryEntity> list = null;
		try (Session session = sessionFactory.openSession()) {
			Criteria criteria = session.createCriteria(CategoryEntity.class);
			list = criteria.list();
			
//			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<CategoryEntity> deleteCategory(long categoryId) {
		try (Session session = sessionFactory.openSession()) {
			CategoryEntity categoryEntity = session.get(CategoryEntity.class, categoryId);
			if (categoryEntity != null) {
				session.delete(categoryEntity);
				session.beginTransaction().commit();

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return getAllCategory();
	}

	@Override
	public CategoryEntity updateCategory(CategoryEntity categoryEntity) {
		try (Session session = sessionFactory.openSession()) {
			Category dbCategory = getCategoryById(categoryEntity.getCategoryId());

			if (dbCategory != null) {
				session.update(categoryEntity);
				session.beginTransaction().commit();
				return categoryEntity;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
