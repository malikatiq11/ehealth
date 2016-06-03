package com.ehealth.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity

public class City {
	@Id
	@GeneratedValue
	public int CityId;
	public String CityName;

	
	public int ZipCode;

	public void setZipCode(int zipCode) {
		ZipCode = zipCode;
	}

	public int getZipCode() {
		return ZipCode;
	}

	@ManyToOne(optional = false)
	@JoinColumn(name = "CountryId")
	public Country country;

	@ManyToOne(optional = false)
	@JoinColumn(name = "StateId")
	public State state;

	public int getcityId() {
		return CityId;
	}

	public void setCityId(int cityId) {
		CityId = cityId;
	}

	public String getcityName() {
		return CityName;
	}

	public void setCityName(String cityName) {
		CityName = cityName;
	}

	public Country getcountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	public State getstate() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

}
