package com.ksg.formslibrary.dao;

import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import com.ksg.formslibrary.domain.KeyValue;

@Repository
public class ListValueDAOImpl implements ListValueDAO {

	@Override
	public List<KeyValue> getAllStates() {
		return Arrays.asList(new KeyValue[] {
				new KeyValue("01", "Alabama"),
				new KeyValue("02", "Alaska"),
				new KeyValue("03", "Arizona"),
				new KeyValue("04", "Arkansas"),
				new KeyValue("05", "California"),
				new KeyValue("06", "Colorado"),
				new KeyValue("07", "Connecticut")
				
		});
	}

	@Override
	public List<KeyValue> getAllLOBs() {
		return Arrays.asList(new KeyValue[] {
				new KeyValue("01", "Auto Monoline"),
				new KeyValue("02", "Auto Package"),
				new KeyValue("03", "Home Monoline"),
				new KeyValue("04", "Home Package")				
		});
	}

	@Override
	public List<KeyValue> getAllPolicyTypes() {
		return Arrays.asList(new KeyValue[] {
				new KeyValue("01", "Auto Single"),
				new KeyValue("02", "Auto Split"),
				new KeyValue("03", "HE 7"),
				new KeyValue("04", "HO-2/HO-A+"),
				new KeyValue("05", "HO-3/HO-B"),
				new KeyValue("06", "HO-4/HO-BT"),
				new KeyValue("07", "HO-5/HO-C")
				
		});
	}

	@Override
	public List<KeyValue> getAllCompanies() {
		return Arrays.asList(new KeyValue[] {
				new KeyValue("01", "AMICO - American Independent Insurance Co"),
				new KeyValue("02", "AMM"),
				new KeyValue("03", "AMPICO"),
				new KeyValue("04", "KGA"),
				new KeyValue("05", "KIC"),
				new KeyValue("06", "LMC"),
				new KeyValue("07", "TLOYDS")
				
		});
	}

	@Override
	public List<KeyValue> getAllFormTypes() {
		return Arrays.asList(new KeyValue[] {
				new KeyValue("01", "Endorsement"),
				new KeyValue("02", "Insert")
				
		});
	}

	@Override
	public List<KeyValue> getAllMandOpt() {
		return Arrays.asList(new KeyValue[] {
			new KeyValue("01", "Mandatory"),
			new KeyValue("02", "Optional")
		});
	}
}
