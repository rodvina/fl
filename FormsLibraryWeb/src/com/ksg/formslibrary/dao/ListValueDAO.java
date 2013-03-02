package com.ksg.formslibrary.dao;

import java.util.List;

import com.ksg.formslibrary.domain.KeyValue;
import com.ksg.formslibrary.domain.SearchCriteria;

public interface ListValueDAO {

	List<KeyValue> getAllStates();
	List<KeyValue> getAllLOBs();
	List<KeyValue> getAllPolicyTypes();
	List<KeyValue> getAllCompanies();
	List<KeyValue> getAllFormTypes();
	List<KeyValue> getAllMandOpt();

}
