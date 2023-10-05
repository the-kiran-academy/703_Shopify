package com.jbk.model;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import org.springframework.stereotype.Component;
@Component
public class CategoryModel {

	private long categoryId;

	@NotBlank(message = "categoryName cannot be empty.")
	@Pattern(regexp = "^[a-zA-Z]+$", message = "categoryName should contains only alphabetic characters.")
	private String categoryName;

	@NotBlank(message = "discription cannot be empty.")
	@Pattern(regexp = "^[a-zA-Z ]+$", message = "discription should contains only alphabetic characters.")
	private String discription;

	@Min(value = 0, message = "discount should not be less than 0%.")
	@Max(value = 50, message = "discount should not be more than 50%.")
	private int discount;

	@Min(value = 0, message = "gst should not be less than 0%.")
	@Max(value = 18, message = "gst should not be more than 18%.")
	private int gst;

	@Min(value = 0, message = "deliveryCharges should not be less than 0% of product price.")
	@Max(value = 10, message = "deliveryCharges should not be more than 10% of product price.")
	private double deliveryCharges;

	public CategoryModel() {
		// TODO Auto-generated constructor stub
	}

	public CategoryModel(long categoryId, String categoryName, String discription, int discount, int gst,
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
