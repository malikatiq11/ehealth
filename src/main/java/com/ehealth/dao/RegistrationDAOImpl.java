package com.ehealth.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.ehealth.model.DoctorPanel;
import com.ehealth.model.Registration;

public class RegistrationDAOImpl {
	@Autowired
	SessionFactory sessionFactory;


	@Transactional

	public int add(Registration registration) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.saveOrUpdate(registration);
		tx.commit();
		Serializable id = session.getIdentifier(registration);
		session.close();
		return (Integer) id;
		
	}
	@SuppressWarnings("unchecked")
	public List<Registration> Authentication(String username , String password) {
		Session session = sessionFactory.openSession();
	    return session.createQuery("from Registration Where UserName='"+username+"' and Password='"+password+"'").list();

	}

}
