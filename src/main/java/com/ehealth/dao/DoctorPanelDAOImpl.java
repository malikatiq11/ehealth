package com.ehealth.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.ehealth.model.Department;
import com.ehealth.model.Doctor;
import com.ehealth.model.DoctorPanel;
import com.ehealth.model.Patient;
import com.ehealth.model.RequestPanel;

public class DoctorPanelDAOImpl {
	
	@Autowired
	SessionFactory sessionFactory;

	@Transactional

	public int add(DoctorPanel request) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.saveOrUpdate(request);
		tx.commit();
		Serializable id = session.getIdentifier(request);
		session.close();
		return (Integer) id;
		
	}
	@SuppressWarnings("unchecked")
	public List<DoctorPanel> GetRequestbyDocId(final int docid,final int id) {
		Session session = sessionFactory.openSession();
	    return session.createQuery("from DoctorPanel Where DocId="+docid+" and DoctorPanelId="+id).list();

	}
	public int deleteRow(int id) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		DoctorPanel panel = (DoctorPanel) session.load(DoctorPanel.class, id);
		session.delete(panel);
		tx.commit();
		Serializable ids = session.getIdentifier(panel);
		session.close();
		return (Integer) ids;
	}
	public List<DoctorPanel> getList() {
		Session session = sessionFactory.openSession();
		@SuppressWarnings("unchecked")
		List<DoctorPanel> employeeList = session.createCriteria(DoctorPanel.class).list();
				
		session.close();
		return employeeList;
	}

	public int updateRow(DoctorPanel doctor) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.clear();
		session.update(doctor);
		tx.commit();
		Serializable id = session.getIdentifier(doctor);
		session.close();
		return (Integer) id;
	}
}
