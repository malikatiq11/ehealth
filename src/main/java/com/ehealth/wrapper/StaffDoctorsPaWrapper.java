package com.ehealth.wrapper;

import com.ehealth.model.DoctorsPa;
import com.ehealth.model.Staff;

public class StaffDoctorsPaWrapper {
	public Staff staff;
	public DoctorsPa dp;
	public Staff getStaff() {
		return staff;
	}
	public void setStaff(Staff staff) {
		this.staff = staff;
	}
	public DoctorsPa getDp() {
		return dp;
	}
	public void setDp(DoctorsPa dp) {
		this.dp = dp;
	}

}
