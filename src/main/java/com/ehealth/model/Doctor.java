package com.ehealth.model;


import java.util.Date;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Doctor {
	
	@Id
	@GeneratedValue
	public int Id;

	public String Name;
	public String Cnic;
	public String getCnic() {
		return Cnic;
	}
	public void setCnic(String cnic) {
		Cnic = cnic;
	}
	public String Email;
	public String Password;
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public String HomeAddress;
	public String OfficeAddress;
	public String Sex;
	public Date BirthDate;
	public String Degree;
	public String Specialization;
	
	//public String DepartmentId;

	
	public byte [] Content;
    
	
	public byte [] getcontent() {
		return Content;
	}
	public void setContent(byte[] content) {
		Content = content;
	}
	@ManyToOne(optional=false)
	@JoinColumn(name="DepartmentId")

	public Department department;
	
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	
	
	public int getid() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getname() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getemail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String gethomeAddress() {
		return HomeAddress;
	}
	public void setHomeAddress(String homeAddress) {
		HomeAddress = homeAddress;
	}
	public String getofficeAddress() {
		return OfficeAddress;
	}
	public void setOfficeAddress(String officeAddress) {
		OfficeAddress = officeAddress;
	}
	public String getsex() {
		return Sex;
	}
	public void setSex(String sex) {
		Sex = sex;
	}
	public Date getbirthDate() {
		return BirthDate;
	}
	public void setBirthDate(Date birrthDate) {
		BirthDate = birrthDate;
	}
	public String getdegree() {
		return Degree;
	}
	public void setDegree(String degreee) {
		Degree = degreee;
	}
	public String getspecialization() {
		return Specialization;
	}
	public void setSpecialization(String specialization) {
		Specialization = specialization;
	}
//	public String getdepartmentId() {
//		return DepartmentId;
//	}
//	public void setDepartmentId(String departmentId) {
//		DepartmentId = departmentId;
//	}

}
