package com.ehealth.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

import com.ehealth.model.State;

public class StateDAOImpl {
	
	@Autowired
	SessionFactory sessionFactory;
	
	public List<State> getList() {
		Session session = sessionFactory.openSession();
		@SuppressWarnings("unchecked")
		List<State> state = session.createCriteria(State.class).list();
		
		session.close();
		return state;
	}
	@SuppressWarnings("unchecked")
	public List<State> findStateBycountryid(final int id) {
		Session session = sessionFactory.openSession();
	   // Criteria c = session.createCriteria(State.class).add(Restrictions.eq("CountryId", id));
	    //return c.list();
	    return session.createQuery("from State Where CountryId="+id).list();
//		Session session = sessionFactory.openSession();
//		@SuppressWarnings("unchecked")
//		List<State> state = session.createCriteria(State.class).list();
//		
//		session.close();
//		return state;
	}

}
