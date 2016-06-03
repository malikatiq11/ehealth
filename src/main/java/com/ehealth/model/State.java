package com.ehealth.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class State {
	
	@Id
	@GeneratedValue
	public int StateId;
	
	public String StateName;
	
	public int getstateId() {
		return StateId;
	}

	public void setStateId(int stateId) {
		StateId = stateId;
	}

	public String getstateName() {
		return StateName;
	}

	public void setStateName(String stateName) {
		StateName = stateName;
	}

	public Country getcountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	

	

	@ManyToOne(optional=false)
	@JoinColumn(name="CountryId")
	public Country country;
	

}
