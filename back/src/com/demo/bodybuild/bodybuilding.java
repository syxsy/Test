package com.demo.bodybuild;

import java.io.IOException;

import java.io.Writer;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.domain.*;
import com.google.gson.Gson;
import com.mysql.cj.jdbc.Blob;

import net.sf.json.JSONObject;

/**
 * Servlet implementation class bodybuilding
 */
@WebServlet("/body-building")
public class bodybuilding extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public bodybuilding() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=utf-8");
        /*设置响应头允许ajax跨域访问*/
		response.setHeader("Access-Control-Allow-Origin", "*");
		
		/* 星号表示所有的异域请求都可以接受， */
        response.setHeader("Access-Control-Allow-Methods", "GET,POST");
		 String type = request.getParameter("type");
		 type = new String(type.getBytes("iso8859-1"),"UTF-8");
		
	        Connection con=null;
		      Statement sql; 
		      ResultSet rs;
		      PreparedStatement preSql;
		      String sqlStr;
			con = GetDBConnection.connectDB("HealthyMySQL","root","12345");
		     if(con == null ) return;
		 if(type.endsWith("bodylist")) {
			 try {
				 ArrayList<Body> bodylist = new ArrayList<>();
				 ArrayList<Body> bodylist1 = new ArrayList<>();
				 sql=con.createStatement();
				 sqlStr="SELECT * FROM body order by distance";
				rs=sql.executeQuery(sqlStr);
				while(rs.next()) {
	            	Body body=new Body();
	            	body.setAddress(rs.getString("address"));
	            	body.setBodyid(rs.getInt("bodyid"));
	            	body.setDistance(rs.getFloat("distance"));
	            	body.setPath(rs.getString("path"));
	            	body.setPrice(rs.getFloat("price"));
	            	body.setScore(rs.getFloat("score"));
	            	body.setTitle(rs.getString("title"));
	            	bodylist.add(body);
	            }	
				 String json = new Gson().toJson(bodylist);
		 		 Writer out = response.getWriter();
		 		 out.write(json);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 
			 
		 }else if(type.endsWith("onebody")) {
			 try {
				sql=con.createStatement();
				int onebodyid = Integer.parseInt(request.getParameter("onebodyid"));
				sqlStr ="SELECT * FROM body WHERE bodyid=?";
				 preSql = con.prepareStatement(sqlStr);	
				 preSql.setInt(1, onebodyid);
				 rs=preSql.executeQuery();
				 if(rs.next()) {
					 Body body=new Body();
		            	body.setAddress(rs.getString("address"));
		            	body.setBodyid(rs.getInt("bodyid"));
		            	body.setDistance(rs.getFloat("distance"));
		            	body.setPath(rs.getString("path"));
		            	body.setPrice(rs.getFloat("price"));
		            	body.setScore(rs.getFloat("score"));
		            	body.setTitle(rs.getString("title"));
		            	String json = new Gson().toJson(body);
				 		 Writer out = response.getWriter();
				 		 out.write(json);
				 }
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				
		 }else if(type.endsWith("onebodycontent")){
			 try {
					sql=con.createStatement();
					 String title = request.getParameter("title");
					 title = new String(title.getBytes("iso8859-1"),"UTF-8");
					sqlStr ="SELECT * FROM bodyitem WHERE title=?";
					 preSql = con.prepareStatement(sqlStr);	
					 preSql.setString(1, title);
					 rs=preSql.executeQuery();
					 ArrayList<BodyItem> bodyitemlist = new ArrayList<>();
					 while(rs.next()) {
						 BodyItem bodyitem= new BodyItem();
						 bodyitem.setBodyitemid(rs.getInt("bodyitemid"));
						 bodyitem.setContent(rs.getString("content"));
						 bodyitem.setOpenid(rs.getString("openid"));
						 bodyitem.setTitle(rs.getString("title"));
						 bodyitem.setUsername(rs.getString("username"));
						 bodyitemlist.add(bodyitem);
			            	
					 }
					 String json = new Gson().toJson(bodyitemlist);
			 		 Writer out = response.getWriter();
			 		 out.write(json);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		 }else {
			 try {
					sql=con.createStatement();
					 String insertitle = request.getParameter("title");
					 insertitle = new String(insertitle.getBytes("iso8859-1"),"UTF-8");
					 String content = request.getParameter("content");
					 content = new String(content.getBytes("iso8859-1"),"UTF-8");
					 String username = request.getParameter("username");
					 username = new String(username.getBytes("iso8859-1"),"UTF-8");
					 String openid = request.getParameter("openid");
					 openid = new String(openid.getBytes("iso8859-1"),"UTF-8");
					 System.out.println("title:"+insertitle);
					 System.out.println("content:"+content);
					 System.out.println("username:"+username);
					 System.out.println("openid:"+openid);
					sqlStr ="insert into bodyitem(title,content,openid,username) values(?,?,?,?)";
					preSql = con.prepareStatement(sqlStr);	
					 preSql.setString(1, insertitle);
					 preSql.setString(2, content);
					 preSql.setString(3, openid);
					 preSql.setString(4, username);
					int ok=preSql.executeUpdate();
					sqlStr ="SELECT * FROM bodyitem WHERE title=?";
					 preSql = con.prepareStatement(sqlStr);	
					 preSql.setString(1, insertitle);
					 rs=preSql.executeQuery();
					 ArrayList<BodyItem> bodyitemlist = new ArrayList<>();
					 while(rs.next()) {
						 BodyItem bodyitem= new BodyItem();
						 bodyitem.setBodyitemid(rs.getInt("bodyitemid"));
						 bodyitem.setContent(rs.getString("content"));
						 bodyitem.setOpenid(rs.getString("openid"));
						 bodyitem.setTitle(rs.getString("title"));
						 bodyitem.setUsername(rs.getString("username"));
						 bodyitemlist.add(bodyitem);
			            	
					 }
					 String json = new Gson().toJson(bodyitemlist);
			 		 Writer out = response.getWriter();
			 		 out.write(json);
					 
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		 }
	}

}
