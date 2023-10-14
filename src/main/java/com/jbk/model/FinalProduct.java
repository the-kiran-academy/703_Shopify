package com.jbk.model;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
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
	
}
