package com.jbk.dao.impl;

import java.util.List;
import javax.persistence.PersistenceException;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.SimpleExpression;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.jbk.dao.CategoryDao;
import com.jbk.entity.CategoryEntity;

@Repository
public class CategoryDaoImpl implements CategoryDao {
	// 1) SessionFactory
	// 2) Session
	// 3) now we can perform all operation using session

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public int addCategory(CategoryEntity categoryEntity) {
		int status = 0;
		try (Session session = sessionFactory.openSession()) {

			session.save(categoryEntity);
			session.beginTransaction().commit();
			status = 1;
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
	public CategoryEntity getCategoryById(long categoryId) {
		CategoryEntity categoryEntity = null;

		try (Session session = sessionFactory.openSession()) {
			categoryEntity = session.get(CategoryEntity.class, categoryId);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return categoryEntity;
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
			CategoryEntity dbCategory = getCategoryById(categoryEntity.getCategoryId());

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

	@Override
	public CategoryEntity getCategoryByName(String value) {  //select * from category where categoryName=Electronics
		try (Session session = sessionFactory.openSession()) {
			
			Criteria criteria = session.createCriteria(CategoryEntity.class);
			
			Criterion eq = Restrictions.like("categoryName", value);
			
			criteria.add(eq);
			
			List<CategoryEntity> list = criteria.list();
			
			if(!list.isEmpty()) {
				return (CategoryEntity) list.get(0);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
