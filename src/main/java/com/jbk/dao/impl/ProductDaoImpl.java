package com.jbk.dao.impl;

import java.util.List;
import javax.persistence.PersistenceException;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.jbk.dao.ProductDao;
import com.jbk.entity.ProductEntity;

@Repository
public class ProductDaoImpl implements ProductDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public int addProduct(ProductEntity productEntity) {
		int status = 0;
		try (Session session = sessionFactory.openSession()) {
			session.save(productEntity);
			session.beginTransaction().commit();
			status = 1;

		}

		catch (PersistenceException e) {
			e.printStackTrace();
			status = 2;
		}

		catch (Exception e) {
			e.printStackTrace();
			status = 3;
		}
		return status;
	}

	@Override
	public ProductEntity getProductByName(String productName) {

		try (Session session = sessionFactory.openSession()) {
			Criteria criteria = session.createCriteria(ProductEntity.class);
			
			criteria.add(Restrictions.eq("productName", productName));
			//select * from Product where productName = xyz
			
			ProductEntity productEntity = (ProductEntity) criteria.uniqueResult();
			if (productEntity != null) {
				return productEntity;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}

	@Override
	public ProductEntity getProductById(long productId) {
		ProductEntity productEntity = null;
		try (Session session = sessionFactory.openSession()) {
			productEntity = session.get(ProductEntity.class, productId);
		}

		catch (Exception e) {
			e.printStackTrace();
		}
		return productEntity;
	}

	@Override
	public List<ProductEntity> getAllProduct() {
		List<ProductEntity> list = null;
		try (Session session = sessionFactory.openSession()) {
			Criteria criteria = session.createCriteria(ProductEntity.class);
			list = criteria.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<ProductEntity> deleteProduct(long productId) {
		try (Session session = sessionFactory.openSession()) {
			ProductEntity productEntity = session.get(ProductEntity.class, productId);
			if (productEntity != null) {
				session.delete(productEntity);
				session.beginTransaction().commit();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return getAllProduct();
	}

	@Override
	public ProductEntity updateProduct(ProductEntity productEntity) {
		try (Session session = sessionFactory.openSession()) {
			ProductEntity dbProduct = getProductById(productEntity.getProductId());

			if (dbProduct != null) {
				session.update(dbProduct);
				session.beginTransaction().commit();
				return productEntity;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<ProductEntity> getAllProductsByOrder(String orderType, String propertyName) {
		List<ProductEntity> list = null;
		try (Session session = sessionFactory.openSession()) {
			Criteria criteria = session.createCriteria(ProductEntity.class);

			if ("desc".equals(orderType)) {
				criteria.addOrder(Order.desc(propertyName));
			} else {
				criteria.addOrder(Order.asc(propertyName));
			}
			criteria.setFirstResult(0);
			criteria.setMaxResults(1);

			list = criteria.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

}
