package com.ksg.formslibrary.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ksg.formslibrary.dao.ListValueDAO;
import com.ksg.formslibrary.domain.ListValues;

@Service
public class ListValueServiceImpl implements ListValueService {
	private static final Logger log = Logger.getLogger(ListValueServiceImpl.class);
	
	@Autowired
	ListValueDAO dao; 
	
	/**
	 * Returns available search criteria
	 */
	@Override
	public ListValues getListValues() {
		log.info("getting list values from source...");
		//TODO:  check cache entry first
		ListValues listValues = new ListValues();
		
		listValues.setPolicyTypeList(dao.getAllPolicyTypes());
		listValues.setStateList(dao.getAllStates());
		listValues.setCompanyList(dao.getAllCompanies());
		listValues.setLobList(dao.getAllLOBs());
		listValues.setFormTypeList(dao.getAllFormTypes());
		listValues.setMandOptList(dao.getAllMandOpt());
		
		return listValues;
	}

}
