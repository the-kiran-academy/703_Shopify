package com.jbk.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import org.springframework.stereotype.Component;

@Component
public class Supplier {

	private long supplierId;
	
	@NotBlank(message = "Supplier Name Should Be Not Blank")
	@Pattern(regexp = "^[a-zA-Z]+$",message = "Invalid Supplier Name")
	private String supplierName;
	

	@Size(min = 10,max = 10,message = "Mobile Number Should Be 10 Digit")
	@Pattern(regexp = "^[0-9]+$",message = "Invalid Mobile Number")
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
