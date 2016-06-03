package com.ehealth.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.ehealth.model.Doctor;
import com.ehealth.model.PatientVisit;
import com.ehealth.model.Treatment;
import com.ehealth.model.Treatment;

public class TreatmentDAOImpl {
	@Autowired
	SessionFactory sessionFactory;


	@Transactional

	public int add(Treatment treatment) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.saveOrUpdate(treatment);
		tx.commit();
		Serializable id = session.getIdentifier(treatment);
		session.close();
		return (Integer) id;
		
	}
	
	public Treatment getRowById(int id) {
		Session session = sessionFactory.openSession();
		Treatment treatment = (Treatment) session.load(Treatment.class, id);
		//doctor.setBirthDate(doctor.getbirthDate().getDate());
		return treatment;
	}
	
	
	public int updateRow(Treatment treatment) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.clear();
		session.update(treatment);
		tx.commit();
		Serializable id = session.getIdentifier(treatment);
		session.close();
		return (Integer) id;
	}
	
	
	public List<Treatment> getList() {
		Session session = sessionFactory.openSession();
		@SuppressWarnings("unchecked")
		List<Treatment> treatment = session.createQuery("from Treatment")
				.list();
		session.close();
		return treatment;
	}
	

	public int deleteRow(int id) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		Treatment treatment = (Treatment) session.load(Treatment.class, id);
		session.delete(treatment);
		tx.commit();
		Serializable ids = session.getIdentifier(treatment);
		session.close();
		return (Integer) ids;
	}
	public List<Treatment>getTreatmentByVisitid(int id) {
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from Treatment where VId = :id ");
		query.setParameter("id",id);
		List<Treatment> list =  query.list();
		
		return list;
	}

}
