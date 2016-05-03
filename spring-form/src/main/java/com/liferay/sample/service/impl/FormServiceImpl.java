package com.liferay.sample.service.impl;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.sample.model.Form;
import com.liferay.sample.service.FormService;
import com.liferay.sample.validator.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Eric Chin
 */
@Service
public class FormServiceImpl implements FormService {

	@Override
	public void addForm(Form form) {
		_log.fatal("Entering service method...");

		long formId = form.getFormId();
		String emailAddress = form.getEmailAddress();
		String name = form.getName();

		_log.fatal("formId :: " + formId);
		_log.fatal("emailAddress :: " + emailAddress);
		_log.fatal("name :: " + name);

		validator.validate(form);

		_log.fatal("Exiting service method...");
	}

	@Autowired
	private Validator validator;

	private static Log _log = LogFactoryUtil.getLog(FormServiceImpl.class);

}
