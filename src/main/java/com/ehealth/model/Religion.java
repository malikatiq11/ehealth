package com.ehealth.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Religion {
	@Id
	@GeneratedValue
	public int ReligionId;
	public int getreligionId() {
		return ReligionId;
	}
	public void setReligionId(int religionId) {
		ReligionId = religionId;
	}
	public String getreligionName() {
		return ReligionName;
	}
	public void setReligionName(String religionName) {
		ReligionName = religionName;
	}
	public String ReligionName;

}
