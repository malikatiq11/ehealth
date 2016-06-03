package com.ehealth.dao;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.ehealth.model.RquestPatientVisit;

public class RquestPatientVisitDAOImpl {
	@Autowired
	SessionFactory sessionFactory;

	@Transactional

	public int add(RquestPatientVisit request) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.saveOrUpdate(request);
		tx.commit();
		Serializable id = session.getIdentifier(request);
		session.close();
		return (Integer) id;
		
	}
	@SuppressWarnings("unchecked")
	public List<RquestPatientVisit> GetVisitidbyReqId(final int id) {
		Session session = sessionFactory.openSession();
	    return session.createQuery("from RquestPatientVisit Where ReqId="+id).list();

	}
	
	public List<RquestPatientVisit> getList() {
		Session session = sessionFactory.openSession();
		@SuppressWarnings("unchecked")
		List<RquestPatientVisit> employeeList = session.createQuery("from RquestPatientVisit")
				.list();
		session.close();
		return employeeList;
	}
	@SuppressWarnings("unchecked")
	public List<RquestPatientVisit> GetSearchByDate(String date) {
		Session session = sessionFactory.openSession();
		
	    return session.createQuery("from RquestPatientVisit Where VisitDate='"+date+"'").list();

	}
	
}
