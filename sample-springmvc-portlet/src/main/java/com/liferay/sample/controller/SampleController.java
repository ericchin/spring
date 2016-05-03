package com.liferay.sample.controller;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.User;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.sample.model.Sample;
import com.liferay.sample.service.SampleService;
import com.liferay.sample.service.TestService;
import com.liferay.sample.util.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.portlet.ModelAndView;
import org.springframework.web.portlet.bind.annotation.ActionMapping;
import org.springframework.web.portlet.bind.annotation.RenderMapping;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

/**
 * @author ericchin
 */
@Controller(value = "sampleController")
@RequestMapping(value = "VIEW")
@SessionAttributes(types = Sample.class)
public class SampleController {

	@RenderMapping
	public ModelAndView handleRenderRequest(
		RenderRequest request, RenderResponse response) {

		ModelAndView modelAndView = new ModelAndView();

		modelAndView.setView("step1");

		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(
			WebKeys.THEME_DISPLAY);

		long userId = themeDisplay.getUserId();

		_testService.test();

		User user = _sampleService.getLiferayUser(userId);

		modelAndView.addObject("userFullName", user.getFullName());

		_validator.validate(user);

		return modelAndView;
	}

	@ActionMapping(params = "myaction=submitStep1")
	public void submitStep1(
		@ModelAttribute("sample") Sample sample, BindingResult bindingResult,
		ActionRequest request, ActionResponse response) {

		long sampleId = sample.getSampleId();
		String sampleName = sample.getSampleName();

		_log.fatal("sampleId :: " + sampleId);
		_log.fatal("sampleName :: " + sampleName);
	}

	@ModelAttribute("sample")
	public Sample getSample() {
		return new Sample();
	}

	private static Log _log = LogFactoryUtil.getLog(SampleController.class);

	@Autowired
	private TestService _testService;

	@Autowired
	private SampleService _sampleService;

	@Autowired
	private Validator _validator;

}
