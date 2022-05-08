package com.domain;

public class SqlStr {
	//操作PublicUsers
	public static String select_allPublicUsers = "select * from publicusers";
	public static String add_PublicUsers= "insert into publicusers(openid,username,avatarUrl) values(?,?,?)";
	public static String delete_PublicUsers = "delete from publicusers where openid = ?";
	public static String update_PublicUsers = "update publicusers set username=? where openid=?";
	public static String select_PublicUsers = "select * from publicusers where openid = ? and username = ?";
	
	//操作DoctorUsers
	public static String add_DoctorUsers = "insert into doctorusers(openid_doc,doctorname,workdepartment,workpart) values(?,?,?,?)";
	public static String update_DoctorUsers_password = "update doctorusers set doctorname=? where openid_doc=?";
	public static String select_oneDoctorUsers = "select * from doctorusers where openid_doc = ? and openid_doc = ?";
	
	//操作BMIManage
	public static String addbmi="insert into bmimanage(weight,high,BMI,body,disease,openid,username,date) values(?,?,?,?,?,?,?,?)";
	public static String querybmi="select * from (select * from bmimanage order by date desc) as a where a.openid=?";
	public static BMIManageInfo bmiManageInfo=new BMIManageInfo();
	//操作MessageInfo content type
	public static String query_MessageInfo="SELECT content FROM MeswwaasyyyyyyyyyyyyyyyyyyyysageInfo WHERE username=? and doctorname=?";
	public static String insert_MessageInfo="insert into Message(username,doctorname,content,type) values(?,?,?,?)";
	

}
