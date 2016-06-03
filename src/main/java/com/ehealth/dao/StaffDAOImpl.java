package com.ehealth.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.ehealth.model.Admin;
import com.ehealth.model.Doctor;
import com.ehealth.model.RquestPatientVisit;
import com.ehealth.model.Staff;

public class StaffDAOImpl  {

	@Autowired
	SessionFactory sessionFactory;


	@Transactional

	public int add(Staff staff) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.saveOrUpdate(staff);
		tx.commit();
		Serializable id = session.getIdentifier(staff);
		session.close();
		return (Integer) id;
		
	}
	
	public Staff getRowById(int id) {
		Session session = sessionFactory.openSession();
		Staff staff = (Staff) session.load(Staff.class, id);
		return staff;
	}
	
	
	public int updateRow(Staff staff) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.saveOrUpdate(staff);
		tx.commit();
		Serializable id = session.getIdentifier(staff);
		session.close();
		return (Integer) id;
	}
	
	
	public List<Staff> getList() {
		Session session = sessionFactory.openSession();
		@SuppressWarnings("unchecked")
		List<Staff> employeeList = session.createQuery("from Staff")
				.list();
		session.close();
		return employeeList;
	}
	

	public int deleteRow(int id) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		Staff staff = (Staff) session.load(Staff.class, id);
		session.delete(staff);
		tx.commit();
		Serializable ids = session.getIdentifier(staff);
		session.close();
		return (Integer) ids;
	}

	@SuppressWarnings("unchecked")
	public List<Staff> GetStaffOnCnic(final String id) {
		Session session = sessionFactory.openSession();
	    return session.createQuery("from Staff Where Cnic="+id).list();

	}
	@SuppressWarnings("unchecked")
	public List<Staff> CheckEmail(String username) {
		Session session = sessionFactory.openSession();
	    return session.createQuery("from Staff Where Email='"+username+"'").list();

	}
	

}
