package com.jbk.model;

import org.springframework.stereotype.Component;

@Component
public class Charges {
	
	private double gstAmount;
	private double deliveryCharges;
	
	public Charges() {
		// TODO Auto-generated constructor stub
	}

	public Charges(double gstAmount, double deliveryCharges) {
		super();
		this.gstAmount = gstAmount;
		this.deliveryCharges = deliveryCharges;
	}

	public double getGstAmount() {
		return gstAmount;
	}

	public void setGstAmount(double gstAmount) {
		this.gstAmount = gstAmount;
	}

	public double getDeliveryCharges() {
		return deliveryCharges;
	}

	public void setDeliveryCharges(double deliveryCharges) {
		this.deliveryCharges = deliveryCharges;
	}
	
	

}
