package com.ksg.formslibrary.service;

import java.util.List;

import com.kahg.jcf.errors.ApplicationException;
import com.ksg.formslibrary.domain.Form;
import com.ksg.formslibrary.domain.ListValues;
import com.ksg.formslibrary.domain.SearchCriteria;

public interface FormsLibraryService {
	
	List<Form> getForms();

	List<Form> search(SearchCriteria searchCriteria) throws FormsLibraryServiceException;
	
	List<Form> searchDetail(String formname) throws FormsLibraryServiceException;

}
