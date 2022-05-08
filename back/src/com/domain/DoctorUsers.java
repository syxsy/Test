package com.domain;

public class DoctorUsers {
	public String doctorname;
	public String openid_doc;
	public String WorkDepartment;
	public String workpart;
	
	public DoctorUsers() {
		
	}
	public DoctorUsers(String openid_doc,String doctorname,String WorkDepartment,String workpart) {
		this.doctorname=doctorname;
		this.openid_doc=openid_doc;
		this.WorkDepartment=WorkDepartment;
		this.workpart=workpart;
	}
	public String getDoctorname() {
		return doctorname;
	}
	public void setDoctorname(String doctorname) {
		this.doctorname = doctorname;
	}
	public String getOpenid_doc() {
		return openid_doc;
	}
	public void setOpenid_doc(String openid_doc) {
		this.openid_doc = openid_doc;
	}
	public String getWorkDepartment() {
		return WorkDepartment;
	}
	public void setWorkDepartment(String workDepartment) {
		WorkDepartment = workDepartment;
	}
	public String getWorkpart() {
		return workpart;
	}
	public void setWorkpart(String workpart) {
		this.workpart = workpart;
	}
	
}
