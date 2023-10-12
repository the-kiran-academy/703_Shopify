package com.jbk.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "supplier")
public class SupplierEntity {
	
	@Id
	@Column(unique = true,nullable = false)
	private Long supplierId;
	
	@Column(unique = true,nullable = false)
	private String supplierName;
	
	@Column(nullable = false)
	private String city;
	
	@Column(nullable = false)
	private Integer postalCode;
	
	@Column(nullable = false)
	private String countryName;
	
	@Column(unique = true,nullable = false)
	private String mobileNo;
	
	

	public SupplierEntity() {
		// TODO Auto-generated constructor stub
	}

	public SupplierEntity(Long supplierId, String supplierName, String city, Integer postalCode, String countryName,
			String mobileNo) {
		super();
		this.supplierId = supplierId;
		this.supplierName = supplierName;
		this.city = city;
		this.postalCode = postalCode;
		this.countryName = countryName;
		this.mobileNo = mobileNo;
	}

	public Long getSupplierId() {
		return supplierId;
	}

	public void setSupplierId(Long supplierId) {
		this.supplierId = supplierId;
	}

	public String getSupplierName() {
		return supplierName;
	}

	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Integer getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(Integer postalCode) {
		this.postalCode = postalCode;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	@Override
	public String toString() {
		return "Supplier [supplierId=" + supplierId + ", supplierName=" + supplierName + ", city=" + city
				+ ", postalCode=" + postalCode + ", countryName=" + countryName + ", mobileNo=" + mobileNo + "]";
	}

}
