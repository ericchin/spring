package com.liferay.sample.util;

import org.springframework.validation.Errors;

/**
 * @author ericchin
 */
public class BaseValidator implements Validator {

	@Override
	public void validate(Object object) {
		throw new UnsupportedOperationException();
	}

}
