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

import com.ehealth.dao.DoctorsPaDAOImpl;
import com.ehealth.dao.RolesDAOImpl;
import com.ehealth.dao.StaffDAOImpl;
import com.ehealth.model.Doctor;
import com.ehealth.model.DoctorsPa;
import com.ehealth.model.Response;
import com.ehealth.model.Roles;
import com.ehealth.model.Staff;
import com.ehealth.wrapper.StaffDoctorsPaWrapper;

@Controller
public class StaffController {
	
	@Autowired
	StaffDAOImpl staffdaoimpl;
	
	@Autowired
	RolesDAOImpl rolesdaoimpl;
	
	@Autowired
	DoctorsPaDAOImpl doctorspaimpl;
	
	Response response;
	
	
	@RequestMapping(value = "/staff", method = RequestMethod.GET)
	public String AdminService() {

		return "Staff/index";
	}
	
	@RequestMapping(value="/InsertStaff",method=RequestMethod.GET)
	public String InsertSupportStaff()
	{
		return "Staff/InsertStaff";
	}
	
	@RequestMapping(value = "/PostStaff", method = RequestMethod.POST)
	public @ResponseBody Response PostStaffService(@RequestBody StaffDoctorsPaWrapper wrapper) {
//		System.out.println(doctor.getname());
//		System.out.println(doctor.getemail());
//		System.out.println(doctor.gethomeAddress());
//		System.out.println(doctor.getofficeAddress());
//		System.out.println(doctor.getsex());
//		System.out.println(doctor.getbirrthDate());
//		System.out.println(doctor.getdegree());
//		System.out.println(doctor.getspecialization());
//		System.out.println(doctor.getdepartmentId());
//		SupportStaff
		
		List<Staff> doc=staffdaoimpl.CheckEmail(wrapper.getStaff().getemail());
		if(doc.size()==0)
		{
		
			if(wrapper.getStaff().getRoles().getRoleId()==1)
			{
				int id =staffdaoimpl.add(wrapper.getStaff());
				DoctorsPa dp=wrapper.getDp();
				Staff staff=new Staff();
				staff.setId(id);
				dp.setStaff(staff);
				doctorspaimpl.add(dp);
				
			}
			else
			{
				staffdaoimpl.add(wrapper.getStaff());
			}
			
			response=new Response();
			response.setStatus("10");
			response.setDescription("Data inserted on Staff Table");
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
	@RequestMapping(value = "/GetStaff", method = RequestMethod.GET)
	public String GetStaff() {
		
		return "Staff/AllStaff";
	}
	@RequestMapping(value = "/GetAllStaff", method = RequestMethod.GET)
	public @ResponseBody List<Staff> GetStaffService() {
			List<Staff> list=staffdaoimpl.getList();
		
			
		
		return staffdaoimpl.getList();
	}
	
	@RequestMapping(value="/EditStaff",method=RequestMethod.GET)
	public String GetSupportStaff()
	{
		return "Staff/EditStaff";
	}
	@RequestMapping(value="/GetAllRoles",method=RequestMethod.GET)
	public @ResponseBody List<Roles> GetAllRoles()
	{
		return rolesdaoimpl.getList();
	}
	
	@RequestMapping(value = "/GetStaffbyId", method = RequestMethod.GET)
	public @ResponseBody  Map<String, Object> GetDepartmentbyId(@RequestParam int id) {
		Staff staff=new Staff();
		Staff dd = staffdaoimpl.getRowById(id);
		staff.setContent(dd.getcontent());
		staff.setDepartment(dd.getDepartment());
		staff.setEmail(dd.getemail());
		staff.setId(dd.getid());
		staff.setMobileNo(dd.getmobileNo());
		staff.setName(dd.getname());
		staff.setCnic(dd.getCnic());
		staff.setRoles(dd.getRoles());
		staff.setGender(dd.getGender());
		Map<String, Object> model = new HashMap<String, Object>();
	
		model.put("StaffData", staff);
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
	@RequestMapping(value = "/GetStaffByCnic", method = RequestMethod.GET)
	public @ResponseBody  Map<String, Object> GetStaffByCnic(@RequestParam String cnic) {
		Staff staff=new Staff();
		Staff dd = staffdaoimpl.GetStaffOnCnic(cnic).get(0);
		staff.setContent(dd.getcontent());
		staff.setDepartment(dd.getDepartment());
		staff.setEmail(dd.getemail());
		staff.setId(dd.getid());
		staff.setMobileNo(dd.getmobileNo());
		staff.setName(dd.getname());
		staff.setCnic(dd.getCnic());
		staff.setRoles(dd.getRoles());
		staff.setGender(dd.getGender());
		Map<String, Object> model = new HashMap<String, Object>();
	
		model.put("StaffData", staff);
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
	@RequestMapping(value = "/UpdateStaff", method = RequestMethod.POST)
	public @ResponseBody Response UpdateStaffService(@RequestBody Staff staff) {
		//System.out.println(staff.getdepartmentId());
		
		staffdaoimpl.updateRow(staff);
		response=new Response();
		response.setStatus("Data Updated");
		response.setDescription("Data inserted on Staff Table");
		return response;
	}
	@RequestMapping(value = "/DeleteStaff", method = RequestMethod.GET)
	public @ResponseBody  Response DeleteStaff(@RequestParam int id) {
		staffdaoimpl.deleteRow(id);
		Response res=new Response();
		return res;
	}
	

}
