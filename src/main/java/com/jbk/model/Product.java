package com.jbk.model;

import java.sql.Date;

import org.springframework.stereotype.Component;

@Component
public class Product 
{
	private long productId;
	private String productName;
	private double productPrice;
	private int productQty;
	private String productDescription;
	private Date mfgDate;
	private Date expDate;
	private Supplier productSupplier;
	private CategoryModel productCategory;
	
	
	public Product() {
		// TODO Auto-generated constructor stub
	}


	public Product(long productId, String productName, double productPrice, int productQty, String productDescription,
			Date mfgDate, Date expDate, Supplier productSupplier, CategoryModel productCategory) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productPrice = productPrice;
		this.productQty = productQty;
		this.productDescription = productDescription;
		this.mfgDate = mfgDate;
		this.expDate = expDate;
		this.productSupplier = productSupplier;
		this.productCategory = productCategory;
	}


	public long getProductId() {
		return productId;
	}


	public void setProductId(long productId) {
		this.productId = productId;
	}


	public String getProductName() {
		return productName;
	}


	public void setProductName(String productName) {
		this.productName = productName;
	}


	public double getProductPrice() {
		return productPrice;
	}


	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}


	public int getProductQty() {
		return productQty;
	}


	public void setProductQty(int productQty) {
		this.productQty = productQty;
	}


	public String getProductDescription() {
		return productDescription;
	}


	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}


	public Date getMfgDate() {
		return mfgDate;
	}


	public void setMfgDate(Date mfgDate) {
		this.mfgDate = mfgDate;
	}


	public Date getExpDate() {
		return expDate;
	}


	public void setExpDate(Date expDate) {
		this.expDate = expDate;
	}


	public Supplier getProductSupplier() {
		return productSupplier;
	}


	public void setProductSupplier(Supplier productSupplier) {
		this.productSupplier = productSupplier;
	}


	public CategoryModel getProductCategory() {
		return productCategory;
	}


	public void setProductCategory(CategoryModel productCategory) {
		this.productCategory = productCategory;
	}


	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", productPrice=" + productPrice
				+ ", productQty=" + productQty + ", productDiscription=" + productDescription + ", mfgDate=" + mfgDate
				+ ", expDate=" + expDate + ", productSupplier=" + productSupplier + ", productCategory="
				+ productCategory + "]";
	}


	
	

}
