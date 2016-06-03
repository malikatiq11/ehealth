package com.ehealth.hl7;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import com.ehealth.model.Patient;

import ca.uhn.hl7v2.DefaultHapiContext;
import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.HapiContext;
import ca.uhn.hl7v2.model.DataTypeException;
import ca.uhn.hl7v2.model.v24.message.ORU_R01;
import ca.uhn.hl7v2.model.v24.segment.MSH;
import ca.uhn.hl7v2.model.v24.segment.OBR;
import ca.uhn.hl7v2.model.v24.segment.PID;
import ca.uhn.hl7v2.parser.Parser;

public class CreateLaboratoryMessage {
	
	public String CreateLabMessage(Patient patient,String TestName,String Destination)
	{
		String	encodedMessage = null;
		ORU_R01 oru=new ORU_R01();
		try {
			oru.initQuickstart("ORU","R01","P");
		} catch (HL7Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		PID pid = oru.getPATIENT_RESULT().getPATIENT().getPID();
		OBR obr = oru.getPATIENT_RESULT().getORDER_OBSERVATION().getOBR();
		
		// Populate the MSH Segment
				MSH mshSegment = oru.getMSH();
				try {
					mshSegment.getFieldSeparator().setValue("|");
					mshSegment.getEncodingCharacters().setValue("^~\\&");
					mshSegment.getSendingApplication().getNamespaceID().setValue("HMIS");
					mshSegment.getReceivingApplication().getNamespaceID().setValue(Destination);
					mshSegment.getSequenceNumber().setValue("123");
				} catch (DataTypeException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
				
				//PID pid = oru.getPATIENT_RESULT().getPATIENT().getPID();
				try {
				    pid.getPatientID().getID().setValue(String.valueOf(patient.getcnic()));

				    pid.getSetIDPID().setValue(String.valueOf(patient.getpatientId()));
					pid.getPatientName(0).getGivenName().setValue(patient.getpatientName());
					pid.getPatientName(0).getFamilyName().getSurname().setValue(patient.getfamilyName());
					pid.getMotherSMaidenName(0).parse(patient.getmothersMaidenName());
					
					//dateformat 
					DateFormat dateFormat = new SimpleDateFormat("yyyy");
					String DateofBirth=dateFormat.format(patient.getdOB());
					dateFormat = new SimpleDateFormat("MM");
					DateofBirth=DateofBirth+dateFormat.format(patient.getdOB());
					dateFormat = new SimpleDateFormat("dd");
					DateofBirth=DateofBirth+dateFormat.format(patient.getdOB());
					//end here
					
					pid.getDateTimeOfBirth().parse(DateofBirth);
					pid.getAdministrativeSex().setValue(patient.getsex());
					pid.getPatientAddress(0).getStreetAddress().parse(patient.getstreet());
					pid.getPatientAddress(0).getStreetAddress().getStreetName().setValue("streeet 1");
					pid.getPatientAddress(0).getOtherDesignation().parse(patient.getdesignation());
					pid.getPatientAddress(0).getCity().setValue(patient.getcity().getcityName());
					pid.getPatientAddress(0).getStateOrProvince().setValue(patient.getstate().getstateName());
					pid.getPatientAddress(0).getCountry().setValue(patient.getcountry().getcountryName());
					pid.getPhoneNumberHome(0).getPhoneNumber().setValue(String.valueOf(patient.getphoneNumberHome()));
					pid.getPatientAddress(0).getZipOrPostalCode().setValue(String.valueOf(patient.getcity().getZipCode()));
					pid.getCountyCode().setValue(String.valueOf(patient.getcountry().getcountryCode()));
					pid.getPrimaryLanguage().parse(patient.getlanguage().getlanguageName());
					pid.getMaritalStatus().parse(patient.getmaritalStatus());
					pid.getReligion().parse(patient.getreligion().getreligionName());
					
					//BloodTest name
					obr.getUniversalServiceIdentifier().parse(TestName);
					
					HapiContext context = new DefaultHapiContext();
					Parser parser = context.getPipeParser();
					 encodedMessage = parser.encode(oru);
					System.out.println("Printing ER7 Encoded Message:");
					System.out.println(encodedMessage);
					
					
				} catch (DataTypeException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				catch (HL7Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
		

		return encodedMessage;
				
	}
	

}
