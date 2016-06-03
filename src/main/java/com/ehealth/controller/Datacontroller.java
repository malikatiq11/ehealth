package com.ehealth.controller;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.codec.binary.Base64;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.ehealth.dao.DepartmentDAOImpl;
import com.ehealth.dao.DoctorDAOImpl;
import com.ehealth.dao.StaffDAOImpl;
import com.ehealth.model.Department;
import com.ehealth.model.Doctor;
import com.ehealth.model.ParamId;
import com.ehealth.model.Response;
import com.ehealth.model.Staff;

@Controller
public class Datacontroller {
	@Autowired
	DepartmentDAOImpl dimpl;
	@Autowired
	DoctorDAOImpl doimpl;
	
	@Autowired
	StaffDAOImpl staffdaoimpl;
	Response response;
	
	@Autowired
	SessionFactory sessionFactory;
	
	
	// Data Control for Department

	
	// Department Control End Here

	// Doctor Control Start here

	
	@RequestMapping(value = "/InsertP", method = RequestMethod.GET)
	public ModelAndView InsertPicture() {

		return new ModelAndView("InsertPic");
	}
	@RequestMapping(value = "/check", method = RequestMethod.GET)
	public ModelAndView Insert() {

		return new ModelAndView("ng-repeat_selected");
	}
	

	@RequestMapping(value = "/continueFileUpload", method = RequestMethod.POST)
	public @ResponseBody Response continueFileUpload(HttpServletRequest request, HttpServletResponse response) {
		MultipartHttpServletRequest mRequest;
		byte [] atiq=null;
		Response res=new Response();
		try {
			mRequest = (MultipartHttpServletRequest) request;
			mRequest.getParameterMap();

			Iterator<String> itr = mRequest.getFileNames();
			while (itr.hasNext()) {
				MultipartFile mFile = mRequest.getFile(itr.next());
				atiq=mFile.getBytes();
				res.setContent(atiq);
				res.setStatus(mFile.getOriginalFilename());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return res;
	}
	
	//staff controller
	
	
}
