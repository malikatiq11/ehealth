package com.ehealth.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.ehealth.model.City;
import com.ehealth.model.State;

public class CityDAOImpl {
	@Autowired
	SessionFactory sessionFactory;
	
	public List<City> getList() {
		Session session = sessionFactory.openSession();
		@SuppressWarnings("unchecked")
		List<City> city = session.createCriteria(State.class).list();
		
		session.close();
		return city;
	}
	@SuppressWarnings("unchecked")
	public List<City> findcityBystateid(final int id) {
		Session session = sessionFactory.openSession();
	    return session.createQuery("from City Where StateId="+id).list();

	}


}
