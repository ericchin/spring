package com.liferay.sample.validator;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

/**
 * @author Eric Chin
 */
public class BaseFormValidator implements Validator {

	protected void doValidate(Object object) throws Exception {
		throw new UnsupportedOperationException();
	}

	@Override
	public void validate(Object object) {
		try {
			doValidate(object);
		}
		catch (Exception e) {
			_log.error(e, e);
		}
	}

	private static Log _log = LogFactoryUtil.getLog(BaseFormValidator.class);

}
