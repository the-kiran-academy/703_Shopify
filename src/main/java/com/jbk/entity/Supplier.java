package com.jbk.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
//@Table(name = "supplier_tbl")
public class Supplier {

	@Id
	@Column(unique = true,nullable = false)
	private long supplierId;
	
	@Column(unique = true,nullable = false)
	private String supplierName;
	
	@Column(unique = true,nullable = false)
	private String supplierMobileNumber;
	
	

	public Supplier() {
		// TODO Auto-generated constructor stub
	}

	public Supplier(long supplierId, String supplierName, String supplierMobileNumber) {
		super();
		this.supplierId = supplierId;
		this.supplierName = supplierName;
		this.supplierMobileNumber = supplierMobileNumber;
	}

	public long getSupplierId() {
		return supplierId;
	}

	public void setSupplierId(long supplierId) {
		this.supplierId = supplierId;
	}

	public String getSupplierName() {
		return supplierName;
	}

	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}

	public String getSupplierMobileNumber() {
		return supplierMobileNumber;
	}

	public void setSupplierMobileNumber(String supplierMobileNumber) {
		this.supplierMobileNumber = supplierMobileNumber;
	}

	@Override
	public String toString() {
		return "Supplier [supplierId=" + supplierId + ", supplierName=" + supplierName + ", supplierMobileNumber="
				+ supplierMobileNumber + "]";
	}

	
	

}
