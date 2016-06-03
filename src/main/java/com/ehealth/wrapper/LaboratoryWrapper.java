package com.ehealth.wrapper;

import com.ehealth.model.Treatment;

public class LaboratoryWrapper {

	public Treatment treatment;
	public String TestName;
	public int PatientId;

	public int ReferDept;
	public int ReferDoctor;
	public String RISName;

	public String getRISName() {
		return RISName;
	}

	public void setRISName(String rISName) {
		RISName = rISName;
	}

	public String ReferName;

	public String getReferName() {
		return ReferName;
	}

	public void setReferName(String referName) {
		ReferName = referName;
	}

	public int getReferDept() {
		return ReferDept;
	}

	public void setReferDept(int referDept) {
		ReferDept = referDept;
	}

	public int getReferDoctor() {
		return ReferDoctor;
	}

	public void setReferDoctor(int referDoctor) {
		ReferDoctor = referDoctor;
	}

	public int getPatientId() {
		return PatientId;
	}

	public void setPatientId(int patientId) {
		PatientId = patientId;
	}

	public Treatment getTreatment() {
		return treatment;
	}

	public void setTreatment(Treatment treatment) {
		this.treatment = treatment;
	}

	public String getTestName() {
		return TestName;
	}

	public void setTestName(String testName) {
		TestName = testName;
	}

}
