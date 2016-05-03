package com.liferay.sample.validator.impl;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.sample.model.Form;
import com.liferay.sample.validator.BaseFormValidator;
import org.springframework.stereotype.Component;

/**
 * @author Eric Chin
 */
@Component
public class FormValidator extends BaseFormValidator {

	@Override
	protected void doValidate(Object object) throws Exception {
		if (!(object instanceof Form)) {
			throw new UnsupportedOperationException();
		}

		Form form = (Form) object;

		long formId = form.getFormId();
		String name = form.getName();
		String emailAddress = form.getEmailAddress();

		boolean isFormIdValid = (formId > 0);

		boolean isEmailAddress = Validator.isEmailAddress(emailAddress);

		boolean isNameValid = Validator.isNotNull(name);

		_log.fatal("isFormIdValid :: " + isFormIdValid);
		_log.fatal("isEmailAddress :: " + isEmailAddress);
		_log.fatal("isNameValid :: " + isNameValid);

		if (!(isFormIdValid && isEmailAddress && isNameValid)) {
			throw new Exception("Invalid fields");
		}
	}

	private static Log _log = LogFactoryUtil.getLog(FormValidator.class);

}
