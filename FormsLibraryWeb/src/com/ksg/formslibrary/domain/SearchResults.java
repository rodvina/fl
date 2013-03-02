package com.ksg.formslibrary.domain;

import java.util.List;

public class SearchResults {

	private List<Form> forms;


	public SearchResults(List<Form> forms) {
		super();
		this.forms = forms;
	}
	
	public List<Form> getForms() {
		return forms;
	}

	public void setForms(List<Form> forms) {
		this.forms = forms;
	}
	
}
