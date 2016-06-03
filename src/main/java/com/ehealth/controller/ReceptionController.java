package com.ehealth.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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

import com.ehealth.dao.AppointmentDAOImpl;
import com.ehealth.dao.DoctorDAOImpl;
import com.ehealth.dao.PatientDAOImpl;
import com.ehealth.dao.RegistrationDAOImpl;
import com.ehealth.dao.RequestPanelDAOImpl;
import com.ehealth.model.Appointment;
import com.ehealth.model.Doctor;
import com.ehealth.model.Patient;
import com.ehealth.model.Registration;
import com.ehealth.model.RequestPanel;
import com.ehealth.model.Response;
import com.ehealth.wrapper.DateWrapper;
import com.ehealth.wrapper.LoginWrapper;

@Controller
public class ReceptionController {
	
	@Autowired
	PatientDAOImpl patientdaoimpl;
	@Autowired
	DoctorDAOImpl doctordaoimpl;
	
	@Autowired
	RequestPanelDAOImpl requestdaoimpl;
	
	@Autowired
	RegistrationDAOImpl registrationdaoimpl;
	
	@Autowired
	AppointmentDAOImpl appointmentdaoimpl;
	
	
	
	Response response;
	@RequestMapping(value = "/reception", method = RequestMethod.GET)
	public String AdminService() {

		return "Reception/index";
	}
	@RequestMapping(value = "/receptionlogin", method = RequestMethod.GET)
	public String ReceptionLogin() {
		System.out.println("come here");
		return "Reception/login";
	}

	@RequestMapping(value = "/ReceptionPage", method = RequestMethod.GET)
	public String ReceptionService() {
		System.out.println("Come to that controller");
		return "Reception/Reception";
	}
	@RequestMapping(value = "/SearchPatientbyIDCNIC", method = RequestMethod.GET)
	public @ResponseBody  Patient SearchPatientbyIDCNIC(@RequestParam int id,@RequestParam String cnic) {
		
		Patient pt=new Patient();
		Patient pp=null;
		if(cnic.equals("") && id!=0)
		 pp=patientdaoimpl.getRowById(id);
		else if(!cnic.equals("") && id==0)
			pp=patientdaoimpl.getRowByCnic(cnic);
		else
			pp=patientdaoimpl.getRowByIdCnic(id,cnic);
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
		
		
		return pt;
	
	}
	@RequestMapping(value = "/SearchDoctorbyDepartment", method = RequestMethod.GET)
	public @ResponseBody  List<Doctor> SearchDoctorbyDepartment(@RequestParam int id) {
		
		return doctordaoimpl.getDoctorByDepartment(id);
	}
	@RequestMapping(value = "/PostVisitRequest", method = RequestMethod.POST)
	public @ResponseBody  Response PostVisitRequest(@RequestBody RequestPanel panel) {
		
		Calendar cal = Calendar.getInstance();
		panel.setStatus("New");
		panel.setVisitTime(cal.getTime());
		requestdaoimpl.add(panel);
		response=new Response();
		response.setStatus("done");
		return response;
	}
	@RequestMapping(value = "/ReceptionistAuthenticate", method = RequestMethod.POST)
	public @ResponseBody Map<String,Object> ReceptionistAuthenticate(@RequestBody LoginWrapper login) {
		

		List<Registration> list= registrationdaoimpl.Authentication(login.getUserName(), login.getPassword());
		Map<String,Object> model=new HashMap<String,Object>();

		if(list.size()!=0)
		{
		
				model.put("Status", 10);
				model.put("StaffInfo", list.get(0));
			
		}
		else
		{
			model.put("Status", 11);
		}
		return model;
	}
	@RequestMapping(value = "/AppointmentList", method = RequestMethod.GET)
	public String AppointmentList() {
		
		return "Reception/AppointmentList";
	}
	
	@RequestMapping(value = "/GetAppointmentList", method = RequestMethod.POST)
	public @ResponseBody List<Appointment> GetAppointmentList(@RequestBody DateWrapper wrapper) {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		List<Appointment> source=appointmentdaoimpl.getList();
		List<Appointment> destination=new ArrayList<Appointment>();
		for(int i=0; i<source.size(); i++)
		{
			if(dateFormat.format(source.get(i).getAppointmentDate()).equals(dateFormat.format(wrapper.getDate())))
			{
				destination.add(source.get(i));
			}
				
		}
		return destination;
	}
	
}
