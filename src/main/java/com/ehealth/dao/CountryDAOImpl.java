package com.ehealth.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.ehealth.model.Country;

public class CountryDAOImpl {
	
	@Autowired
	SessionFactory sessionFactory;
	
	public List<Country> getList() {
		Session session = sessionFactory.openSession();
		@SuppressWarnings("unchecked")
		List<Country> country = session.createCriteria(Country.class).list();
				
		session.close();
		return country;
	}

}
