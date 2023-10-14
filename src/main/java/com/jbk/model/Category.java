package com.jbk.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Category {
	
	private Long categoryId;
	private String categoryName;
	private String discription;
	private Integer discount;
	private Integer gst;
	private Float deliveryCharge;
}
