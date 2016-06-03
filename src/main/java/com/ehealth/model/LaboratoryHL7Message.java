package com.ehealth.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class LaboratoryHL7Message {
	
	@Id
	@GeneratedValue
	public int Id;
	
	@OneToOne(optional=false)
	@JoinColumn(name="PatientId")
	public Patient patient;
	
	public String LaboratoryName;
	
	public String getLaboratoryName() {
		return LaboratoryName;
	}

	public void setLaboratoryName(String laboratoryName) {
		LaboratoryName = laboratoryName;
	}

	public String Cnic;
	
	
	public String getCnic() {
		return Cnic;
	}

	public void setCnic(String cnic) {
		Cnic = cnic;
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public String getMessage() {
		return Message;
	}

	public void setMessage(String message) {
		Message = message;
	}

	public String Message;
	
	

}
