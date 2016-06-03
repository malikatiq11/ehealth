package com.ehealth.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.ehealth.model.City;
import com.ehealth.model.Doctor;
import com.ehealth.model.Patient;
import com.ehealth.model.PatientVisit;

public class PatientVisitDAOImpl {
	@Autowired
	SessionFactory sessionFactory;


	@Transactional

	public int add(PatientVisit patientvisit) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.saveOrUpdate(patientvisit);
		tx.commit();
		Serializable id = session.getIdentifier(patientvisit);
		session.close();
		return (Integer) id;
		
	}
	
	public PatientVisit getRowById(int id) {
		Session session = sessionFactory.openSession();
		PatientVisit patientvisit = (PatientVisit) session.load(PatientVisit.class, id);
		//doctor.setBirthDate(doctor.getbirthDate().getDate());
		return patientvisit;
	}
	
	
	public int updateRow(PatientVisit patientvisit) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.clear();
		session.update(patientvisit);
		tx.commit();
		Serializable id = session.getIdentifier(patientvisit);
		session.close();
		return (Integer) id;
	}
	
	
	public List<PatientVisit> getList() {
		Session session = sessionFactory.openSession();
		@SuppressWarnings("unchecked")
		List<PatientVisit> patientvisit = session.createQuery("from PatientVisit")
				.list();
		session.close();
		return patientvisit;
	}
	

	public int deleteRow(int id) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		PatientVisit patientvisit = (PatientVisit) session.load(PatientVisit.class, id);
		session.delete(patientvisit);
		tx.commit();
		Serializable ids = session.getIdentifier(patientvisit);
		session.close();
		return (Integer) ids;
	}
	//special filtring data
	
	public List<PatientVisit>getPatientVisitbyPatientId(int id) {
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from PatientVisit where PatientId = :id ");
		query.setParameter("id",id);
		List<PatientVisit> list =  query.list();
		
		return list;
	}
	
	public List<PatientVisit> ByDepartmentId(int id) {
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from PatientVisit where DepartmentId = :id ");
		query.setParameter("id",id);
		List<PatientVisit> list =  query.list();
		
		return list;
	}
	
	public List<PatientVisit> ByDocId(int id) {
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from PatientVisit where DoctorId = :id ");
		query.setParameter("id",id);
		List<PatientVisit> list =  query.list();
		
		return list;
	}
	
	public List<PatientVisit> ByDocDepartmentId(int deptid,int docid) {
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from PatientVisit where DoctorId = :docid and DepartmentId=:deptid");
		query.setParameter("docid",docid);
		query.setParameter("deptid",deptid);
		List<PatientVisit> list =  query.list();
		
		return list;
	}
	
	


}
