package com.ehealth.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.ehealth.model.Roles;
import com.ehealth.model.State;

public class RolesDAOImpl {
	@Autowired
	SessionFactory sessionFactory;
	
	public List<Roles> getList() {
		Session session = sessionFactory.openSession();
		@SuppressWarnings("unchecked")
		List<Roles> roles = session.createCriteria(Roles.class).list();
		
		session.close();
		return roles;
	}
	


}
