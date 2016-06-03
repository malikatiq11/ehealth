package com.ehealth.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ehealth.dao.PatientDAOImpl;
import com.ehealth.hl7.CreateLaboratoryMessage;
import com.ehealth.model.Patient;

import ca.uhn.hl7v2.DefaultHapiContext;
import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.HapiContext;
import ca.uhn.hl7v2.model.DataTypeException;
import ca.uhn.hl7v2.model.v24.message.ADT_A01;
import ca.uhn.hl7v2.model.v24.segment.MSH;
import ca.uhn.hl7v2.model.v24.segment.PID;
import ca.uhn.hl7v2.parser.Parser;


@Controller
public class MainController {
	@Autowired
	PatientDAOImpl patientdao;
	
	@RequestMapping(value = "/Hl7", method = RequestMethod.GET)
	public  String hl7() {
		return "Treatment/showhl7";
	}
	
	@RequestMapping(value = "/Hl7message", method = RequestMethod.GET)
	public @ResponseBody Map<String,String> ShowHl7() {
		Map<String,String> model=new HashMap<String,String>();
		
		ADT_A01 adt = new ADT_A01();
		try {
			adt.initQuickstart("ADT", "A01", "P");
		} catch (HL7Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("come there");
		// Populate the MSH Segment
		MSH mshSegment = adt.getMSH();
		try {
			mshSegment.getSendingApplication().getNamespaceID().setValue("HMIS");
		} catch (DataTypeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			mshSegment.getReceivingApplication().getNamespaceID().setValue("LIS");
		} catch (DataTypeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			mshSegment.getSequenceNumber().setValue("123");
		} catch (DataTypeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Populate the PID Segment
		PID pid = adt.getPID();
		try {
			pid.getPatientName(0).getFamilyName().getSurname().setValue("father");
	
		pid.getPatientName(0).getGivenName().setValue("own name");
		pid.getPatientIdentifierList(0).getID().setValue("uski id");
		pid.getAdministrativeSex().setValue("Male");
		pid.getPatientAddress(0).getStreetAddress().getStreetName().setValue("street 2");
		pid.getPatientAddress(0).getCountry().setValue("Pakistan");
		pid.getPatientAddress(0).getCity().setValue("Rawalpindi");
		pid.getPatientAddress(0).getStateOrProvince().setValue("Punjab");
		pid.getPatientAddress(0).getZipOrPostalCode().setValue("46000");
		pid.getCountyCode().setValue("+92");
		pid.getPhoneNumberHome(0).getPhoneNumber().setValue("515191013");
		pid.getPrimaryLanguage().getText().setValue("English");
		pid.getMaritalStatus().getText().setValue("Single");
		pid.getReligion().getText().setValue("Islam");
		
		} catch (DataTypeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/*
		 * In a real situation, of course, many more segments and fields would
		 * be populated
		 */

		// Now, let's encode the message and look at the output
		HapiContext context = new DefaultHapiContext();
		Parser parser = context.getPipeParser();
		String encodedMessage = null;
		try {
			encodedMessage = parser.encode(adt);
		} catch (HL7Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//System.out.println("Printing ER7 Encoded Message:");
		//System.out.println(encodedMessage);
		model.put("ERMessage", encodedMessage);

		/*
		 * Prints:
		 * 
		 * MSH|^~\&|TestSendingSystem||||200701011539||ADT^A01^ADT A01||||123
		 * PID|||123456||Doe^John
		 */

		// Next, let's use the XML parser to encode as XML
		parser = context.getXMLParser();
		try {
			encodedMessage = parser.encode(adt);
		} catch (HL7Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//System.out.println("Printing XML Encoded Message:");
		//System.out.println(encodedMessage);
		model.put("XMLMessage", encodedMessage);
		
		return model;
	}
	
	@RequestMapping(value = "/HL7Special", method = RequestMethod.GET)
	public String  Special() {
		Patient pt=new Patient();
		Patient pp=patientdao.getRowById(6);
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
		
	CreateLaboratoryMessage msg=new CreateLaboratoryMessage();
	String result=msg.CreateLabMessage(pt, "urnise","LIS");
		
		return "Admin/index";
	}
}
