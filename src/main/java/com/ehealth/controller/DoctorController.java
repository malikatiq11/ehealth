package com.ehealth.controller;

import java.io.UnsupportedEncodingException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.ehealth.dao.DoctorDAOImpl;
import com.ehealth.dao.PatientDAOImpl;
import com.ehealth.model.Department;
import com.ehealth.model.Doctor;
import com.ehealth.model.Response;


@Controller
public class DoctorController {
	@Autowired
	DoctorDAOImpl doimpl;
	
	
	Response response;
	
	@RequestMapping(value = "/InsertDoc", method = RequestMethod.GET)
	public String InsertDoctor() {
		return "Doctor/InsertDoctor";
	}
	@RequestMapping(value = "/GetProfile", method = RequestMethod.GET)
	public String GetProfile() {
		return "Doctor/Profile";
	}

	@RequestMapping(value = "/PostDoctor", method = RequestMethod.POST)
	public @ResponseBody Response PostDoctorService(@RequestBody Doctor doctor) {
		List<Doctor> doc=doimpl.CheckEmail(doctor.getemail());
		if(doc.size()==0)
		{
		
			doimpl.add(doctor);
			response = new Response();
			response.setStatus("10");
			response.setDescription("Data inserted on Doctor Table");
			return response;
		}
		else
		{
			response = new Response();
			response.setStatus("11");
			response.setDescription("Data not inserted");
			return response;
		}
		
		
	}

	@RequestMapping(value = "/GetDoctor", method = RequestMethod.GET)
	public String GetDoctor() {

		return "Doctor/AllDoctor";
	}

	@RequestMapping(value = "/GetAllDoctor", method = RequestMethod.GET)
	public @ResponseBody List<Doctor> GetDoctorService() {
		List<Doctor> list=doimpl.getList();
		
			System.out.print(list.get(0).getcontent());
		
		return doimpl.getList();
	}

	@RequestMapping(value = "/EditDoc", method = RequestMethod.GET)
	public String EditDoctor() {
		
		return "Doctor/EditDoctor";
	}
	@RequestMapping(value = "/GetDoctorbyId", method = RequestMethod.GET)
	public @ResponseBody  Map<String, Object> GetDepartmentbyId(@RequestParam int id) {
		Doctor doc=new Doctor();
		Doctor dd = doimpl.getRowById(id);
		doc.setBirthDate(dd.getbirthDate());
		doc.setContent(dd.getcontent());
		doc.setDegree(dd.getdegree());
		doc.setCnic(dd.getCnic());
		doc.setDepartment(dd.getDepartment());
		doc.setEmail(dd.getemail());
		doc.setHomeAddress(dd.gethomeAddress());
		doc.setId(dd.getid());
		doc.setName(dd.getname());
		doc.setOfficeAddress(dd.getofficeAddress());
		doc.setSex(dd.getsex());
		doc.setSpecialization(dd.getspecialization());
		doc.setPassword(dd.getPassword());
		
		Map<String, Object> model = new HashMap<String, Object>();
	
		model.put("DoctorData", doc);
		  byte[] encodeBase64 = Base64.encodeBase64(dd.getcontent());
	        String base64Encoded = null;
			try {
				base64Encoded = new String(encodeBase64, "UTF-8");
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		model.put("ImageData", base64Encoded);
		return model;
		//return dimpl.getRowById(id);
	}

	@RequestMapping(value = "/UpdateDoctor", method = RequestMethod.POST)
	public @ResponseBody Response UpdateDoctorService(@RequestBody Doctor doctor) {
		List<Doctor> doc=doimpl.CheckEmail(doctor.getemail());
		if(doc.size()==0)
		{
		
			doimpl.updateRow(doctor);
			response = new Response();
			response.setStatus("10");
			response.setDescription("Data inserted on Doctor Table");
			return response;
		}
		else
		{
			response = new Response();
			response.setStatus("11");
			response.setDescription("Data not inserted");
			return response;
		}
	}

	@RequestMapping(value = "/DeleteDoc", method = RequestMethod.GET)
	public @ResponseBody Response DeleteDoctor(@RequestParam int id) {
		doimpl.deleteRow(id);
		return new Response();
	}
	

}
