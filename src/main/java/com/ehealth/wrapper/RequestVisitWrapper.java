package com.ehealth.wrapper;

import com.ehealth.model.PatientVisit;

public class RequestVisitWrapper {
	
	public PatientVisit visit; 
	public int ReqId;
	public PatientVisit getVisit() {
		return visit;
	}
	public void setVisit(PatientVisit visit) {
		this.visit = visit;
	}
	public int getReqId() {
		return ReqId;
	}
	public void setReqId(int reqId) {
		ReqId = reqId;
	}
	

}
