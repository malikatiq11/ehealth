package com.ehealth.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity 
public class Appointment {
	@Id
	@GeneratedValue
	public int AppointmentId;
	
	@OneToOne(optional=false)
	@JoinColumn(name="PatientId")
	public Patient patient;
	
	@OneToOne(optional=false)
	@JoinColumn(name="DoctorId")
	public Doctor doctor;
	
	@OneToOne(optional=false)
	@JoinColumn(name="DepartmentId")
	public Department department;
	
	public Date AppointmentDate;

	public int getAppointmentId() {
		return AppointmentId;
	}

	public void setAppointmentId(int appointmentId) {
		AppointmentId = appointmentId;
	}

	public Patient getPatient() {
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

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public Date getAppointmentDate() {
		return AppointmentDate;
	}

	public void setAppointmentDate(Date appointmentDate) {
		AppointmentDate = appointmentDate;
	}

}
