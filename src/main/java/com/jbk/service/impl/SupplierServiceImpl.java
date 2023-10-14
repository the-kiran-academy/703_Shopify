package com.jbk.service.impl;

import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jbk.dao.SupplierDao;
import com.jbk.entity.SupplierEntity;
import com.jbk.model.Supplier;
import com.jbk.service.SupplierService;


@Service
public class SupplierServiceImpl implements SupplierService {

	@Autowired
	private SupplierDao dao;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public int addSupplier(Supplier supplier) {

		SupplierEntity supplierEntity = modelMapper.map(supplier, SupplierEntity.class);

		// return dao.addSupplier(modelToEntity.convertToEntity(supplier));
		return dao.addSupplier(supplierEntity);
	}

	@Override
	public Supplier getSupplierById(long supplierId) {

		SupplierEntity supplierEntity = dao.getSupplierById(supplierId);
		if (supplierEntity != null) {
			return modelMapper.map(supplierEntity, Supplier.class);

		}

		return null;
	}

	@Override
	public List<Supplier> getAllSupplier() {

		List<SupplierEntity> list = dao.getAllSupplier();

		return list.stream().map(supplierEntity -> modelMapper.map(supplierEntity, Supplier.class))
				.collect(Collectors.toList());
	}

	@Override
	public List<Supplier> deleteSupplier(long supplierId) {
		List<SupplierEntity> list = dao.deleteSupplier(supplierId);
		
		return list.stream().map(supplierEntity -> modelMapper.map(supplierEntity, Supplier.class))
				.collect(Collectors.toList());
	}

	@Override
	public Supplier updateSupplier(Supplier supplier) {

		SupplierEntity updatedSupplier = dao.updateSupplier(modelMapper.map(supplier, SupplierEntity.class));

		if (updatedSupplier != null) {
			return modelMapper.map(updatedSupplier, Supplier.class);
		}

		return null;
	}

}
