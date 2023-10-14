package com.jbk.model;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Charges {
	
	private double gstAmount;
	private double deliveryCharges;
	
	

}
