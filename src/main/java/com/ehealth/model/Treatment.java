package com.ehealth.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Treatment {
	
	@Id
	@GeneratedValue
	public int TreatmentId;
	
	public String Symptom;
	public String Investigation;
	public String PatientProcedure;
	
	public Date VisitTime;
	
	
	public Date getVisitTime() {
		return VisitTime;
	}

	public void setVisitTime(Date visitTime) {
		VisitTime = visitTime;
	}

	@OneToOne(optional=false)
	@JoinColumn(name="VId")
	public PatientVisit patientVisit;

	public int gettreatmentId() {
		return TreatmentId;
	}

	public void setTreatmentId(int treatmentId) {
		TreatmentId = treatmentId;
	}

	public String getsymptom() {
		return Symptom;
	}

	public void setSymptom(String symptom) {
		Symptom = symptom;
	}

	public String getinvestigation() {
		return Investigation;
	}

	public void setInvestigation(String investigation) {
		Investigation = investigation;
	}

	public String getpatientProcedure() {
		return PatientProcedure;
	}

	public void setPatientProcedure(String patientProcedure) {
		PatientProcedure = patientProcedure;
	}

	public PatientVisit getPatientVisit() {
		return patientVisit;
	}

	public void setPatientVisit(PatientVisit patientVisit) {
		this.patientVisit = patientVisit;
	}
	

}
