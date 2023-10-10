package com.jbk.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jbk.dao.SupplierDao;
import com.jbk.entity.SupplierEntity;
import com.jbk.model.Supplier;
import com.jbk.service.SupplierService;
import com.jbk.utility.EntityToModel;
import com.jbk.utility.ModelToEntity;

@Service
public class SupplierServiceImpl implements SupplierService {

	@Autowired
	private SupplierDao dao;

	@Autowired
	private ModelToEntity modelToEntity;

	@Autowired
	private EntityToModel entityToModel;

	@Override
	public int addSupplier(Supplier supplier) {

		return dao.addSupplier(modelToEntity.convertToEntity(supplier));

	}

	@Override
	public Supplier getSupplierById(long supplierId) {
		
		SupplierEntity supplierEntity = dao.getSupplierById(supplierId);
		if(supplierEntity!=null) {
			return entityToModel.convertToModel(supplierEntity);
		}

		return null;
	}

	@Override
	public List<Supplier> getAllSupplier() {

		List<SupplierEntity> list = dao.getAllSupplier();
		List<Supplier> modelList = new ArrayList<>();
		
		if(!list.isEmpty()) {
			modelList = list.stream().map(entityToModel::convertToModel).collect(Collectors.toList());
		}

		return modelList;
	}

	@Override
	public List<Supplier> deleteSupplier(long supplierId) {
		List<Supplier> modelList = new ArrayList<>();
		List<SupplierEntity> list = dao.deleteSupplier(supplierId);

		if(!list.isEmpty()) {
			modelList = list.stream().map(entityToModel::convertToModel).collect(Collectors.toList());
		}

		return modelList;
	}

	@Override
	public Supplier updateSupplier(Supplier supplier) {
		
		SupplierEntity updatedSupplier = dao.updateSupplier(modelToEntity.convertToEntity(supplier));
		
		if(updatedSupplier!=null) {
			return entityToModel.convertToModel(updatedSupplier);
		}

		return null; 
	}

}
