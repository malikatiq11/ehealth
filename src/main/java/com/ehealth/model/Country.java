package com.ehealth.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Country {
	
	@Id
	@GeneratedValue
	public int CountryId;
	
	public String CountryName;
	
	public int getcountryId() {
		return CountryId;
	}

	public void setCountryId(int countryId) {
		CountryId = countryId;
	}

	public String getcountryName() {
		return CountryName;
	}

	public void setCountryName(String countryName) {
		CountryName = countryName;
	}

	public int getcountryCode() {
		return CountryCode;
	}

	public void setCountryCode(int countryCode) {
		CountryCode = countryCode;
	}

	public int CountryCode;
	

}
