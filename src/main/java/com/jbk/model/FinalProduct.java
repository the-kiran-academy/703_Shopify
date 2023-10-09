package com.jbk.model;

import org.springframework.stereotype.Component;

@Component
public class FinalProduct {
	
	private Long productId;
	private String productName;
	private Supplier supplier;
	private Category category;
	private Integer productQty;
	private Double productPrice;
	
	private Charges charges;
	private double discountAmount;
	private double finalProductPrice;
	
	
	public FinalProduct() {
		// TODO Auto-generated constructor stub
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


	public Supplier getSupplier() {
		return supplier;
	}


	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}


	public Category getCategory() {
		return category;
	}


	public void setCategory(Category category) {
		this.category = category;
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


	public Charges getCharges() {
		return charges;
	}


	public void setCharges(Charges charges) {
		this.charges = charges;
	}


	public double getDiscountAmount() {
		return discountAmount;
	}


	public void setDiscountAmount(double discountAmount) {
		this.discountAmount = discountAmount;
	}


	public double getFinalProductPrice() {
		return finalProductPrice;
	}


	public void setFinalProductPrice(double finalProductPrice) {
		this.finalProductPrice = finalProductPrice;
	}
	
	

}
