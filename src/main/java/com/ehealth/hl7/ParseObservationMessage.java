package com.ehealth.hl7;

import java.util.Date;
import java.util.HashMap;

import com.ehealth.model.Patient;

import ca.uhn.hl7v2.DefaultHapiContext;
import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.HapiContext;
import ca.uhn.hl7v2.model.Message;
import ca.uhn.hl7v2.model.v24.datatype.FN;
import ca.uhn.hl7v2.model.v24.datatype.ID;
import ca.uhn.hl7v2.model.v24.datatype.IS;
import ca.uhn.hl7v2.model.v24.datatype.NM;
import ca.uhn.hl7v2.model.v24.datatype.SI;
import ca.uhn.hl7v2.model.v24.datatype.ST;
import ca.uhn.hl7v2.model.v24.datatype.TS;
import ca.uhn.hl7v2.model.v24.datatype.XPN;
import ca.uhn.hl7v2.model.v24.message.ORU_R01;
import ca.uhn.hl7v2.model.v24.segment.MSH;
import ca.uhn.hl7v2.model.v24.segment.OBR;
import ca.uhn.hl7v2.model.v24.segment.OBX;
import ca.uhn.hl7v2.model.v24.segment.PID;
import ca.uhn.hl7v2.parser.EncodingNotSupportedException;
import ca.uhn.hl7v2.parser.Parser;

public class ParseObservationMessage {

