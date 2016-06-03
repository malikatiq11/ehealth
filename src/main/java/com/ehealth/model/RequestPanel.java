package com.ehealth.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class RequestPanel {
	
	@Id
	@GeneratedValue
	public int ReqId;
	
	@ManyToOne(optional=false)
	@JoinColumn(name="PID")
	public Patient patient;
	
	@ManyToOne(optional=false)
	@JoinColumn(name="DocId")
	public Doctor doctor;
	
	@ManyToOne(optional=false)
	@JoinColumn(name="DepartmentId")
	public Department department;
	
	public String ReferFrom;

	

	public String getReferFrom() {
		return ReferFrom;
	}

	public void setReferFrom(String referFrom) {
		ReferFrom = referFrom;
	}

	public String Status;
	
	public Date VisitTime;

	public int getReqId() {
		return ReqId;
	}

	public void setReqId(int reqId) {
		ReqId = reqId;
	}

	public Patient getpatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	public Department getdepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public String getstatus() {
		return Status;
	}

	public void setStatus(String status) {
		Status = status;
	}

	public Date getvisitTime() {
		return VisitTime;
	}

	public void setVisitTime(Date visitTime) {
		VisitTime = visitTime;
	}
	
	
}
