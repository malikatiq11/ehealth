package com.ehealth.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.ehealth.model.Language;

public class LanguageDAOImpl {
	
	@Autowired
	SessionFactory sessionFactory;
	
	public List<Language> getList() {
		Session session = sessionFactory.openSession();
		@SuppressWarnings("unchecked")
		List<Language> lang = session.createCriteria(Language.class).list();
		
		session.close();
		return lang
				;
	}

}
