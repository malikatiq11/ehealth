package com.ehealth.wrapper;

import java.util.Date;

public class FilterWrapper {
	public int DepartmentId;
	public int DoctorId;
	public Date date;
	public int getDepartmentId() {
		return DepartmentId;
	}
	public void setDepartmentId(int departmentId) {
		DepartmentId = departmentId;
	}
	public int getDoctorId() {
		return DoctorId;
	}
	public void setDoctorId(int doctorId) {
		DoctorId = doctorId;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}

}
