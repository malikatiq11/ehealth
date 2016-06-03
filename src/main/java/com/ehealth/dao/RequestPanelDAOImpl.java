package com.ehealth.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.ehealth.model.PatientVisit;
import com.ehealth.model.RequestPanel;
import com.ehealth.model.Staff;

public class RequestPanelDAOImpl {
	
	@Autowired
	SessionFactory sessionFactory;

	@Transactional

	public int add(RequestPanel request) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.saveOrUpdate(request);
		tx.commit();
		Serializable id = session.getIdentifier(request);
		session.close();
		return (Integer) id;
		
	}
	public List<RequestPanel> getList() {
		Session session = sessionFactory.openSession();
		@SuppressWarnings("unchecked")
		List<RequestPanel> request = session.createQuery("from RequestPanel")
				.list();
		session.close();
		return request;
	}
	@SuppressWarnings("unchecked")
	public List<RequestPanel> GetPatientByDoctor(final int id) {
		Session session = sessionFactory.openSession();
	    return session.createQuery("from RequestPanel Where DocId="+id).list();

	}
	public RequestPanel getRowById(int id) {
		Session session = sessionFactory.openSession();
		RequestPanel requestpanel = (RequestPanel) session.load(RequestPanel.class, id);
		return requestpanel;
	}
	public int updateRow(RequestPanel panel) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.saveOrUpdate(panel);
		tx.commit();
		Serializable id = session.getIdentifier(panel);
		session.close();
		return (Integer) id;
	}
	

}
