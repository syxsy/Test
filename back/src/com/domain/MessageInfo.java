package com.domain;

public class MessageInfo {
	public int mesid;
	public String username;
	public String doctorname;
	public String content;
	public int type;
	
	public MessageInfo() {
		
	}
	
	public MessageInfo(int mesid,String username,String doctorname,String content,int type) {
		this.mesid=mesid;
		this.doctorname=doctorname;
		this.content=content;
		this.type=type;
	}

	public int getMesid() {
		return mesid;
	}

	public void setMesid(int mesid) {
		this.mesid = mesid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getDoctorname() {
		return doctorname;
	}

	public void setDoctorname(String doctorname) {
		this.doctorname = doctorname;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}
}
