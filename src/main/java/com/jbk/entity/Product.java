package com.jbk.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;


@Entity
//@Table(name = "product_tbl")
public class Product 
{
	@Id
	@Column(unique = true,nullable = false)
	private long productId;
	
	@Column(unique = true,nullable = false)
	private String productName;
	
	@Column(nullable = false)
	private double productPrice;
	
	@Column(nullable = false)
	private int productQty;
	
	@Column(unique = true,nullable = false)
	private String productDescription;
	
	@Column(nullable = false)
	private Date mfgDate;
	
	@Column(nullable = false)
	private Date expDate;
	
	@OneToOne
	@JoinColumn(name = "supplierid")
	private Supplier productSupplier;
	
	@OneToOne
	@JoinColumn(name = "categoryid")
	private Category productCategory;
	
	
	public Product() {
		// TODO Auto-generated constructor stub
	}


	public Product(long productId, String productName, double productPrice, int productQty, String productDescription,
			Date mfgDate, Date expDate, Supplier productSupplier, Category productCategory) {
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


	public Category getProductCategory() {
		return productCategory;
	}


	public void setProductCategory(Category productCategory) {
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
