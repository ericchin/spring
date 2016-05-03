package com.liferay.sample.model;

import java.io.Serializable;

/**
 * @author Eric Chin
 */
public class Form implements Serializable {

	public String getEmailAddress() {
		return emailAddress;
	}

	public Long getFormId() {
		return formId;
	}

	public String getName() {
		return name;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public void setFormId(Long formId) {
		this.formId = formId;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "";
	}

	private String emailAddress;

	private Long formId;

	private String name;

}
