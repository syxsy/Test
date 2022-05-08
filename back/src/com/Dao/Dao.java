package com.Dao;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.domain.*;
import com.google.gson.Gson;

import net.sf.json.JSONObject;
public class Dao {
	Connection con = GetDBConnection.connectDB("HealthyMySQL","root","12345");
	Statement sql; 
    ResultSet rs = null;
	public boolean queryUsers(Object object,String tableflag,String sqlstr)
    {
        boolean flag=false;
        ResultSet resultSet;
        try {
            PreparedStatement preparedStatement;
            if(tableflag.equals(TableFlag.publicusersinfo)) {
            	preparedStatement = con.prepareStatement(sqlstr);
            	PublicUsersInfo publicusers=new PublicUsersInfo();
            	publicusers=(PublicUsersInfo) object;
                preparedStatement.setString(2,publicusers.getUsername());
                preparedStatement.setString(1,publicusers.getOpenid());
                resultSet = preparedStatement.executeQuery();
                if(resultSet.next()) {
                	flag=true;
                }else {
                	flag=false;
                }
                return flag;
            }else if(tableflag.equals(TableFlag.doctorusersinfo)) {
            	preparedStatement = con.prepareStatement(sqlstr);
            	DoctorUsers doctorusers=new DoctorUsers();
            	doctorusers=(DoctorUsers) object;
                preparedStatement.setString(2,doctorusers.getDoctorname());
                preparedStatement.setString(1,doctorusers.getOpenid_doc());
                resultSet = preparedStatement.executeQuery();
                if(resultSet.next()) {
                	flag=true;
                }else {
                	flag=false;
                }
                return flag;
		    	
            }
            
            
        }
        catch (SQLException e)
        {
            e.printStackTrace();
            return flag;
        }
		return flag;
        
    }
	public  ArrayList<PublicUsersInfo> queryAllUsers(String sqlstr)
    {
        ArrayList<PublicUsersInfo> publicuserslist = new ArrayList<>();
        try {
        	 sql=con.createStatement();
			 rs=sql.executeQuery(sqlstr);
            while(rs.next()) {
            	PublicUsersInfo publicusersinfo = new PublicUsersInfo();
            	
            	publicusersinfo.setOpenid(rs.getString("openid"));
            	publicusersinfo.setUsername(rs.getString("username"));
					publicuserslist.add(publicusersinfo);
            }	
            return publicuserslist;
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
		return publicuserslist;
        
    }

	public  ArrayList<BMIManageInfo> queryAllBMI(String sqlstr,Object object)
    {
        ArrayList<BMIManageInfo> bmilist = new ArrayList<>();
        ResultSet rs;
        PreparedStatement preparedStatement;
        try {
        	 sql=con.createStatement();
			 preparedStatement = con.prepareStatement(sqlstr);
			 BMIManageInfo bmiinfo=new BMIManageInfo();
			 bmiinfo=(BMIManageInfo) object;
			 preparedStatement.setString(1,bmiinfo.getOpenid());
			 System.out.println("dao:"+bmiinfo.getOpenid());
			  rs= preparedStatement.executeQuery();
            while(rs.next()) {
            	BMIManageInfo bmiinfo1=new BMIManageInfo();
            	bmiinfo1.setUsername(rs.getString("username"));
            	bmiinfo1.setOpenid(rs.getString("openid"));
            	bmiinfo1.setHight(rs.getFloat("high"));
            	bmiinfo1.setWeight(rs.getFloat("weight"));
            	bmiinfo1.setBMI(rs.getFloat("BMI"));
            	bmiinfo1.setDate(rs.getString("date"));
            	bmiinfo1.setBmiid(rs.getInt("bmiid"));
            	bmiinfo1.setBody(rs.getString("body"));
            	bmiinfo1.setDisease(rs.getString("disease"));
        		//String json1 = new Gson().toJson(bmiinfo);
            	//System.out.println("json1:"+json1);
            	bmilist.add(bmiinfo1);
            }	
            String json = new Gson().toJson(bmilist);
    		System.out.println("dao");
    		System.out.println(json);
            return bmilist;
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
		return bmilist;
        
    }
	public  ArrayList<DoctorUsers> queryOneDoctor(String sqlstr,Object object)
    {
        ArrayList<DoctorUsers> doctorlist = new ArrayList<>();
        ResultSet rs;
        PreparedStatement preparedStatement;
        try {
        	 sql=con.createStatement();
			 preparedStatement = con.prepareStatement(sqlstr);
			 DoctorUsers doctorinfo=new DoctorUsers();
			 doctorinfo=(DoctorUsers) object;
			 preparedStatement.setString(2,doctorinfo.getDoctorname());
			 preparedStatement.setString(1,doctorinfo.getOpenid_doc());
			  rs= preparedStatement.executeQuery();
            if(rs.next()) {
            	doctorinfo.setDoctorname(rs.getString("doctorname"));
            	doctorinfo.setOpenid_doc(rs.getString("openid_doc"));
            	doctorinfo.setWorkDepartment(rs.getString("WorkDepartment"));
            	doctorinfo.setWorkpart(rs.getString("workpart"));
            	doctorlist.add(doctorinfo);
            }	
            return doctorlist;
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
		return doctorlist;
        
    }
	public boolean addUsers(Object object,String tableflag,String sqlstr)
    {
        try {
            PreparedStatement preparedStatement = con.prepareStatement(sqlstr);
            if(tableflag.equals(TableFlag.publicusersinfo)) {
            	PublicUsersInfo publicusersinfo = new PublicUsersInfo();
            	publicusersinfo=(PublicUsersInfo) object;
            	preparedStatement.setString(3,publicusersinfo.getAvatarUrl());
            	preparedStatement.setString(2,publicusersinfo.getUsername());
            	preparedStatement.setString(1,publicusersinfo.getOpenid());
            }else if(tableflag.equals(TableFlag.bmimanageinfo)) {
            	BMIManageInfo bmimanageinfo=new BMIManageInfo();
            	bmimanageinfo=(BMIManageInfo) object;
            	//weight,high,BMI,body,disease,openid,username,date
            	preparedStatement.setFloat(1, bmimanageinfo.getWeight());
            	preparedStatement.setFloat(2, bmimanageinfo.getHight());
            	preparedStatement.setFloat(3, bmimanageinfo.getBMI());
            	preparedStatement.setString(4,bmimanageinfo.getBody());
            	preparedStatement.setString(5,bmimanageinfo.getDisease());
            	preparedStatement.setString(6,bmimanageinfo.getOpenid());
            	preparedStatement.setString(7,bmimanageinfo.getUsername());
            	preparedStatement.setString(8,bmimanageinfo.getDate());
            }else if(tableflag.equals(TableFlag.doctorusersinfo)) {
            	DoctorUsers doctorinfo=new DoctorUsers();
            	doctorinfo=(DoctorUsers) object;
            	preparedStatement.setString(2,doctorinfo.getDoctorname());
            	preparedStatement.setString(1,doctorinfo.getOpenid_doc());
            	preparedStatement.setString(3,doctorinfo.getWorkDepartment());
            	preparedStatement.setString(4,doctorinfo.getWorkpart());
            }
            int ok=preparedStatement.executeUpdate();
            return preparedStatement.getUpdateCount() != 0;
        }
        catch (SQLException e)
        {
            e.printStackTrace();
            return false;
        }
        
    }
	public boolean deleteUsers(Object object,String tableflag,String sqlstr)
    {
        try {
            PreparedStatement preparedStatement = con.prepareStatement(sqlstr);
            if(tableflag.equals(TableFlag.publicusersinfo)) {
            	PublicUsersInfo publicusers=new PublicUsersInfo();
            	publicusers=(PublicUsersInfo) object;
            	preparedStatement.setString(1,publicusers.getUsername());
            }
            preparedStatement.executeUpdate();
            return preparedStatement.getUpdateCount() != 0;
        }
        catch (SQLException e)
        {
            e.printStackTrace();
            return false;
        }
        
    }
	public boolean updateUsers(Object object,String tableflag,String sqlstr)
    {
        try {
            PreparedStatement preparedStatement = con.prepareStatement(sqlstr);
            if(tableflag.equals(TableFlag.publicusersinfo)) {
            	PublicUsersInfo publicusers=new PublicUsersInfo();
            	publicusers=(PublicUsersInfo) object;
            	preparedStatement.setString(2,publicusers.getUsername());
            	preparedStatement.setString(1,publicusers.getOpenid());
            }else if(tableflag.equals(TableFlag.doctorusersinfo)){
            	DoctorUsers doctorinfo=new DoctorUsers();
            	doctorinfo=(DoctorUsers) object;
            	preparedStatement.setString(1,doctorinfo.getOpenid_doc());
            	preparedStatement.setString(2,doctorinfo.getDoctorname());
            }
            preparedStatement.executeUpdate();
            return preparedStatement.getUpdateCount() != 0;
        }
        catch (SQLException e)
        {
            e.printStackTrace();
            return false;
        }
        
    }
}
