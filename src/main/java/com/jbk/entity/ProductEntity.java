package com.jbk.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "product")
public class ProductEntity {
	
	@Id
	@Column(unique = true,nullable = false )
	private Long productId;
	
	@Column(unique = true,nullable = false)
	private String productName;
	
	@OneToOne
	@JoinColumn(name="supplierId")
	private SupplierEntity supplierEntity;
	
	@OneToOne
	@JoinColumn(name = "categoryId")
	private CategoryEntity categoryEntity;
	
	@Column(nullable = false)
	private Integer productQty;
	
	@Column(nullable = false)
	private Double productPrice;
	
	
	public ProductEntity() {
		// TODO Auto-generated constructor stub
	}


	public ProductEntity(Long productId, String productName, SupplierEntity supplierEntity, CategoryEntity categoryEntity, Integer productQty,
			Double productPrice) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.supplierEntity = supplierEntity;
		this.categoryEntity = categoryEntity;
		this.productQty = productQty;
		this.productPrice = productPrice;
	}


	public Long getProductId() {
		return productId;
	}


	public void setProductId(Long productId) {
		this.productId = productId;
	}


	public String getProductName() {
		return productName;
	}


	public void setProductName(String productName) {
		this.productName = productName;
	}


	public SupplierEntity getSupplier() {
		return supplierEntity;
	}


	public void setSupplier(SupplierEntity supplierEntity) {
		this.supplierEntity = supplierEntity;
	}


	public CategoryEntity getCategory() {
		return categoryEntity;
	}


	public void setCategory(CategoryEntity categoryEntity) {
		this.categoryEntity = categoryEntity;
	}


	public Integer getProductQty() {
		return productQty;
	}


	public void setProductQty(Integer productQty) {
		this.productQty = productQty;
	}


	public Double getProductPrice() {
		return productPrice;
	}


	public void setProductPrice(Double productPrice) {
		this.productPrice = productPrice;
	}


	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", supplier=" + supplierEntity
				+ ", category=" + categoryEntity + ", productQty=" + productQty + ", productPrice=" + productPrice + "]";
	}
	
	

}
