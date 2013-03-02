package com.ksg.formslibrary.domain;

import java.util.List;

public class ListValues extends AbstractDomain {
	
	//form input selection values
	List<KeyValue> stateList;	
	List<KeyValue> lobList;	
	List<KeyValue> policyTypeList;	
	List<KeyValue> companyList;
	List<KeyValue> formTypeList;
	List<KeyValue> mandOptList;
	
	public List<KeyValue> getStateList() {
		return stateList;
	}
	public void setStateList(List<KeyValue> stateList) {
		this.stateList = stateList;
	}
	public List<KeyValue> getLobList() {
		return lobList;
	}
	public void setLobList(List<KeyValue> lobList) {
		this.lobList = lobList;
	}
	public List<KeyValue> getPolicyTypeList() {
		return policyTypeList;
	}
	public void setPolicyTypeList(List<KeyValue> policyTypeList) {
		this.policyTypeList = policyTypeList;
	}
	public List<KeyValue> getCompanyList() {
		return companyList;
	}
	public void setCompanyList(List<KeyValue> companyList) {
		this.companyList = companyList;
	}
	public List<KeyValue> getFormTypeList() {
		return formTypeList;
	}
	public void setFormTypeList(List<KeyValue> formTypeList) {
		this.formTypeList = formTypeList;
	}
	public List<KeyValue> getMandOptList() {
		return mandOptList;
	}
	public void setMandOptList(List<KeyValue> mandOptList) {
		this.mandOptList = mandOptList;
	}

	
	
}