	public 	HashMap<String, Object> ParserMessage(String message) {
		String msg = "MSH|^~\\&|LIS||HMIS||20160505151030.466+0500||ORU^R01^ORU_R01|11201|P|2.4\r"
				+ "PID|1|123|||Father Name^Patient Name||19941012|M|||Street Number^Designation^City^State^Postal Code^Country\r"
				+ "OBR||||serum\r" + "OBX|1|NM|^Billirubintotal||145\r" + "OBX|2|NM|^ALTSGPT||23\r"
				+ "OBX|3|NM|^ASTSGOT||12\r" + "OBX|4|NM|^Alkalinephosphatase||12\r" + "OBX|5|NM|^Urea||56\r"
				+ "OBX|6|NM|^Creatinine||45\r" + "OBX|7|NM|^Uricacid||70\r" + "OBR||||serum\r"
				+ "OBX|1|NM|^Billirubintotal||145\r" + "OBX|2|NM|^ALTSGPT||23\r" + "OBX|3|NM|^ASTSGOT||12\r"
				+ "OBX|4|NM|^Alkalinephosphatase||12\r" + "OBX|5|NM|^Urea||56\r" + "OBX|6|NM|^Creatinine||45\r"
				+ "OBX|7|NM|^Uricacid||70\r" + "OBR||||serum\r" + "OBX|1|NM|^Billirubintotal||145\r"
				+ "OBX|2|NM|^ALTSGPT||23\r" + "OBX|3|NM|^ASTSGOT||12\r" + "OBX|4|NM|^Alkalinephosphatase||12\r"
				+ "OBX|5|NM|^Urea||56\r" + "OBX|6|NM|^Creatinine||45\r" + "OBX|7|NM|^Uricacid||70\r" + "OBR||||serum\r"
				+ "OBX|1|NM|^Billirubintotal||145\r" + "OBX|2|NM|^ALTSGPT||23\r" + "OBX|3|NM|^ASTSGOT||12\r"
				+ "OBX|4|NM|^Alkalinephosphatase||12\r" + "OBX|5|NM|^Urea||56\r" + "OBX|6|NM|^Creatinine||45\r"
				+ "OBX|7|NM|^Uricacid||70\r" + "OBR||||serum\r" + "OBX|1|NM|^Billirubintotal||145\r"
				+ "OBX|2|NM|^ALTSGPT||23\r" + "OBX|3|NM|^ASTSGOT||12\r" + "OBX|4|NM|^Alkalinephosphatase||12\r"
				+ "OBX|5|NM|^Urea||56\r" + "OBX|6|NM|^Creatinine||45\r" + "OBX|7|NM|^Uricacid||70\r" + "OBR||||serum\r"
				+ "OBX|1|NM|^Billirubintotal||145\r" + "OBX|2|NM|^ALTSGPT||23\r" + "OBX|3|NM|^ASTSGOT||12\r"
				+ "OBX|4|NM|^Alkalinephosphatase||12\r" + "OBX|5|NM|^Urea||56\r" + "OBX|6|NM|^Creatinine||45\r"
				+ "OBX|7|NM|^Uricacid||70\r" + "OBR||||serum\r" + "OBX|1|NM|^Billirubintotal||145\r"
				+ "OBX|2|NM|^ALTSGPT||23\r" + "OBX|3|NM|^ASTSGOT||12\r" + "OBX|4|NM|^Alkalinephosphatase||12\r"
				+ "OBX|5|NM|^Urea||56\r" + "OBX|6|NM|^Creatinine||45\r" + "OBX|7|NM|^Uricacid||70\r";

		HapiContext context = new DefaultHapiContext();

		Parser p = context.getGenericParser();

		Message hapiMsg = null;
		try {

			hapiMsg = p.parse(message);

		} catch (EncodingNotSupportedException e) {
			e.printStackTrace();
			
			
		} catch (HL7Exception e) {
			e.printStackTrace();
			
		}
	
		ORU_R01 oruMsg = (ORU_R01) hapiMsg;

		// Retrieve MSH Segment
		MSH msh = oruMsg.getMSH();
		String msgType = msh.getMessageType().getMessageType().getValue();
		String msgTrigger = msh.getMessageType().getTriggerEvent().getValue();

		Patient patient=new Patient();
		// Retrieve PID Segment
		PID pid = oruMsg.getPATIENT_RESULT().getPATIENT().getPID();
		
		SI setID = pid.getSetIDPID();
		patient.setPatientId(Integer.valueOf(String.valueOf(setID)));
		
		ST idNumber = pid.getPatientID().getID();
		patient.setCnic(String.valueOf(idNumber));
		
		System.out.println(idNumber);
		
		XPN[] name = pid.getPatientName();
		ST given_name = name[0].getGivenName();
		patient.setPatientName(String.valueOf(given_name));
		
		FN fn = name[0].getFamilyName();
		String family_name = fn.toString().substring(3, fn.toString().length() - 1);
		
		TS DOB = pid.getDateTimeOfBirth();
		String dob = DOB.toString().substring(3, DOB.toString().length() - 1);
		Date date=new Date();
		date.setYear(Integer.valueOf(dob.substring(0, 4)));
		date.setMonth(Integer.valueOf(dob.substring(4, 6)));
		date.setDate(Integer.valueOf(dob.substring(6, 8)));
		patient.setDOB(date);
		
		IS sex = pid.getAdministrativeSex();
		patient.setSex(String.valueOf(sex));
		
		ST street_name = pid.getPatientAddress(0).getStreetAddress().getStreetName();
		patient.setStreet(String.valueOf(street_name));
		ST street_address = pid.getPatientAddress(0).getStreetAddress().getStreetOrMailingAddress();
		ST city = pid.getPatientAddress(0).getCity();
		ST state = pid.getPatientAddress(0).getStateOrProvince();
		ID country = pid.getPatientAddress(0).getCountry();
		ST postal_code = pid.getPatientAddress(0).getZipOrPostalCode();
		ST designation = pid.getPatientAddress(0).getOtherDesignation();
		NM phone_number = pid.getPhoneNumberHome(0).getPhoneNumber();
		
		patient.setPhoneNumberHome(Long.parseLong(String.valueOf(phone_number)));
		
//		// Retrieve OBR Segment
//		OBR obr;
//		OBX obx;
//		String[][] obxId = new String[7][7];
//		String[][] obxValueType = new String[7][7];
//		String[][] obxIdentifier = new String[7][7];
//		String[][] obxValue = new String[7][7];
//		int obrCount = 0;
//		ST[] test_name = new ST[7];
//		int count = 0;
//		while (obrCount < 7) {
//			obr = oruMsg.getPATIENT_RESULT().getORDER_OBSERVATION(obrCount).getOBR();
//			test_name[obrCount] = obr.getUniversalServiceIdentifier().getIdentifier();
//
//			count = 0;
//
//			while (count < 7) {
//				obx = oruMsg.getPATIENT_RESULT().getORDER_OBSERVATION(obrCount).getOBSERVATION(count).getOBX();
//				obxId[obrCount][count] = obx.getSetIDOBX().getValue();
//				obxValueType[obrCount][count] = obx.getValueType().getValue();
//				obxIdentifier[obrCount][count] = obx.getObservationIdentifier().getText().getValue();
//				obxValue[obrCount][count] = obx.getObservationValue(0).getData().toString();
//				count++;
//			}
//			obrCount++;
//		}
//		
		// Retrieve OBR Segment
		int obrCount = 0;
		int count = 0;
		OBR obr;
		OBX obx;
		ST[] test_name = new ST[oruMsg.getPATIENT_RESULT().getORDER_OBSERVATIONReps()];
		String [] test_date = new String[oruMsg.getPATIENT_RESULT().getORDER_OBSERVATIONReps()];
		String[][] obxId;
		String[][] obxValueType;
		String[][] obxIdentifier;
		String[][] obxValue;
		obxId = new String[oruMsg.getPATIENT_RESULT().getORDER_OBSERVATIONReps()][];
		obxValueType = new String[oruMsg.getPATIENT_RESULT().getORDER_OBSERVATIONReps()][];
		obxIdentifier = new String[oruMsg.getPATIENT_RESULT().getORDER_OBSERVATIONReps()][];
		obxValue = new String[oruMsg.getPATIENT_RESULT().getORDER_OBSERVATIONReps()][];
		
		while(obrCount < oruMsg.getPATIENT_RESULT().getORDER_OBSERVATIONReps())
		{
			obr = oruMsg.getPATIENT_RESULT().getORDER_OBSERVATION(obrCount).getOBR();
			test_name[obrCount] = obr.getUniversalServiceIdentifier().getIdentifier();
			String td=obr.getObservationDateTime().toString().substring(3, obr.getObservationDateTime().toString().length()-1);
			String tdate=td.substring(0, 4)+"-"+td.substring(4,6)+"-"+td.substring(6,8)+" "+td.substring(8,10)+":"+td.substring(10,12);
			test_date[obrCount] = tdate;
			obxId[obrCount] = new String[oruMsg.getPATIENT_RESULT().getORDER_OBSERVATION(obrCount).getOBSERVATIONReps()];
			obxValueType[obrCount] = new String[oruMsg.getPATIENT_RESULT().getORDER_OBSERVATION(obrCount).getOBSERVATIONReps()];
			obxIdentifier[obrCount] = new String[oruMsg.getPATIENT_RESULT().getORDER_OBSERVATION(obrCount).getOBSERVATIONReps()];
			obxValue[obrCount] = new String[oruMsg.getPATIENT_RESULT().getORDER_OBSERVATION(obrCount).getOBSERVATIONReps()];
			count = 0;
			System.out.println(test_name[obrCount].toString());
			while (count < oruMsg.getPATIENT_RESULT().getORDER_OBSERVATION(obrCount).getOBSERVATIONReps())
			{
				obx = oruMsg.getPATIENT_RESULT().getORDER_OBSERVATION(obrCount).getOBSERVATION(count).getOBX();
				obxId[obrCount][count] = obx.getSetIDOBX().getValue();
				obxValueType[obrCount][count] = obx.getValueType().getValue();
				obxIdentifier[obrCount][count] = obx.getObservationIdentifier().getText().getValue();
				System.out.println( obx.getObservationValue(0).getData());
				obxValue[obrCount][count] = obx.getObservationValue(0).getData().toString();
				System.out.println(obxId[obrCount][count]+"  "+obxValueType[obrCount][count]+"  "+obxIdentifier[obrCount][count]+"  "+obxValue[obrCount][count]);
				count++;
			}
			obrCount++;
			
		}
		String [] TestName=new String[test_name.length];
		for(int i=0; i<test_name.length; i++)
		{
			TestName[i]=String.valueOf(test_name[i]);
		}
		
		HashMap<String, Object> map=new HashMap<String,Object>();
		map.put("Patient", patient);
		map.put("TestName", TestName);
		map.put("TestDate", test_date);
		map.put("OBXIdentifier", obxIdentifier);
		map.put("OBXValue", obxValue);
		return map;
	}

}
