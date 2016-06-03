package com.ehealth.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class DoctorPanel {
	@Id
	@GeneratedValue
	public int DoctorPanelId;
	
	public int Notify;
	
	
	public int getNotify() {
		return Notify;
	}

	public void setNotify(int notify) {
		Notify = notify;
	}

	@OneToOne(optional=false)
	@JoinColumn(name="ReqId")
	public RequestPanel requestpanel;
	
	public int getDoctorPanelId() {
		return DoctorPanelId;
	}

	public void setDoctorPanelId(int doctorPanelId) {
		DoctorPanelId = doctorPanelId;
	}

	public RequestPanel getRequestpanel() {
		return requestpanel;
	}

	public void setRequestpanel(RequestPanel requestpanel) {
		this.requestpanel = requestpanel;
	}

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	@OneToOne(optional=false)
	@JoinColumn(name="DocId")
	public Doctor doctor;
}
