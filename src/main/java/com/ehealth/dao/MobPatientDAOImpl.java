package com.ehealth.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.ehealth.model.City;
import com.ehealth.model.Department;
import com.ehealth.model.MobPatient;
import com.ehealth.model.Patient;

public class MobPatientDAOImpl {

	@Autowired
	SessionFactory sessionFactory;

	@Transactional

	public int add(MobPatient mob) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.saveOrUpdate(mob);
		tx.commit();
		Serializable id = session.getIdentifier(mob);
		session.close();
		return (Integer) id;
		
	}

	@SuppressWarnings("unchecked")
	public List<MobPatient> Authentication(final String email, String Password) {
		Session session = sessionFactory.openSession();
	    return session.createQuery("from MobPatient Where Email='"+email+"' and Password='"+Password+"'").list();

	}
	public List<MobPatient> getList() {
		Session session = sessionFactory.openSession();
		@SuppressWarnings("unchecked")
		List<MobPatient> employeeList = session.createQuery("from MobPatient")
				.list();
		session.close();
		return employeeList;
	}
	@SuppressWarnings("unchecked")
	public List<MobPatient> CheckEmail(final String email) {
		Session session = sessionFactory.openSession();
	    return session.createQuery("from MobPatient Where Email='"+email+"'").list();

	}
}
