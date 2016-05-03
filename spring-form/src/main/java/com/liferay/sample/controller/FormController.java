package com.liferay.sample.controller;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.sample.model.Form;
import com.liferay.sample.service.FormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.portlet.ModelAndView;
import org.springframework.web.portlet.bind.annotation.ActionMapping;
import org.springframework.web.portlet.bind.annotation.RenderMapping;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletSession;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

/**
 * @author Eric Chin
 */
@Controller(value = "formController")
@RequestMapping("VIEW")
@SessionAttributes(types = Form.class)
public class FormController {

	@RenderMapping(params = "myaction=finish")
	public String displayFinish(
		SessionStatus sessionStatus, RenderRequest request,
		RenderResponse response) {

		sessionStatus.setComplete();

		return "finish";
	}

	@RenderMapping(params = "myaction=step2")
	public String displayStep2(RenderRequest request, RenderResponse response) {
		return "step2";
	}

	@RenderMapping
	public ModelAndView handleRenderRequest(
		RenderRequest request, RenderResponse response) {

		ModelAndView modelAndView = new ModelAndView();

		PortletSession session = request.getPortletSession();

		Form form = (Form) session.getAttribute("form");

		if (form != null) {
			_log.fatal(form.getFormId());
			_log.fatal(form.getName());
			_log.fatal(form.getEmailAddress());
		}

		modelAndView.setView("step1");

		modelAndView.addObject("form", form);

		return modelAndView;
	}

	@ModelAttribute("form")
	public Form initForm() {
		return new Form();
	}

	@ActionMapping(params = "myaction=submit")
	public void submit(
		@ModelAttribute("form") Form form, ActionRequest request,
		ActionResponse response) {

		String cmd = ParamUtil.getString(request, Constants.CMD);

		_log.fatal(form.getFormId());
		_log.fatal(form.getEmailAddress());
		_log.fatal(form.getName());

		String action = "step2";

		if (cmd.equals("step2")) {
			action = "step2";
		}
		else if (cmd.equals("finish")) {
			action = "finish";

			formService.addForm(form);
		}

		response.setRenderParameter("myaction", action);
	}

	@Autowired
	private FormService formService;

	private static Log _log = LogFactoryUtil.getLog(FormController.class);

}
