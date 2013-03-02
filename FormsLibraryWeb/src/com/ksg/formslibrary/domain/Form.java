package com.ksg.formslibrary.domain;

import java.util.Date;

public class Form extends AbstractDomain {

	private String formType;
	private String formNumber;
	private String formEdition;
	private String formTitle;
	private String status;
	private int sequence;
	private String state;
	private String company;
	private Date nbEffDate;
	private Date nbExpDate;
	private Date renEffDate;
	private Date renExpDate;
	private String lob;
	private String policyType;
	private String contractType;
	
	public Form() {
		super();
	}

	public String getFormType() {
		return formType;
	}

	public void setFormType(String formType) {
		this.formType = formType;
	}

	public String getFormNumber() {
		return formNumber;
	}

	public void setFormNumber(String formNumber) {
		this.formNumber = formNumber;
	}

	public String getFormEdition() {
		return formEdition;
	}

	public void setFormEdition(String formEdition) {
		this.formEdition = formEdition;
	}

	public String getFormTitle() {
		return formTitle;
	}

	public void setFormTitle(String formTitle) {
		this.formTitle = formTitle;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getSequence() {
		return sequence;
	}

	public void setSequence(int sequence) {
		this.sequence = sequence;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public Date getNbEffDate() {
		return nbEffDate;
	}

	public void setNbEffDate(Date nbEffDate) {
		this.nbEffDate = nbEffDate;
	}

	public Date getNbExpDate() {
		return nbExpDate;
	}

	public void setNbExpDate(Date nbExpDate) {
		this.nbExpDate = nbExpDate;
	}

	public Date getRenEffDate() {
		return renEffDate;
	}

	public void setRenEffDate(Date renEffDate) {
		this.renEffDate = renEffDate;
	}

	public Date getRenExpDate() {
		return renExpDate;
	}

	public void setRenExpDate(Date renExpDate) {
		this.renExpDate = renExpDate;
	}

	public String getLob() {
		return lob;
	}

	public void setLob(String lob) {
		this.lob = lob;
	}

	public String getPolicyType() {
		return policyType;
	}

	public void setPolicyType(String policyType) {
		this.policyType = policyType;
	}

	public String getContractType() {
		return contractType;
	}

	public void setContractType(String contractType) {
		this.contractType = contractType;
	}
	
	
}
