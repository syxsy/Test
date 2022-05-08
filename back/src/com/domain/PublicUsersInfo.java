package com.domain;

public class PublicUsersInfo {
	public String username;
	public String openid;
	public String avatarUrl;
	
	public PublicUsersInfo() {
		
	}
	public PublicUsersInfo(String username,String openid,String avatarUrl) {
		this.username=username;
		this.openid=openid;
		this.avatarUrl=avatarUrl;
	}
	public String getAvatarUrl() {
		return avatarUrl;
	}
	public void setAvatarUrl(String avatarUrl) {
		this.avatarUrl = avatarUrl;
	}
	public String getUsername() {
		return username;
	}
	public String getOpenid() {
		return openid;
	}
	public void setOpenid(String openid) {
		this.openid = openid;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	

}
