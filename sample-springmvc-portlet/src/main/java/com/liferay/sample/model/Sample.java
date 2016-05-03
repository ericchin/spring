package com.liferay.sample.model;

import java.io.Serializable;

/**
 * @author ericchin
 */
public class Sample implements Serializable {

	public long getSampleId() {
		return sampleId;
	}

	public String getSampleName() {
		return sampleName;
	}

	public void setSampleId(long sampleId) {
		this.sampleId = sampleId;
	}

	public void setSampleName(String sampleName) {
		this.sampleName = sampleName;
	}

	private long sampleId;

	private String sampleName;

}
