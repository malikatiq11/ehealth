package com.ehealth.controller;

import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ehealth.dao.DoctorDAOImpl;
import com.ehealth.dao.DoctorPanelDAOImpl;
import com.ehealth.dao.LaboratoryHL7MessageDAOImpl;
import com.ehealth.dao.PatientDAOImpl;
import com.ehealth.dao.PatientVisitDAOImpl;
import com.ehealth.dao.RequestPanelDAOImpl;
import com.ehealth.dao.RquestPatientVisitDAOImpl;
import com.ehealth.dao.TreatmentDAOImpl;
import com.ehealth.hl7.CreateLaboratoryMessage;
import com.ehealth.model.Department;
import com.ehealth.model.Doctor;
import com.ehealth.model.DoctorPanel;
import com.ehealth.model.LaboratoryHL7Message;
import com.ehealth.model.Patient;
import com.ehealth.model.PatientVisit;
import com.ehealth.model.RequestPanel;
import com.ehealth.model.Response;
import com.ehealth.model.RquestPatientVisit;
import com.ehealth.model.Treatment;
import com.ehealth.wrapper.IDWrapper;
import com.ehealth.wrapper.LaboratoryWrapper;
import com.ehealth.wrapper.LoginWrapper;
import com.ehealth.wrapper.RequestVisitWrapper;

@Controller
public class PatientVisitController {
	@Autowired
	PatientVisitDAOImpl doimpl;

	@Autowired
	TreatmentDAOImpl treatmentDAO;
	@Autowired
	RequestPanelDAOImpl requestdaoimpl;

	@Autowired
	RquestPatientVisitDAOImpl rvdaoimpl;

	@Autowired
	DoctorPanelDAOImpl doctorpaneldaoimpl;

	@Autowired
	DoctorDAOImpl doctordaoimpl;

	@Autowired
	LaboratoryHL7MessageDAOImpl labdaoimpl;

	@Autowired
	PatientDAOImpl patientdaoimpl;

	Response response;

	@RequestMapping(value = "/treatment", method = RequestMethod.GET)
	public String GetTreatment() {

		return "Treatment/index";
	}

	@RequestMapping(value = "/TreatmentLogin", method = RequestMethod.GET)
	public String TreatmentLogin() {

		return "Treatment/login";
	}

