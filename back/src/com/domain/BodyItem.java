package com.domain;

public class BodyItem {
	public int bodyitemid;
	public String title,openid,content,username;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public BodyItem() {}
	public int getBodyitemid() {
		return bodyitemid;
	}
	public void setBodyitemid(int bodyitemid) {
		this.bodyitemid = bodyitemid;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getOpenid() {
		return openid;
	}
	public void setOpenid(String openid) {
		this.openid = openid;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
}
