package com.ehealth.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class RquestPatientVisit {
	@Id
	@GeneratedValue
	public int Id;
	
	public int getId() {
		return Id;
	}

	public Date getVisitDate() {
		return VisitDate;
	}

	public void setVisitDate(Date visitDate) {
		VisitDate = visitDate;
	}

	public void setId(int id) {
		Id = id;
	}

	public RequestPanel getRequestpanel() {
		return requestpanel;
	}

	public void setRequestpanel(RequestPanel requestpanel) {
		this.requestpanel = requestpanel;
	}

	public PatientVisit getPatientVisit() {
		return patientVisit;
	}

	public void setPatientVisit(PatientVisit patientVisit) {
		this.patientVisit = patientVisit;
	}

	@OneToOne(optional=false)
	@JoinColumn(name="ReqId")
	public RequestPanel requestpanel;
	
	@OneToOne(optional=false)
	@JoinColumn(name="VisitId")
	public PatientVisit patientVisit;
	
	public Date VisitDate;

}
