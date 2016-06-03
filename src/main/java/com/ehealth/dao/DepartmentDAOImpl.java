package com.ehealth.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.ehealth.model.Department;
import com.ehealth.model.MobPatient;


public class DepartmentDAOImpl implements DepartmentDAO {

	@Autowired
	SessionFactory sessionFactory;

	@Transactional

	public int add(Department department) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.saveOrUpdate(department);
		tx.commit();
		Serializable id = session.getIdentifier(department);
		session.close();
		return (Integer) id;
		
	}
	
	public Department getRowById(int id) {
		Session session = sessionFactory.openSession();
		Department dept = (Department) session.load(Department.class, id);
		return dept;
	}
	
	
	public int updateRow(Department dept) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.saveOrUpdate(dept);
		tx.commit();
		Serializable id = session.getIdentifier(dept);
		session.close();
		return (Integer) id;
	}
	
	
	public List<Department> getList() {
		Session session = sessionFactory.openSession();
		@SuppressWarnings("unchecked")
		List<Department> employeeList = session.createCriteria(Department.class).list();
				
		session.close();
		return employeeList;
	}
	

	public int deleteRow(int id) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		Department dept = (Department) session.load(Department.class, id);
		session.delete(dept);
		tx.commit();
		Serializable ids = session.getIdentifier(dept);
		session.close();
		return (Integer) ids;
	}

	@SuppressWarnings("unchecked")
	public List<Department> CheckDepartmentName(final String name) {
		Session session = sessionFactory.openSession();
	    return session.createQuery("from Department Where DepartmentName='"+name+"'").list();

	}

}
