package com.ehealth.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.Email;
@Entity
public class Staff {
	
	@Id
	@GeneratedValue
	public int Id;
	//@NotBlank(message = "Name is required.")
	//@Size(max = 20, message = "The Name can have at most {max} characters.")
	public String Name;
//	@NotBlank(message = "Email is required.")
	//@Size(max = 255, message = "The email address can have at most {max} characters.")
//	@Email(message="Enter Valid Email")
	public String Email;
//	@NotBlank(message = "MobileNo is required.")
	public String MobileNo;
	//public String DepartmentId;
	
	public String Cnic;
	public String Gender;
	
	public String getGender() {
		return Gender;
	}
	public void setGender(String gender) {
		Gender = gender;
	}
	@ManyToOne(optional=false)
	@JoinColumn(name="RoleId")
	public Roles roles;
	
	public String getCnic() {
		return Cnic;
	}
	public void setCnic(String cnic) {
		Cnic = cnic;
	}
	public Roles getRoles() {
		return roles;
	}
	public void setRoles(Roles roles) {
		this.roles = roles;
	}
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
	public String getmobileNo() {
		return MobileNo;
	}
	public void setMobileNo(String mobileNo) {
		MobileNo = mobileNo;
	}
	
}
