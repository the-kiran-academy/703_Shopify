package com.jbk.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Data
@AllArgsConstructor
public class Supplier {
	private Long supplierId;
	
	@NotBlank
	@Pattern(regexp = "^[a-zA-Z ]+[a-zA-Z0-9]*$", message = "Supplier not valid")
	private String supplierName;
	private String city;
	private Integer postalCode;
	private String countryName;
	private String mobileNo;

	public Supplier() {
		// TODO Auto-generated constructor stub
	}

}
