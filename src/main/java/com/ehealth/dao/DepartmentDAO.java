package com.ehealth.dao;

import java.util.List;

import com.ehealth.model.Department;

public interface DepartmentDAO {
	
	public int add(Department department);
	public Department getRowById(int id);
	public int updateRow(Department dept);
	public List<Department> getList();
	public int deleteRow(int id) ;

}
