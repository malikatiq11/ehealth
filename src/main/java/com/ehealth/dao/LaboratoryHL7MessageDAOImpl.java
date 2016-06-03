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
import com.ehealth.model.LaboratoryHL7Message;
import com.ehealth.model.RequestPanel;

public class LaboratoryHL7MessageDAOImpl {
	
	@Autowired
	SessionFactory sessionFactory;


	@Transactional

	public int add(LaboratoryHL7Message labs) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.saveOrUpdate(labs);
		tx.commit();
		Serializable id = session.getIdentifier(labs);
		session.close();
		return (Integer) id;
		
	}
	
	public LaboratoryHL7Message getRowById(int id) {
		Session session = sessionFactory.openSession();
		LaboratoryHL7Message labs = (LaboratoryHL7Message) session.load(LaboratoryHL7Message.class, id);
		//doctor.setBirthDate(doctor.getbirthDate().getDate());
		return labs;
	}
	
	

	
	public List<LaboratoryHL7Message> getList() {
		Session session = sessionFactory.openSession();
		@SuppressWarnings("unchecked")
		List<LaboratoryHL7Message> labs = session.createQuery("from LaboratoryHL7Message")
				.list();
		session.close();
		return labs;
	}
	
	@SuppressWarnings("unchecked")
	public List<LaboratoryHL7Message> GetLaboratoryMessage(final String cnic,String Name) {
		Session session = sessionFactory.openSession();
	    return session.createQuery("from LaboratoryHL7Message Where Cnic='"+cnic+"' and LaboratoryName='"+Name+"'").list();

	}



}
