package com.jbk.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jbk.dao.SupplierDao;
import com.jbk.model.Supplier;
import com.jbk.service.SupplierService;

@Service
public class SupplierServiceImpl implements SupplierService {
	
	@Autowired
	private SupplierDao dao;
	
	@Override
	public int addSupplier(Supplier supplier) {
		
		return dao.addSupplier(supplier);
	
	}

	@Override
	public Supplier getSupplierById(long supplierId) {
		return dao.getSupplierById(supplierId);
	}

	@Override
	public List<Supplier> getAllSupplier() {
		
		return dao.getAllSupplier();
	}

	@Override
	public Object deleteSupplier(long supplierId) {
		
		return dao.deleteSupplier(supplierId);
	}

	@Override
	public Supplier updateSupplier(Supplier supplier) {
		
		return dao.updateSupplier(supplier);
	}

}
