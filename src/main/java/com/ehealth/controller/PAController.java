package com.ehealth.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
import com.ehealth.dao.DoctorPanelDAOImpl;
import com.ehealth.dao.DoctorsPaDAOImpl;
import com.ehealth.dao.PatientDAOImpl;
import com.ehealth.dao.PatientVisitDAOImpl;
import com.ehealth.dao.RegistrationDAOImpl;
import com.ehealth.dao.RequestPanelDAOImpl;
import com.ehealth.dao.RquestPatientVisitDAOImpl;
import com.ehealth.dao.TreatmentDAOImpl;
import com.ehealth.hl7.ParseObservationMessage;
import com.ehealth.model.Appointment;
import com.ehealth.model.Department;
import com.ehealth.model.Doctor;
import com.ehealth.model.DoctorPanel;
import com.ehealth.model.DoctorsPa;
import com.ehealth.model.Patient;
import com.ehealth.model.PatientVisit;
import com.ehealth.model.Registration;
import com.ehealth.model.RequestPanel;
import com.ehealth.model.Response;
import com.ehealth.model.RquestPatientVisit;
import com.ehealth.model.Treatment;
import com.ehealth.wrapper.DateWrapper;
import com.ehealth.wrapper.LoginWrapper;


@Controller
public class PAController {
	static  HashMap<String,Object> map;
	Response response;
	@Autowired
	RequestPanelDAOImpl requestpaneldaoimpl;
	
	@Autowired
	RequestPanelDAOImpl requestdaoimpl;
	
	@Autowired
	DoctorPanelDAOImpl doctorpaneldaoimpl;
	@Autowired
	RegistrationDAOImpl registrationdaoimpl;
	@Autowired
	DoctorsPaDAOImpl doctorspadaoimpl;
	
	@Autowired
	PatientDAOImpl patientdaoimpl;
	
	@Autowired
	TreatmentDAOImpl treatmentdaoimpl;
	
	@Autowired
	PatientVisitDAOImpl patientvisitdaoimpl;
	
	@Autowired
	RquestPatientVisitDAOImpl rvdaoimpl;
	@Autowired
	AppointmentDAOImpl appointmentdaoimpl;
	
	@Autowired
	DoctorDAOImpl doctordaoimpl;
	
	@RequestMapping(value = "/PA", method = RequestMethod.GET)
	public String AdminService() {

		return "PA/index";
	}
	@RequestMapping(value = "/PAlogin", method = RequestMethod.GET)
	public String PaLogin() {

		return "PA/login";
	}
	
