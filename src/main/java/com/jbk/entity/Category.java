package com.jbk.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
//@Table(name = "category_tbl")
public class Category {

	@Id
	@Column(unique = true,nullable = false)
	private long categoryId;

	@Column(unique = true,nullable = false)
	private String categoryName;

	
	@Column(unique = true,nullable = true)
	private String discription;

	
	@Column(nullable = true)
	private int discount;

	
	@Column(nullable = true)
	private int gst;

	
	@Column(nullable = true)
	private double deliveryCharges;

	public Category() {
		// TODO Auto-generated constructor stub
	}

	public Category(long categoryId, String categoryName, String discription, int discount, int gst,
			double deliveryCharges) {
		super();
		this.categoryId = categoryId;
		this.categoryName = categoryName;
		this.discription = discription;
		this.discount = discount;
		this.gst = gst;
		this.deliveryCharges = deliveryCharges;
	}

	public long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(long categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getDiscription() {
		return discription;
	}

	public void setDiscription(String discription) {
		this.discription = discription;
	}

	public int getDiscount() {
		return discount;
	}

	public void setDiscount(int discount) {
		this.discount = discount;
	}

	public int getGst() {
		return gst;
	}

	public void setGst(int gst) {
		this.gst = gst;
	}

	public double getDeliveryCharges() {
		return deliveryCharges;
	}

	public void setDeliveryCharges(double deliveryCharges) {
		this.deliveryCharges = deliveryCharges;
	}

	@Override
	public String toString() {
		return "Category [categoryId=" + categoryId + ", categoryName=" + categoryName + ", discription=" + discription
				+ ", discount=" + discount + ", gst=" + gst + ", deliveryCharges=" + deliveryCharges + "]";
	}

}
