package com.jbk.model;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {

	
	private Long productId;
	
	@NotBlank
	@Pattern(regexp = "^[a-zA-Z]+[a-zA-Z0-9]*$", message = "Product not valid")
	private String productName;

	private Supplier supplier;
	private Category category;

	@Min(1)
	private Integer productQty;

	@Min(1)
	private Double productPrice;

}