	@RequestMapping(value = "/GetRequest", method = RequestMethod.GET)
	public String GetRequest() {

		return "PA/AllRequest";
	}
	@RequestMapping(value = "/GetPatientByDoctor", method = RequestMethod.GET)
	public @ResponseBody List<RequestPanel> GetPatientByDoctor(@RequestParam int id) {
		
		return requestpaneldaoimpl.GetPatientByDoctor(id);
	}
	@RequestMapping(value="/RequestDetails",method=RequestMethod.GET)
	public String RequestDetails()
	{
		return "PA/examinepatient";
	}
	@RequestMapping(value = "/GetRequestDetails", method = RequestMethod.GET)
	public @ResponseBody RequestPanel GetRequestDetails(@RequestParam int id) {
		RequestPanel panel=new RequestPanel();
		RequestPanel request=requestpaneldaoimpl.getRowById(id);
		panel.setReqId(request.getReqId());
		panel.setDepartment(request.getdepartment());
		panel.setDoctor(request.getDoctor());
		panel.setPatient(request.getpatient());
		panel.setStatus(request.getstatus());
		panel.setReferFrom(request.getReferFrom());
		panel.setVisitTime(request.getvisitTime());
		
		
		return panel;
	}
	@RequestMapping(value = "/UpdateVisitRequest", method = RequestMethod.POST)
	public @ResponseBody  Response PostVisitRequest(@RequestBody RequestPanel panel) {
		RequestPanel temp=requestpaneldaoimpl.getRowById(panel.getReqId());
		///DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		//Calendar cal = Calendar.getInstance();
		
		panel.setVisitTime(temp.getvisitTime());
		requestdaoimpl.add(panel);
		response=new Response();
		response.setStatus("done");
		return response;
	}
	@RequestMapping(value = "/PostDoctorPanel", method = RequestMethod.POST)
	public @ResponseBody  Response PostDocorPanel(@RequestBody DoctorPanel panel) {
		doctorpaneldaoimpl.add(panel);
		response=new Response();
		response.setStatus("done");
		return response;
	}
	@RequestMapping(value = "/PAAuthenticate", method = RequestMethod.POST)
	public @ResponseBody Map<String,Object> PAAuthenticate(@RequestBody LoginWrapper login) {
		

		List<Registration> list= registrationdaoimpl.Authentication(login.getUserName(), login.getPassword());
		Map<String,Object> model=new HashMap<String,Object>();

		if(list.size()!=0)
		{
		
				model.put("Status", 10);
				model.put("StaffInfo", list.get(0));
				List<DoctorsPa> doclist=doctorspadaoimpl.GetDocId(list.get(0).getStaff().getid());
				model.put("DoctorInfo", doclist.get(0));
			
		}
		else
		{
			model.put("Status", 11);
		}
		return model;
	}
	@RequestMapping(value = "/GetVisit", method = RequestMethod.GET)
	public String GetVisit() {

		return "PA/AllVisit";
	}
	@RequestMapping(value = "/GetAllVisit", method = RequestMethod.GET)
	public @ResponseBody HashMap<String, Object> GetAllVisit(@RequestParam String cnic) {
		HashMap<String, Object> model=new HashMap<String,Object>();
		
		String [] ClassText=new String[]{"Obstetric","Commercial Account","Emergency","InPatient","Not Applicabl","OutPatient","PreAdmit","RecurringPatient","UnKnown"};
		String [] ClassValue=new String[]{"B","C","E","I","N","O","P","R","U"};
	System.out.println(cnic);
	Patient patient=	patientdaoimpl.getRowByCnic(cnic);
	model.put("Patient", patient);
	List<PatientVisit> list=patientvisitdaoimpl.getPatientVisitbyPatientId(patient.getpatientId());
	for(int i=0; i<list.size(); i++)
	{
		PatientVisit visit=list.get(i);
		for(int j=0; j<ClassValue.length; j++)
		{
			if(ClassValue[j].contains(visit.getpatientClass()))
			{
				visit.setPatientClass(ClassText[j]);
			}
			list.remove(i);
			list.add(i, visit);
		}
	}
	model.put("Visit", list);
	return model;
	

		
	}
	@RequestMapping(value = "/ShowTreatment", method = RequestMethod.GET)
	public String ShowTreatment() {

		return "PA/ShowTreatment";
	}
	@RequestMapping(value = "/GetVisitTreatment", method = RequestMethod.GET)
	public @ResponseBody Treatment GetVisitTreament(@RequestParam int id) {

	String [] ClassText=new String[]{"Obstetric","Commercial Account","Emergency","InPatient","Not Applicabl","OutPatient","PreAdmit","RecurringPatient","UnKnown"};
	String [] ClassValue=new String[]{"B","C","E","I","N","O","P","R","U"};
	
	String [] AdmissionText=new String[]{"Accident","Elective","Emergency","Labor and Delivery","Newborn","Routine","Urgent"};
	String [] AdmissionValue=new String[]{"A","C","E","L","N","R","U"};
	
	Treatment treatment=treatmentdaoimpl.getTreatmentByVisitid(id).get(0);
	
	for(int j=0; j<ClassValue.length; j++)
	{
		if(ClassValue[j].contains(treatment.getPatientVisit().getpatientClass()))
		{
			treatment.patientVisit.setPatientClass(ClassText[j]);
		}

	}
	for(int j=0; j<AdmissionValue.length; j++)
	{
		
		if(AdmissionValue[j].contains(treatment.getPatientVisit().getadmissionType()))
		{
			treatment.patientVisit.setAdmissionType(AdmissionText[j]);
		}
		
	}
	return treatment;

		
	}
	
