package com.liferay.sample.service.impl;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.model.User;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.sample.service.SampleService;
import org.springframework.stereotype.Service;

/**
 * @author ericchin
 */
@Service
public class SampleServiceImpl implements SampleService {

	@Override
	public User getLiferayUser(long userId) {
		User user = null;

		try {
			user = UserLocalServiceUtil.fetchUser(userId);
		}
		catch (Exception e) {
			_log.error(e, e);
		}

		return user;
	}

	private static Log _log = LogFactoryUtil.getLog(SampleServiceImpl.class);

}
