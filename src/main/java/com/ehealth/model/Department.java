package com.ehealth.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Department implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	public int DepartmentId;
	
	public String DepartmentName;
	public String DepartmentDescription;
	
//    @OneToMany(fetch=FetchType.LAZY, mappedBy = "department", cascade = CascadeType.ALL)
//    @JsonManagedReference
//    private Collection<Doctor> doctors = new ArrayList<Doctor>();
	
//	public Collection<Doctor> getDoctors() {
//		return doctors;
//	}
//
//	public void setDoctors(Set<Doctor> doctors) {
//		this.doctors = doctors;
//	}

	public void SetDepartmentId(int id)
	{
		DepartmentId=id;
	}
	
	public int getdepartmentId()
	{
		return DepartmentId;
	}
	public String getdepartmentname() {
		return DepartmentName;
	}

	public void setDepartmentName(String departmentName) {
		DepartmentName = departmentName;
	}

	public String getdepartmentdescription() {
		return DepartmentDescription;
	}

	public void setDepartmentDescription(String departmentDescription) {
		DepartmentDescription = departmentDescription;
	}

}