	@RequestMapping(value = "/LaboratoryObervation", method = RequestMethod.GET)
	public String LaboratoryObervation() {

		return "PA/laboratoryObservationDetails";
	}
	
	@RequestMapping(value = "/ParseObservationMessage", method = RequestMethod.POST)
	public @ResponseBody HashMap<String,Object> ParseObservationMessage(@RequestBody Response response) {
		//System.out.println(response.Description);
		ParseObservationMessage parse=new ParseObservationMessage();
		 map=parse.ParserMessage(response.getDescription());
		Patient p=patientdaoimpl.getRowByCnic(((Patient)map.get("Patient")).getcnic());
		if(p!=null)
		{
			map.put("Patient", p);
		}
		
		
		
		return map;
	}
	@RequestMapping(value = "/ObservationDetails", method = RequestMethod.GET)
	public String  ObservationDetails() {
		return "PA/ObservationDetails";
	}
	@RequestMapping(value = "/GetObservationDetails", method = RequestMethod.POST)
	public @ResponseBody HashMap<String,Object> GetObservationDetails(@RequestBody Response response) {
		int id=Integer.valueOf(response.getStatus());
		ParseObservationMessage parse=new ParseObservationMessage();
		HashMap<String,Object> object=parse.ParserMessage(response.getDescription());
		Patient p=patientdaoimpl.getRowByCnic(((Patient)object.get("Patient")).getcnic());
		if(p!=null)
		{
			object.put("Patient", p);
		}
		
		String [] Identifier=new String [7];
		String [] value=new String [7];
		
		String [] [] obxiden=(String[][]) object.get("OBXIdentifier");
		Identifier=obxiden[id];
		
		String [] [] obxvalue=(String[][]) object.get("OBXValue");
		value=obxvalue[id];
		
		String [] TM=(String[]) object.get("TestName");
		String testname=TM[id];
		
		object.put("TestName", testname);
		object.put("OBXIdentifier", Identifier);
		object.put("OBXValue", value);
		
		return object;
	}
	@RequestMapping(value = "/PreviousVisit", method = RequestMethod.GET)
	public String PreviousVisit() {
		return "PA/PreviousVisit";

	}
	
	@RequestMapping(value = "/GetPreviousVisit", method = RequestMethod.GET)
	public @ResponseBody List<RquestPatientVisit> GetPreviousVisit() {
		return rvdaoimpl.getList();

	}
	@RequestMapping(value = "/SearchByDate", method = RequestMethod.POST)
	public @ResponseBody List<RquestPatientVisit>  SearchByDate(@RequestBody DateWrapper wrapper ) {
		//wrapper.getDate().setDate(wrapper.getDate().getDate()+1);
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String result=dateFormat.format(wrapper.getDate());
		System.out.println(result);
		List<RquestPatientVisit> list=rvdaoimpl.getList();
		List<RquestPatientVisit> sendlist=new ArrayList<RquestPatientVisit>();
		for(int i=0; i<list.size(); i++)
		{
			if(dateFormat.format(wrapper.getDate()).equals(dateFormat.format(list.get(i).getVisitDate())))
			{
				sendlist.add(list.get(i));
			}
					
		}
		return  sendlist;
		}
	@RequestMapping(value = "/AddAppointment", method = RequestMethod.GET)
	public String AddAppointment() {
		return "PA/AddAppointment";

	}
	@RequestMapping(value = "/PostAppointment", method = RequestMethod.POST)
	public @ResponseBody Response PostAppointment(@RequestBody Appointment appointment) {
		System.out.println(appointment.getDoctor().getid());
		Doctor doc=doctordaoimpl.getRowById(appointment.getDoctor().getid());
		Department dd=new Department();
		dd.SetDepartmentId(doc.getDepartment().getdepartmentId());
		appointment.setDepartment(dd);
		List<Appointment> list=appointmentdaoimpl.GetAppointByDocid(appointment.getDoctor().getid());
		if(list.size()!=0)
		{
			appointment.setAppointmentId(list.get(0).getAppointmentId());
		}
		appointmentdaoimpl.add(appointment);
		return new Response("Done","done");

	}

}
