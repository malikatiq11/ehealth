package com.ehealth.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.ehealth.model.NationalityCitizenship;
import com.ehealth.model.Religion;
import com.ehealth.model.State;

public class NCDAOImpl {

	@Autowired
	SessionFactory sessionFactory;
	
	public List<NationalityCitizenship> getList() {
		Session session = sessionFactory.openSession();
		@SuppressWarnings("unchecked")
		List<NationalityCitizenship> nc = session.createCriteria(NationalityCitizenship.class).list();
		
		session.close();
		return nc;
	}

}
