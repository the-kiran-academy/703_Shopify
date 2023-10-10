package com.jbk.dao;

import java.util.List;

import com.jbk.entity.SupplierEntity;
import com.jbk.model.Supplier;

public interface SupplierDao {
	
	public int addSupplier(SupplierEntity supplier);
	public SupplierEntity getSupplierById(long supplierId);
	public List<SupplierEntity> getAllSupplier();
	public List<SupplierEntity> deleteSupplier(long supplierId);
	public SupplierEntity updateSupplier(SupplierEntity supplier);
	

}
