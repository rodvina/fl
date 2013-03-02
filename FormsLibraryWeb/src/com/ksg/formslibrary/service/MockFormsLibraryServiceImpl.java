package com.ksg.formslibrary.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.jms.Destination;
import javax.jms.JMSException;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.kahg.jcf.errors.ApplicationException;
import com.ksg.formslibrary.domain.Form;
import com.ksg.formslibrary.domain.SearchCriteria;
import com.ksg.formslibrary.jms.SynchronousJMS;
import com.ksg.formslibrary.util.FormBuilder;

@Service
@Qualifier("mock")
public class MockFormsLibraryServiceImpl implements FormsLibraryService {
	private static final Logger log = Logger.getLogger(MockFormsLibraryServiceImpl.class);

	private List<Form> forms = new ArrayList<Form>();
	
	@Override
	public List<Form> getForms() {
		return forms;
	}

	@Override
	public List<Form> search(SearchCriteria searchCriteria) throws FormsLibraryServiceException {
		log.info("searching for forms based on the following criteria: " + searchCriteria);
		// TODO Add logic to use client jar to
		

		List<Form> forms = new ArrayList<Form>();
		Form form1 = new FormBuilder().formNumber("AK2343")
				.formTitle("Lenders Loss Payable")
				.formType("Insert")
				.build();
		Form form2 = new FormBuilder().formNumber("BB1343")
				.formTitle("LIMITED COVG ATTORNEY FEES NOTICE")
				.formType("Endorsement")
				.build();
		forms.add(form1);
		forms.add(form2);
		return forms;
	}

	@Override
	public List<Form> searchDetail(String formname)
			throws FormsLibraryServiceException {
		log.info("searching form details for form: " + formname);
		List<Form> forms = new ArrayList<Form>();
		Form form1 = new FormBuilder().formNumber(formname)
				.formTitle("Lenders Loss Payable")
				.formType("Insert")
				.state("AL")
				.formEdition("2007-01-01")
				.nbEffDate(Calendar.getInstance().getTime())
				.nbExpDate(Calendar.getInstance().getTime())
				.sequence(333)
				.status("A")
				.lob("Auto")
				.company("AMICO")
				.contractType("Single")
				.policyType("Monoline")
				.build();
		Form form1a = new FormBuilder().formNumber(formname)
				.formTitle("Lenders Loss Payable")
				.formType("Insert")
				.state("AL")
				.formEdition("2007-01-01")
				.nbEffDate(Calendar.getInstance().getTime())
				.nbExpDate(Calendar.getInstance().getTime())
				.sequence(333)
				.status("A")
				.lob("Auto")
				.company("AMICO")
				.contractType("Single")
				.policyType("Package")
				.build();	
		Form form1b = new FormBuilder().formNumber(formname)
				.formTitle("Lenders Loss Payable")
				.formType("Insert")
				.state("AL")
				.formEdition("2007-01-01")
				.nbEffDate(Calendar.getInstance().getTime())
				.nbExpDate(Calendar.getInstance().getTime())
				.sequence(333)
				.status("A")
				.lob("Auto")
				.company("AMICO")
				.contractType("Split")
				.policyType("Monoline")
				.build();	
		Form form1c = new FormBuilder().formNumber(formname)
				.formTitle("Lenders Loss Payable")
				.formType("Insert")
				.state("AL")
				.formEdition("2007-01-01")
				.nbEffDate(Calendar.getInstance().getTime())
				.nbExpDate(Calendar.getInstance().getTime())
				.sequence(333)
				.status("A")
				.lob("Auto")
				.company("AMICO")
				.contractType("Split")
				.policyType("Package")
				.build();		
		Form form2 = new FormBuilder().formNumber(formname)
				.formTitle("Lenders Loss Payable")
				.formType("Insert")
				.state("CT")
				.formEdition("2007-11-01")
				.nbEffDate(Calendar.getInstance().getTime())
				.nbExpDate(Calendar.getInstance().getTime())
				.sequence(313)
				.status("A")
				.status("A")
				.lob("Home")
				.company("KAH")
				.contractType("HO/3")
				.policyType("Package")				
				.build();
		Form form3 = new FormBuilder().formNumber(formname)
				.formTitle("Lenders Loss Payable")
				.formType("Insert")
				.state("IL")
				.formEdition("2011-11-01")
				.nbEffDate(Calendar.getInstance().getTime())
				.nbExpDate(Calendar.getInstance().getTime())
				.sequence(332)
				.status("A")
				.status("A")
				.lob("Auto")
				.company("AMICO")
				.contractType("Split")
				.policyType("Package")				
				.build();			

		forms.add(form1);
		forms.add(form1a);
		forms.add(form1b);
		forms.add(form1c);
		forms.add(form2);
		forms.add(form3);
		return forms;
	}



}
