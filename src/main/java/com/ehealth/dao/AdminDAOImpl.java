package com.ehealth.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.ehealth.model.Admin;

public class AdminDAOImpl {
	@Autowired
	SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	public List<Admin> Authentication(String username , String password) {
		Session session = sessionFactory.openSession();
	    return session.createQuery("from Admin Where UserName='"+username+"' and Password='"+password+"'").list();

	}

}
