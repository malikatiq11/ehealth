package com.ehealth.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ehealth.dao.DepartmentDAOImpl;
import com.ehealth.model.Department;
import com.ehealth.model.Response;
import com.ehealth.wrapper.DateWrapper;

@Controller
public class DepartmentController {
	@Autowired
	DepartmentDAOImpl dimpl;
	
	Response response;
	
	

	
	@RequestMapping(value = "/InsertDept", method = RequestMethod.GET)
	public String GetService() {

		return "Department/InsertDepartment";
	}

	@RequestMapping(value = "/PostDepartment", method = RequestMethod.POST)
	public @ResponseBody Response PostDepartmentService(@RequestBody Department dept) {
		List<Department> list=dimpl.CheckDepartmentName(dept.getdepartmentname());
		if(list.size()==0)
		{
			dimpl.add(dept);
			response = new Response();
			response.setStatus("10");
			response.setDescription("Data inserted on Department Table");
			return response;
		}
		else
		{
			response = new Response();
			response.setStatus("11");
			response.setDescription("Data not Inserted");
			return response;
		}
		
		
	}

	@RequestMapping(value = "/EditDept", method = RequestMethod.GET)
	public String EditDepartment() {
		
		return "Department/EditDepartment";
	}
	
	@RequestMapping(value = "/GetDepartmentbyId", method = RequestMethod.GET)
	public @ResponseBody  Department GetDepartmentbyId(@RequestParam int id) {
		
		Department dd=dimpl.getRowById(id);
		//List<Department> dept=new ArrayList<Department>();
		//dept.add(dimpl.getRowById(intid.getId()));
		//System.out.println( dept.get(0).getdepartmentname());
//		Response res=new Response();
		Department dept=new Department();
		dept.SetDepartmentId(dd.getdepartmentId());
		dept.setDepartmentName(dd.getdepartmentname());
		dept.setDepartmentDescription(dd.getdepartmentdescription());
		return dept;
		//return dimpl.getRowById(id);
	}

	@RequestMapping(value = "/UpdateDepartment", method = RequestMethod.POST)
	public @ResponseBody Response UpdateDepartmentService(@RequestBody Department dept) {
		List<Department> list=dimpl.CheckDepartmentName(dept.getdepartmentname());
		if(list.size()==0)
		{
			dimpl.updateRow(dept);
			response = new Response();
			response.setStatus("10");
			response.setDescription("Data inserted on Department Table");
			return response;
		}
		else
		{
			response = new Response();
			response.setStatus("11");
			response.setDescription("Data not Inserted");
			return response;
		}
	}

	@RequestMapping(value = "/GetDepartments", method = RequestMethod.GET)
	public String GetDepartment() {

		return "Department/AllDepartment";
	}

	@RequestMapping(value = "/GetAllDepartment", method = RequestMethod.GET)
	public @ResponseBody List<Department> GetDepartmentService() {
		
		return dimpl.getList();
	}

	@RequestMapping(value = "/DeleteDept", method = RequestMethod.GET)
	public @ResponseBody Response DeleteDepartment(@RequestParam int id) {
		dimpl.deleteRow(id);
		Response res=new Response();
		return res;
	}
	@RequestMapping(value = "/getdata", method = RequestMethod.POST)
	public @ResponseBody List<Department> mobile(@RequestParam("request_type") String request_type) {
			System.out.println(request_type);
		// ParseObservationMessage observation=new ParseObservationMessage();
		// observation.ParserMessage("hi there");

		return dimpl.getList();
	}

}
