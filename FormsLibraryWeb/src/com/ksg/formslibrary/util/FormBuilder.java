package com.ksg.formslibrary.util;

import java.util.Date;

import com.ksg.formslibrary.domain.Form;

public class FormBuilder {
	
	private Form form;
	
	public FormBuilder() {
		form = new Form();
	}
	
	public FormBuilder formNumber(String formNumber) {
		form.setFormNumber(formNumber);
		return this;
	}
	
	public FormBuilder formEdition(String formEdition) {
		form.setFormEdition(formEdition);
		return this;
	}
	
	public FormBuilder formTitle(String formTitle) {
		form.setFormTitle(formTitle);
		return this;
	}
	
	public FormBuilder formType(String formType) {
		form.setFormType(formType);
		return this;
	}
	
	public FormBuilder sequence(int sequence) {
		form.setSequence(sequence);
		return this;
	}
	
	public FormBuilder state(String state) {
		form.setState(state);
		return this;
	}
	
	public FormBuilder status(String status) {
		form.setStatus(status);
		return this;
	}
	
	public FormBuilder nbEffDate(Date nbEffDate) {
		form.setNbEffDate(nbEffDate);
		return this;
	}
	
	public FormBuilder nbExpDate(Date nbExpDate) {
		form.setNbExpDate(nbExpDate);
		return this;
	}
	public FormBuilder renEffDate(Date renEffDate) {
		form.setRenEffDate(renEffDate);
		return this;
	}
	public FormBuilder renExpDate(Date renExpDate) {
		form.setRenExpDate(renExpDate);
		return this;
	}
	public FormBuilder contractType(String contractType) {
		form.setContractType(contractType);
		return this;
	}
	public FormBuilder policyType(String policyType) {
		form.setPolicyType(policyType);
		return this;
	}
	public FormBuilder company(String company) {
		form.setCompany(company);
		return this;
	}
	public FormBuilder lob(String lob) {
		form.setLob(lob);
		return this;
	}
	public Form build() {
		return form;
	}

}
