package com.jbk.annotations;

import java.util.Arrays;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CountryValidator implements ConstraintValidator<ValidateCountry, String>{

	@Override
	public boolean isValid(String country, ConstraintValidatorContext context) {
		String[] countries = {"India", "Pakistan", "China", "Amerika"};
		
		return Arrays.asList(countries).contains(country);
	}

}
