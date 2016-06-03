package com.ehealth.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.ehealth.model.DoctorsPa;
import com.ehealth.model.Staff;


public class DoctorsPaDAOImpl {
	@Autowired
	SessionFactory sessionFactory;


	@Transactional

	public int add(DoctorsPa dp) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.saveOrUpdate(dp);
		tx.commit();
		Serializable id = session.getIdentifier(dp);
		session.close();
		return (Integer) id;
		
	}
	@SuppressWarnings("unchecked")
	public List<DoctorsPa> GetDocId(final int id) {
		Session session = sessionFactory.openSession();
	    return session.createQuery("from DoctorsPa Where StaffId="+id).list();

	}
	

}
