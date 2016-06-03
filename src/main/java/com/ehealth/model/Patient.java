package com.ehealth.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import javafx.scene.chart.PieChart.Data;

@Entity
public class Patient {

	@Id
	@GeneratedValue
	public int PatientId;
	
	public String Cnic;
	public String PatientName;
	public String FamilyName;
	public String MothersMaidenName;
	
	
	

	public String Sex;
	public String Address;
	public String Street;
	public String Designation;
	public Date DOB;
	
	

	@ManyToOne(optional=false)
	@JoinColumn(name="CityId")
	public City city;
	
	@ManyToOne(optional=false)
	@JoinColumn(name="StateId")
	public State state;
	
	@ManyToOne(optional=false)
	@JoinColumn(name="CountryId")
	public Country country;
	
	public long PhoneNumberHome;
	public String Email;
	
	public int PhoneNumberPersonalBusiness;
	
	@OneToOne(optional=false)
	@JoinColumn(name="PrimaryLanguage")
	public Language language;
	
	public String MaritalStatus;
	
	@OneToOne(optional=false)
	@JoinColumn(name="Religion")
	public Religion religion;
	
	public String AccountNumber;
	
	public String EthnicGroup;
	
	public String BirthPlace;
	
	@OneToOne(optional=false)
	@JoinColumn(name="Citizenship")
	public NationalityCitizenship citizenship;
	
	@OneToOne(optional=false)
	@JoinColumn(name="Nationality")
	public NationalityCitizenship nationality;
	
	public Date DeathDateTime;
	
	public int getpatientId() {
		return PatientId;
	}

	public Date getdOB() {
		return DOB;
	}

	public void setDOB(Date dOB) {
		DOB = dOB;
	}

	public void setPatientId(int patientId) {
		PatientId = patientId;
	}

	public String getcnic() {
		return Cnic;
	}

	public void setCnic(String cnic) {
		Cnic = cnic;
	}

	public String getpatientName() {
		return PatientName;
	}

	public void setPatientName(String patientName) {
		PatientName = patientName;
	}

	public String getfamilyName() {
		return FamilyName;
	}

	public void setFamilyName(String familyName) {
		FamilyName = familyName;
	}

	public String getmothersMaidenName() {
		return MothersMaidenName;
	}

	public void setMothersMaidenName(String mothersMaidenName) {
		MothersMaidenName = mothersMaidenName;
	}

	public String getsex() {
		return Sex;
	}

	public void setSex(String sex) {
		Sex = sex;
	}

	public String getaddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	public String getstreet() {
		return Street;
	}

	public void setStreet(String street) {
		Street = street;
	}

	public String getdesignation() {
		return Designation;
	}

	public void setDesignation(String designation) {
		Designation = designation;
	}

	public City getcity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	public State getstate() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public Country getcountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	public long getphoneNumberHome() {
		return PhoneNumberHome;
	}

	public void setPhoneNumberHome(long phoneNumberHome) {
		PhoneNumberHome = phoneNumberHome;
	}

	public String getemail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public int getphoneNumberPersonalBusiness() {
		return PhoneNumberPersonalBusiness;
	}

	public void setPhoneNumberPersonalBusiness(int phoneNumberPersonalBusniness) {
		PhoneNumberPersonalBusiness = phoneNumberPersonalBusniness;
	}

	public Language getlanguage() {
		return language;
	}

	public void setLanguage(Language language) {
		this.language = language;
	}

	public String getmaritalStatus() {
		return MaritalStatus;
	}

	public void setMaritalStatus(String martialStatus) {
		MaritalStatus = martialStatus;
	}

	public Religion getreligion() {
		return religion;
	}

	public void setReligion(Religion religion) {
		this.religion = religion;
	}

	public String getaccountNumber() {
		return AccountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		AccountNumber = accountNumber;
	}

	public String getethnicGroup() {
		return EthnicGroup;
	}

	public void setEthnicGroup(String ethnicGroup) {
		EthnicGroup = ethnicGroup;
	}

	public String getbirthPlace() {
		return BirthPlace;
	}

	public void setBirthPlace(String birthPlace) {
		BirthPlace = birthPlace;
	}

	public NationalityCitizenship getcitizenship() {
		return citizenship;
	}

	public void setCitizenship(NationalityCitizenship citizenship) {
		this.citizenship = citizenship;
	}

	public NationalityCitizenship getnationality() {
		return nationality;
	}

	public void setNationality(NationalityCitizenship nationality) {
		this.nationality = nationality;
	}

	public Date getdeathDateTime() {
		return DeathDateTime;
	}

	public void setDeathDateTime(Date deathDateTime) {
		DeathDateTime = deathDateTime;
	}


	
	
	
	
	
	
}
