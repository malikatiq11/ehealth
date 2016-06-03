package com.ehealth.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.ehealth.model.Religion;

public class ReligionDAOImpl {
	
	@Autowired
	SessionFactory sessionFactory;
	
	public List<Religion> getList() {
		Session session = sessionFactory.openSession();
		@SuppressWarnings("unchecked")
		List<Religion> religion = session.createCriteria(Religion.class).list();
		
		session.close();
		return religion;
	}

}
