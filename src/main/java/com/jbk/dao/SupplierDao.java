package com.jbk.dao;

import java.util.List;

import com.jbk.model.Supplier;

public interface SupplierDao {
	
	public int addSupplier(Supplier supplier);
	public Supplier getSupplierById(long supplierId);
	public List<Supplier> getAllSupplier();
	public Object deleteSupplier(long supplierId);
	public Supplier updateSupplier(Supplier supplier);
	

}