	@RequestMapping(value = "/AuthenticateDoctor", method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> AuthenticateDoctor(@RequestBody LoginWrapper login) {
		response = new Response();

		List<Doctor> list = doctordaoimpl.Authentication(login.getUserName(), login.getPassword());
		Map<String, Object> model = new HashMap<String, Object>();
		if (list.size() != 0) {
			model.put("Status", "10");
			model.put("DoctorData", list.get(0));

		} else {
			model.put("Status", "11");
		}
		return model;
	}

	@RequestMapping(value = "/InsertVisit", method = RequestMethod.GET)
	public String GetService() {

		return "InsertPatientVisit";
	}

	@RequestMapping(value = "/PostVisit", method = RequestMethod.POST)
	public @ResponseBody Response PostDepartmentService(@RequestBody RequestVisitWrapper object) {
		
		PatientVisit visit=object.getVisit();
		Calendar cal=Calendar.getInstance();
		visit.setVisitTime(cal.getTime());
		int id = doimpl.add(visit);
		RquestPatientVisit rv = new RquestPatientVisit();
		PatientVisit pv = new PatientVisit();
		pv.setVisitId(id);
		rv.setPatientVisit(pv);
		

		RequestPanel panel = new RequestPanel();
		panel.setReqId(object.getReqId());

		rv.setRequestpanel(panel);
		Calendar call=Calendar.getInstance();
		rv.setVisitDate(call.getTime());

		rvdaoimpl.add(rv);

		response = new Response();
		response.setStatus("Data Inserted");
		response.setDescription("Data inserted on Department Table");
		return response;
	}

	@RequestMapping(value = "/GetNotification", method = RequestMethod.GET)
	public @ResponseBody Map<String, Object> GetNotification() {
		Map<String, Object> map=new HashMap<String, Object>();
		List<DoctorPanel> list=doctorpaneldaoimpl.getList();
		if(list.size()!=0)
		{
			for(int i=0; i<list.size(); i++)
			{
				if(list.get(i).getNotify()==0)
				{
					DoctorPanel panel=new DoctorPanel();
					DoctorPanel pp=list.get(i);
					panel.setDoctor(pp.getDoctor());
					panel.setDoctorPanelId(pp.getDoctorPanelId());
					panel.setNotify(1);
					panel.setRequestpanel(pp.getRequestpanel());
					doctorpaneldaoimpl.updateRow(panel);
					map.put("information", panel);
					map.put("Status", "10");
					return map;
				}
			}
		}
		map.put("Status", "11");
		return null;
		
	}
	@RequestMapping(value = "/GetDoctorPanelRecord", method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> GetDoctorPanelRecord(@RequestBody IDWrapper wrapper) {
		Map<String, Object> model = new HashMap<String, Object>();
		int docid = wrapper.getFirst();
		List<DoctorPanel> list = doctorpaneldaoimpl.GetRequestbyDocId(docid,wrapper.getSecond());
		if (list.size() != 0) {
			DoctorPanel panel = list.get(0);
			int req = panel.getRequestpanel().getReqId();

			int visit = rvdaoimpl.GetVisitidbyReqId(req).get(0).getPatientVisit().getvisitId();

			PatientVisit pp = doimpl.getRowById(visit);
			PatientVisit pv = new PatientVisit();
			pv.setAdmissionType(pp.getadmissionType());
			pv.setAssignedPatientLocation(pp.getassignedPatientLocation());
			pv.setBP(pp.getbP());
			pv.setDepartment(pp.getdepartment());
			pv.setDoctor(pp.getdoctor());
			pv.setPatient(pp.getPatient());
			pv.setPatientClass(pp.getpatientClass());
			pv.setPressure(pp.getpressure());
			pv.setPulse(pp.getpulse());
			pv.setTempreture(pp.gettempreture());
			pv.setVisitId(pp.getvisitId());
			pv.setWeight(pp.getweight());

			 model = new HashMap<String, Object>();
			model.put("Status","10");
			model.put("Visit", pv);
			model.put("ReqId", req);
			model.put("DoctorPanelId", panel.getDoctorPanelId());
		}
		else
		{
			 model = new HashMap<String, Object>();
			model.put("Status","11");
		}

		return model;

	}

	@RequestMapping(value = "/DeleteDoctorPanelRow", method = RequestMethod.GET)
	public @ResponseBody Response DeleteDoctorPanelRow(@RequestParam int id) {

		doctorpaneldaoimpl.deleteRow(id);
		response = new Response();
		return response;
	}

	@RequestMapping(value = "/InsertTreatment", method = RequestMethod.GET)
	public String GetTreatmentService() {

		return "Treatment/InsertTreatment";
	}
	@RequestMapping(value = "/AllPatientRequest", method = RequestMethod.GET)
	public String AllPatientRequest() {

		return "Treatment/AllRequest";
	}
	
	@RequestMapping(value = "/GetPatientRequest", method = RequestMethod.GET)
	public @ResponseBody List<DoctorPanel> GetPatientRequest() {

		return doctorpaneldaoimpl.getList();
	}

	@RequestMapping(value = "/PostTreatment", method = RequestMethod.POST)
	public @ResponseBody Response PostTreatment(@RequestBody LaboratoryWrapper treatment) {
		System.out.println(treatment.getRISName());
		
		if(treatment.getReferDoctor()!=0)
		{
			RequestPanel panel=new RequestPanel();
			Department dept=new Department();
			dept.SetDepartmentId(treatment.getReferDept());
			panel.setDepartment(dept);
			Doctor doct=new Doctor();
			doct.setId(treatment.getReferDoctor());
			panel.setDoctor(doct);
			
			Patient patient=new Patient();
			patient.setPatientId(treatment.getPatientId());
			
			panel.setPatient(patient);
			
			panel.setReferFrom(treatment.getReferName());
			panel.setStatus("New");
			Calendar cal=Calendar.getInstance();
			panel.setVisitTime(cal.getTime());
			
			requestdaoimpl.add(panel);
			
		}

		Patient pt = new Patient();
		Patient pp = patientdaoimpl.getRowById(treatment.getPatientId());
		pt.setAccountNumber(pp.getaccountNumber());
		pt.setAddress(pp.getaddress());
		pt.setBirthPlace(pp.getbirthPlace());
		pt.setCitizenship(pp.getcitizenship());

		pt.setCnic(pp.getcnic());
		pt.setCountry(pp.getcountry());
		pt.setStreet(pp.getstreet());
		pt.setDeathDateTime(pp.getdeathDateTime());
		pt.setDesignation(pp.getdesignation());
		pt.setDOB(pp.getdOB());
		pt.setEmail(pp.getemail());
		pt.setEthnicGroup(pp.getethnicGroup());
		pt.setFamilyName(pp.getfamilyName());
		pt.setLanguage(pp.getlanguage());
		pt.setReligion(pp.getreligion());
		pt.setMaritalStatus(pp.getmaritalStatus());
		pt.setMothersMaidenName(pp.getmothersMaidenName());
		pt.setNationality(pp.getnationality());
		pt.setPatientId(pp.getpatientId());
		pt.setPatientName(pp.getpatientName());
		pt.setPhoneNumberHome(pp.getphoneNumberHome());
		pt.setSex(pp.getsex());
		pt.setPhoneNumberPersonalBusiness(pp.getphoneNumberPersonalBusiness());
		pt.setState(pp.getstate());
		pt.setCity(pp.getcity());

		if (treatment.TestName != null) {
			CreateLaboratoryMessage msg = new CreateLaboratoryMessage();
			String result = msg.CreateLabMessage(pt, treatment.getTestName(),"LIS");

			LaboratoryHL7Message labs = new LaboratoryHL7Message();
			labs.setMessage(result);
			labs.setPatient(pt);
			labs.setCnic(String.valueOf(pt.getcnic()));
			labs.setLaboratoryName("LIS");

			labdaoimpl.add(labs);
		}
		if(treatment.getRISName()!=null)
		{
			CreateLaboratoryMessage msg = new CreateLaboratoryMessage();
			String result = msg.CreateLabMessage(pt, treatment.getRISName(),"RIS");

			LaboratoryHL7Message labs = new LaboratoryHL7Message();
			labs.setMessage(result);
			labs.setPatient(pt);
			labs.setCnic(String.valueOf(pt.getcnic()));
			labs.setLaboratoryName("RIS");

			labdaoimpl.add(labs);
		}
		Calendar cal =Calendar.getInstance();
		Treatment tt=treatment.getTreatment();
		tt.setVisitTime(cal.getTime());
		//treatmentDAO.add(tt);
		response = new Response();
		response.setStatus("Data Inserted");
		response.setDescription("Data inserted on Department Table");
		return response;
	}

	@RequestMapping(value = "/GetLaboratoryHL7Message", method = RequestMethod.GET)
	public @ResponseBody LaboratoryHL7Message PostTreatment(@RequestParam String cnic,@RequestParam String Name) {
		LaboratoryHL7Message laboratory = labdaoimpl.GetLaboratoryMessage(cnic,Name).get(0);
		LaboratoryHL7Message lab = new LaboratoryHL7Message();
		lab.setCnic(laboratory.getCnic());
		lab.setId(laboratory.getId());
		lab.setMessage(laboratory.getMessage());
		lab.setPatient(laboratory.getPatient());
		return lab;

	}
	



}
