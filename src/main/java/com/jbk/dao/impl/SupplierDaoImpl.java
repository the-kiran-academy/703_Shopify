package com.jbk.dao.impl;

import java.util.List;
import javax.persistence.PersistenceException;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.jbk.dao.SupplierDao;
import com.jbk.entity.SupplierEntity;

@Repository
public class SupplierDaoImpl implements SupplierDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public int addSupplier(SupplierEntity supplieEntity) {
		int status = 0;
		try (Session session = sessionFactory.openSession()) {
			session.save(supplieEntity);
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
	public SupplierEntity getSupplierById(long supplierId) {
		SupplierEntity supplierEntity=null;
		try (Session session = sessionFactory.openSession()) {
			 supplierEntity = session.get(SupplierEntity.class, supplierId);

		}

		catch (Exception e) {
			e.printStackTrace();
		}
		return supplierEntity;
	}

	@Override
	public List<SupplierEntity> getAllSupplier() {
		List<SupplierEntity> list = null;
		try (Session session = sessionFactory.openSession()) {
			Criteria criteria = session.createCriteria(SupplierEntity.class);
			list = criteria.list();

//			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<SupplierEntity> deleteSupplier(long supplierId) {
		try (Session session = sessionFactory.openSession()) {
			SupplierEntity supplierEntity = session.get(SupplierEntity.class, supplierId);
			if (supplierEntity != null) {
				session.delete(supplierEntity);
				session.beginTransaction().commit();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return getAllSupplier();
	}

	@Override
	public SupplierEntity updateSupplier(SupplierEntity supplierEntity) {
		try (Session session = sessionFactory.openSession()) {
			SupplierEntity dbSupplier = getSupplierById(supplierEntity.getSupplierId());

			if (dbSupplier != null) {
				session.update(supplierEntity);
				session.beginTransaction().commit();
				return supplierEntity;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
