package com.jbk.controller;

import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.jbk.exception.ResourceAlreadyExistsException;
import com.jbk.exception.ResourceNotExistsExceptions;
import com.jbk.model.Supplier;
import com.jbk.service.SupplierService;

@RestController
@RequestMapping("/supplier")
public class SupplierController {

	@Autowired
	private SupplierService service;

	@PostMapping("/add-supplier")
	public String addSupplier(@RequestBody @Valid Supplier supplier) {

		int status = service.addSupplier(supplier);

		if (status == 1) {
			return "Supplier Added !!";
		} else if (status == 2) {
			throw new ResourceAlreadyExistsException("Supplier Already Exists");
		} else {
			return "Invalid Data";
		}
	}

	@GetMapping("/get-supplier-by-id/{supplierId}")
	public Supplier getSupplierById(@PathVariable long supplierId) {

		Supplier supplier = service.getSupplierById(supplierId);
		if (supplier != null) {
			return supplier;
		} else {
			throw new ResourceNotExistsExceptions("Supplier Not Exists With Id = " + supplierId +" : /get-supplier-by-id/"+supplierId);
		}

	}

	@GetMapping("/get-all-supplier")
	public List<Supplier> getAllSupplier() {
		List<Supplier> list = service.getAllSupplier();

		if (!list.isEmpty()) {
			return list;
		} else {
			throw new ResourceNotExistsExceptions("Supplier Not Exists : /get-all-supplier");
		}
	}
	
	
	@DeleteMapping("/delete-supplier")
	public List<Supplier> deleteSupplier(@RequestParam long supplierId){
		 List<Supplier> list = service.deleteSupplier(supplierId);
		 if (!list.isEmpty()) {
				return list;
			} else {
				throw new ResourceNotExistsExceptions("Supplier Not Exists To delete With  Id = " + supplierId +" : /delete-supplier/"+supplierId);
			}
		
	}
	
	@PutMapping("/update-supplier")
	public Supplier updateSupplier(@RequestBody Supplier supplier)
	{
		Supplier updatedSupplier = service.updateSupplier(supplier);
		if(updatedSupplier!=null) {
			return updatedSupplier;
		}else {
			throw new ResourceNotExistsExceptions("Supplier Not Exists To Update : /update-supplier");
		}
	}
	
	
	 

}
