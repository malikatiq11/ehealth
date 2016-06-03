package com.ehealth.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.ehealth.model.Appointment;
import com.ehealth.model.DoctorPanel;

public class AppointmentDAOImpl {
	
	@Autowired
	SessionFactory sessionFactory;

	@Transactional

	public int add(Appointment appointment) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.saveOrUpdate(appointment);
		tx.commit();
		Serializable id = session.getIdentifier(appointment);
		session.close();
		return (Integer) id;
		
	}
	/*@SuppressWarnings("unchecked")
	public List<Admin> Authentication(String username , String password) {
		Session session = sessionFactory.openSession();
	    return session.createQuery("from Admin Where UserName='"+username+"' and Password='"+password+"'").list();

	}*/
	public List<Appointment> getList() {
		Session session = sessionFactory.openSession();
		@SuppressWarnings("unchecked")
		List<Appointment> employeeList = session.createCriteria(Appointment.class).list();
				
		session.close();
		return employeeList;
	}

	@SuppressWarnings("unchecked")
	public List<Appointment> GetAppointByDocid(int docid) {
		Session session = sessionFactory.openSession();
	    return session.createQuery("from Appointment Where DoctorId="+docid).list();

	}
}
