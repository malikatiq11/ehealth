package com.ehealth.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class NationalityCitizenship {
	
	@Id
	@GeneratedValue
	public int NcId;
	
	public String NcName;

	public int getncId() {
		return NcId;
	}

	public void setNCId(int nCId) {
		NcId = nCId;
	}

	public String getncName() {
		return NcName;
	}

	public void setNcName(String ncName) {
		NcName = ncName;
	}

}
