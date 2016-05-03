package com.liferay.sample.util;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.model.User;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;

/**
 * @author ericchin
 */
@Component(value = "sampleValidator")
public class SampleValidator extends BaseValidator {

	@Override
	public void validate(Object object) {
		User user = (User) object;

		String emailAddress = user.getEmailAddress();

		_log.fatal("emailAddress :: " + emailAddress);
	}

	private static Log _log = LogFactoryUtil.getLog(SampleValidator.class);

}
