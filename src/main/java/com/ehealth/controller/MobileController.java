package com.ehealth.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ehealth.dao.DoctorDAOImpl;
import com.ehealth.dao.MobPatientDAOImpl;
import com.ehealth.dao.PatientDAOImpl;
import com.ehealth.model.Doctor;
import com.ehealth.model.MobPatient;
import com.ehealth.model.Patient;
import com.ehealth.model.Response;

@Controller
public class MobileController {
	@Autowired
	DoctorDAOImpl doctordaoimpl;
	@Autowired
	MobPatientDAOImpl mobilepatientdaoimpl;
	
	@Autowired
	PatientDAOImpl patientdaoimpl;
	
	
	@RequestMapping(value = "/GetDoctorData", method = RequestMethod.POST)
	public @ResponseBody List<Doctor> mobile() {
		List<Doctor> doctor=doctordaoimpl.getList();
		for(int i=0; i<doctor.size(); i++)
		{
			Doctor doc=doctor.get(i);
			doc.setContent(null);
			doctor.remove(i);
			doctor.add(i, doc);
		}
		return doctor;
	}
	@RequestMapping(value = "/GetPatientData", method = RequestMethod.POST)
	public @ResponseBody List<MobPatient> GetPatientDat() {
		return mobilepatientdaoimpl.getList();
	}
	@RequestMapping(value = "/SignUP", method = RequestMethod.POST)
	public @ResponseBody Response SignUP(@RequestParam("Name") String Name,@RequestParam("Cnic") String Cnic,@RequestParam("Password") String Password,@RequestParam("Contact") String Contact,@RequestParam("Gender") String Gender,@RequestParam("Dob") String Dob,@RequestParam("Email") String Email) {
		List<MobPatient> moblist=new ArrayList<MobPatient>();
		List<Doctor> doclist=new ArrayList<Doctor>();
		moblist=mobilepatientdaoimpl.CheckEmail(Email);
		if(moblist.size()==0)
		{
			doclist=doctordaoimpl.CheckEmail(Email);
			if(doclist.size()==0)
			{
				MobPatient patient=new MobPatient();
				patient.setName(Name);
				patient.setCnic(Cnic);
				patient.setContact(Contact);
				patient.setDob(Dob);
				patient.setGender(Gender);
				patient.setPassword(Password);
				patient.setEmail(Email);
				mobilepatientdaoimpl.add(patient);
				
				return new Response("10","Registered");
			}
			else
			{
				return new Response("12","already Registered as doctor");
			}
		}
		else
		{
			return new Response("11","already Registered");
		}
		
	}
	
	@RequestMapping(value = "/SignIN", method = RequestMethod.POST)
	public @ResponseBody Map<String,Object> SignIN(@RequestParam("Email") String Email,@RequestParam("Password") String Password) {
		Map<String,Object> map=new HashMap<String,Object>();
		List<MobPatient> patient=mobilepatientdaoimpl.Authentication(Email, Password);
		if(patient.size()!=0)
		{
			map.put("Role", "Patient");
			map.put("Data", patient.get(0));
			return map;
		}
		else
		{
			List<Doctor> doc=doctordaoimpl.Authentication(Email, Password);
			if(doc.size()!=0)
			{
				map.put("Role", "Doctor");
				map.put("Data",doc.get(0));
				return map;
			}
		}
		
		return null;
	}

}
