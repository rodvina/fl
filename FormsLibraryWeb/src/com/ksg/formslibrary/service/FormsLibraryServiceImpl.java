package com.ksg.formslibrary.service;

import java.util.ArrayList;
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
public class FormsLibraryServiceImpl implements FormsLibraryService {
	private static final Logger log = Logger.getLogger(FormsLibraryServiceImpl.class);
	
	@Autowired
	SynchronousJMS synchronousJMS;
	
	@Autowired
	@Qualifier("searchDestination")
	Destination searchDestination;

	@Autowired
	@Qualifier("detailsDestination")
	Destination detailsDestination;
	
	private List<Form> forms = new ArrayList<Form>();
	
	@Override
	public List<Form> getForms() {
		return forms;
	}

	@Override
	public List<Form> search(SearchCriteria searchCriteria) throws FormsLibraryServiceException {
		log.info("searching for forms based on the following criteria: " + searchCriteria);
		// TODO Add logic to use client jar to
		
		String message = null;
		try {
			String response = synchronousJMS.send(message, searchDestination);
			
		} catch (JMSException e) {
			log.error(message, e);
			throw new FormsLibraryServiceException(e);
		}
		
		List<Form> forms = new ArrayList<Form>();

		return forms;
	}

	@Override
	public List<Form> searchDetail(String formname)
			throws FormsLibraryServiceException {
		// TODO Auto-generated method stub
		return null;
	}



}
