package com.ksg.formslibrary.domain;

import java.io.Serializable;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;

public class AbstractDomain implements Serializable {

	private static final long serialVersionUID = 1L;

	@Override
	public String toString() {

		return ReflectionToStringBuilder.toString(this);
	}


	
}
