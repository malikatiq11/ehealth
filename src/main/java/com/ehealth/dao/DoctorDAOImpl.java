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
import com.ehealth.model.MobPatient;
import com.ehealth.model.Patient;
import com.ehealth.model.Registration;
import com.ehealth.model.Staff;

public class DoctorDAOImpl  {

	@Autowired
	SessionFactory sessionFactory;


	@Transactional

	public int add(Doctor doctor) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.saveOrUpdate(doctor);
		tx.commit();
		Serializable id = session.getIdentifier(doctor);
		session.close();
		return (Integer) id;
		
	}
	
	public Doctor getRowById(int id) {
		Session session = sessionFactory.openSession();
		Doctor doctor = (Doctor) session.load(Doctor.class, id);
		//doctor.setBirthDate(doctor.getbirthDate().getDate());
		return doctor;
	}
	
	
	public int updateRow(Doctor doctor) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.clear();
		session.update(doctor);
		tx.commit();
		Serializable id = session.getIdentifier(doctor);
		session.close();
		return (Integer) id;
	}
	
	
	public List<Doctor> getList() {
		Session session = sessionFactory.openSession();
		@SuppressWarnings("unchecked")
		List<Doctor> employeeList = session.createQuery("from Doctor")
				.list();
		session.close();
		return employeeList;
	}
	

	public int deleteRow(int id) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		Doctor doctor = (Doctor) session.load(Doctor.class, id);
		session.delete(doctor);
		tx.commit();
		Serializable ids = session.getIdentifier(doctor);
		session.close();
		return (Integer) ids;
	}
	public List<Doctor> getDoctorByDepartment(int departId) {
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from Doctor where DepartmentId = :id");
		query.setParameter("id",departId);
		
		List<Doctor> list =  query.list();
		
		return list;
	}

	@SuppressWarnings("unchecked")
	public List<Doctor> Authentication(String username , String password) {
		Session session = sessionFactory.openSession();
	    return session.createQuery("from Doctor Where Email='"+username+"' and Password='"+password+"'").list();

	}
	@SuppressWarnings("unchecked")
	public List<Doctor> AuthenticationMobile(final String cnic, String Password) {
		Session session = sessionFactory.openSession();
	    return session.createQuery("from Doctor Where Cnic='"+cnic+"' and Password='"+Password+"'").list();

	}
	
	@SuppressWarnings("unchecked")
	public List<Doctor> CheckEmail(String username) {
		Session session = sessionFactory.openSession();
	    return session.createQuery("from Doctor Where Email='"+username+"'").list();

	}


}
