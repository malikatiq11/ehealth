package com.ehealth.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class PatientVisit {

	@Id
	@GeneratedValue
	public int VisitId;
	
	public String PatientClass;
	
	public String AssignedPatientLocation;
	public String AdmissionType;
	
	@OneToOne(optional=false)
	@JoinColumn(name="DoctorId")
	public Doctor doctor;
	
	public String Tempreture;
	public String Weight;
	public String Pulse;
	public String BP;
	public String Pressure;
	
	public Date VisitTime;
	
	public Date getVisitTime() {
		return VisitTime;
	}

	public void setVisitTime(Date visitTime) {
		VisitTime = visitTime;
	}

	public String getpressure() {
		return Pressure;
	}

	public void setPressure(String pressure) {
		Pressure = pressure;
	}

	public int getvisitId() {
		return VisitId;
	}

	public void setVisitId(int visitId) {
		VisitId = visitId;
	}

	public String getpatientClass() {
		return PatientClass;
	}

	public void setPatientClass(String patientClass) {
		PatientClass = patientClass;
	}

	public String getassignedPatientLocation() {
		return AssignedPatientLocation;
	}

	public void setAssignedPatientLocation(String assignedPatientLocation) {
		AssignedPatientLocation = assignedPatientLocation;
	}

	public String getadmissionType() {
		return AdmissionType;
	}

	public void setAdmissionType(String admissionType) {
		AdmissionType = admissionType;
	}

	public Doctor getdoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	public String gettempreture() {
		return Tempreture;
	}

	public void setTempreture(String tempreture) {
		Tempreture = tempreture;
	}

	public String getweight() {
		return Weight;
	}

	public void setWeight(String weight) {
		Weight = weight;
	}

	public String getpulse() {
		return Pulse;
	}

	public void setPulse(String pulse) {
		Pulse = pulse;
	}

	public String getbP() {
		return BP;
	}

	public void setBP(String bP) {
		BP = bP;
	}

	public Department getdepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	@OneToOne(optional=false)
	@JoinColumn(name="DepartmentId")
	public Department department;
	
	@ManyToOne(optional=false)
	@JoinColumn(name="PatientId")
	public Patient patient;

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	
}
