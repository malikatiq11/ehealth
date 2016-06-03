package com.ehealth.controller;

import java.net.PasswordAuthentication;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ehealth.dao.AdminDAOImpl;
import com.ehealth.dao.PatientVisitDAOImpl;
import com.ehealth.dao.RegistrationDAOImpl;
import com.ehealth.hl7.ParseObservationMessage;
import com.ehealth.model.Admin;
import com.ehealth.model.PatientVisit;
import com.ehealth.model.Registration;
import com.ehealth.model.Response;
import com.ehealth.model.RquestPatientVisit;
import com.ehealth.wrapper.FilterWrapper;
import com.ehealth.wrapper.LoginWrapper;

@Controller

public class AdminController {
	@Autowired
	RegistrationDAOImpl registrationdaoimpl;

	@Autowired
	AdminDAOImpl admindaoimpl;

	@Autowired
	PatientVisitDAOImpl patientvisitdaoimpl;

	Response response;

	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public String Admin() {

		// ParseObservationMessage observation=new ParseObservationMessage();
		// observation.ParserMessage("hi there");

		return "Admin/index";
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String Login() {

		return "Admin/login";
	}

	@RequestMapping(value = "/StaffAccount", method = RequestMethod.GET)
	public String StaffAccount() {

		return "Admin/UserAccount";
	}

	@RequestMapping(value = "/PostAccount", method = RequestMethod.POST)
	public @ResponseBody Response PostAccount(@RequestBody Registration registration) {
		System.out.println(registration.getPassword());
		registrationdaoimpl.add(registration);
		return new Response();
	}

	@RequestMapping(value = "/LoginAuthentication", method = RequestMethod.POST)
	public @ResponseBody Response LoginAuthentication(@RequestBody LoginWrapper login) {
		response = new Response();

		List<Admin> list = admindaoimpl.Authentication(login.getUserName(), login.getPassword());
		if (list.size() != 0) {
			response.setStatus("10");

		} else {
			response.setStatus("11");
		}
		return response;
	}

	@RequestMapping(value = "/PatientHistory", method = RequestMethod.GET)
	public String PatientHistory() {

		return "Admin/PatientHistory";
	}

	@RequestMapping(value = "/GetPatientHistory", method = RequestMethod.GET)
	public @ResponseBody List<PatientVisit> GetPatientHistory() {

		return patientvisitdaoimpl.getList();
	}

	@RequestMapping(value = "/FilterData", method = RequestMethod.POST)
	public @ResponseBody List<PatientVisit> FilterData(@RequestBody FilterWrapper wrapper) {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		List<PatientVisit> list = null;
		List<PatientVisit> sendlist = new ArrayList<PatientVisit>();
		if (wrapper.getDepartmentId() != 0 && wrapper.getDoctorId() != 0 && wrapper.getDate() != null) {
			list = patientvisitdaoimpl.ByDocDepartmentId(wrapper.getDepartmentId(), wrapper.getDoctorId());
			for (int i = 0; i < list.size(); i++) {
				if (dateFormat.format(wrapper.getDate()).equals(dateFormat.format(list.get(i).getVisitTime()))) {
					sendlist.add(list.get(i));
				}

			}
		} else if (wrapper.getDepartmentId() != 0 && wrapper.getDoctorId() != 0) {
			sendlist = patientvisitdaoimpl.ByDocDepartmentId(wrapper.getDepartmentId(), wrapper.getDoctorId());
		} else if (wrapper.getDepartmentId() != 0) {
			sendlist = patientvisitdaoimpl.ByDepartmentId(wrapper.getDepartmentId());
		} else if (wrapper.getDate() != null) {
			list = patientvisitdaoimpl.getList();
			for (int i = 0; i < list.size(); i++) {
				if (dateFormat.format(wrapper.getDate()).equals(dateFormat.format(list.get(i).getVisitTime()))) {
					sendlist.add(list.get(i));
				}
			}
		}

		return sendlist; // patientvisitdaoimpl.getList();
	}
	
}
