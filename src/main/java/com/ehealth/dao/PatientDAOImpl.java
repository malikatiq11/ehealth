package com.ehealth.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.ehealth.model.Patient;

public class PatientDAOImpl  {

	@Autowired
	SessionFactory sessionFactory;


	@Transactional

	public int add(Patient patient) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.saveOrUpdate(patient);
		tx.commit();
		Serializable id = session.getIdentifier(patient);
		session.close();
		return (Integer) id;
		
	}
	
	public Patient getRowById(int id) {
		Session session = sessionFactory.openSession();
		Patient patient = (Patient) session.load(Patient.class, id);
		//doctor.setBirthDate(doctor.getbirthDate().getDate());
		return patient;
	}
	public Patient getRowByCnic(String cnic) {
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from Patient where Cnic = :cnic ");
		query.setParameter("cnic",cnic);
		List list =  query.list();
		if(list.size()!=0)
		{
			return ( (Patient) list.get(0));
		}
		return null;
	}
	public Patient getRowByIdCnic(int id,String cnic) {
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from Patient where Cnic = :cnic and PatientId=:id ");
		query.setParameter("cnic",cnic);
		query.setParameter("id",id);
		List list =  query.list();
		if(list.size()!=0)
		{
			Patient patient=(Patient) list.get(0);
			return patient;
		}
		else
		{
			return null;
		}
	}
	public int updateRow(Patient patient) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.clear();
		session.update(patient);
		tx.commit();
		Serializable id = session.getIdentifier(patient);
		session.close();
		return (Integer) id;
	}
	
	
	public List<Patient> getList() {
		Session session = sessionFactory.openSession();
		@SuppressWarnings("unchecked")
		List<Patient> employeeList = session.createQuery("from Patient")
				.list();
		session.close();
		return employeeList;
	}
	

	public int deleteRow(int id) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		Patient patient = (Patient) session.load(Patient.class, id);
		session.delete(patient);
		tx.commit();
		Serializable ids = session.getIdentifier(patient);
		session.close();
		return (Integer) ids;
	}


}
