package com.ehealth.model;

public class Response {
	
	public String Status;
	public String Description;
	public byte [] content;
	public Response(String st,String des)
	{
		Status=st;
		Description=des;
	}
	public Response(){};
	public String getStatus() {
		return Status;
	}
	public byte[] getContent() {
		return content;
	}
	public void setContent(byte[] content) {
		this.content = content;
	}
	public void setStatus(String status) {
		Status = status;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	
	

}
