package com.liferay.sample.service.impl;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.sample.service.TestService;
import org.springframework.stereotype.Service;

/**
 * @author ericchin
 */
@Service
public class TestServiceImpl implements TestService {

	@Override
	public void test() {
		_log.fatal("Running test...");
	}

	private static Log _log = LogFactoryUtil.getLog(TestServiceImpl.class);

}
