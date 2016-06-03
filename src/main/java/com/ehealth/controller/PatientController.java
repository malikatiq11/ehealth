package com.ehealth.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ehealth.dao.CityDAOImpl;
import com.ehealth.dao.CountryDAOImpl;
import com.ehealth.dao.LanguageDAOImpl;
import com.ehealth.dao.NCDAOImpl;
import com.ehealth.dao.PatientDAOImpl;
import com.ehealth.dao.ReligionDAOImpl;
import com.ehealth.dao.StateDAOImpl;
import com.ehealth.model.City;
import com.ehealth.model.Country;
import com.ehealth.model.Department;
import com.ehealth.model.Language;
import com.ehealth.model.NationalityCitizenship;
import com.ehealth.model.Patient;
import com.ehealth.model.Religion;
import com.ehealth.model.Response;
import com.ehealth.model.State;

@Controller
public class PatientController {
	
	@Autowired
	PatientDAOImpl patientdaoimpl;
	
	@Autowired
	CountryDAOImpl countrydaoimpl;
	
	@Autowired
	StateDAOImpl statedaoimpl;
	
	@Autowired
	CityDAOImpl citydaoimpl;
	
	@Autowired
	LanguageDAOImpl languagedaoimpl;
	
	@Autowired
	ReligionDAOImpl religiondaoimpl;
	
	@Autowired
	NCDAOImpl ncdaoimpl;
	
	Response response;
	
	
	
	@RequestMapping(value = "/InsertPatient", method = RequestMethod.GET)
	public String GetService() {

		return "Patient/InsertPatient";
	}



	@RequestMapping(value = "/PostPatient", method = RequestMethod.POST)
	public @ResponseBody Response PostPatientService(@RequestBody Patient patient) {
		patientdaoimpl.add(patient);
		response = new Response();
		response.setStatus("Data Inserted");
		response.setDescription("Data inserted on Department Table");
		return response;
	}
	
	@RequestMapping(value = "/EditPatient", method = RequestMethod.GET)
	public String EditPatient() {
		return "Patient/EditPatient";
	}
	
	
	@RequestMapping(value = "/GetPatientbyId", method = RequestMethod.GET)
	public @ResponseBody  Patient GetPatientbyId(@RequestParam int id) {
		Patient pt=new Patient();
		Patient pp=patientdaoimpl.getRowById(id);
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
	@RequestMapping(value = "/GetPatientbyCnic", method = RequestMethod.GET)
	public @ResponseBody  Patient GetPatientbyId(@RequestParam String cnic) {
		Patient pt=new Patient();
		Patient pp=patientdaoimpl.getRowByCnic(cnic);
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


	
	@RequestMapping(value = "/UpdatePatient", method = RequestMethod.POST)
	public @ResponseBody Response UpdatePatientService(@RequestBody Patient patient) {
	

		patientdaoimpl.updateRow(patient);
		response = new Response();
		response.setStatus("Data Updated");
		response.setDescription("Data inserted on Department Table");
		return response;
	}
	

	@RequestMapping(value = "/GetAllCountry", method = RequestMethod.GET)
	public @ResponseBody List<Country> GetCountryService() {
		
		System.out.println("in that controller");
		return countrydaoimpl.getList();
	}

	@RequestMapping(value = "/findStateBycountryid/{id}", method = RequestMethod.GET)
	public @ResponseBody  List<State> findStateBycountryid(@PathVariable("id") int id) {
	
		return statedaoimpl.findStateBycountryid(id);
	}
	@RequestMapping(value = "/findcityBystateid/{id}", method = RequestMethod.GET)
	public @ResponseBody  List<City> findcityBystateid(@PathVariable("id") int id) {
	
		return citydaoimpl.findcityBystateid(id);	
	}
	@RequestMapping(value = "/GetAllLanguage", method = RequestMethod.GET)
	public @ResponseBody List<Language> GetLanguageService() {
		
		return languagedaoimpl.getList();
	}
	@RequestMapping(value = "/GetAllReligion", method = RequestMethod.GET)
	public @ResponseBody List<Religion> GetReligionService() {
		
		return religiondaoimpl.getList();
	}
	
	@RequestMapping(value = "/GetAllNC", method = RequestMethod.GET)
	public @ResponseBody List<NationalityCitizenship> GetNCService() {
		
		return ncdaoimpl.getList();
	}
	
	@RequestMapping(value = "/GetPatient", method = RequestMethod.GET)
	public String GetPatient() {

		return "Patient/AllPatient";
	}

	@RequestMapping(value = "/GetAllPatient", method = RequestMethod.GET)
	public @ResponseBody List<Patient> GetPatientService() {
		
		return patientdaoimpl.getList();
	}
	
	@RequestMapping(value = "/DeletePatient", method = RequestMethod.GET)
	public @ResponseBody Response DeletePatient(@RequestParam int id) {
		patientdaoimpl.deleteRow(id);
		return new Response();
	}

}
