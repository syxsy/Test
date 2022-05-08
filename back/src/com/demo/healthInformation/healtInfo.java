package com.demo.healthInformation;

import java.io.IOException;
import java.io.Writer;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.demo.health.joUtil;
import com.domain.*;
import com.google.gson.Gson;

/**
 * Servlet implementation class healtInfo
 */
@WebServlet("/healtInfo-servlet")
public class healtInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public healtInfo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=utf-8");
		response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "GET,POST");
        String type = request.getParameter("type");
        type = new String(type.getBytes("iso8859-1"),"UTF-8");
        
        ArrayList<yangsheng> yangshenglist = new ArrayList<>();
        Connection con=null;
	      Statement sql; 
	      ResultSet rs;
	      PreparedStatement preSql;
	      String sqlStr;
		con = GetDBConnection.connectDB("HealthyMySQL","root","12345");
	     if(con == null ) return;
        if(type.equals("all")) {
        	 try {
        		 String tagflag = request.getParameter("tagflag");
        	        tagflag = new String(tagflag.getBytes("iso8859-1"),"UTF-8");
        		 sql=con.createStatement();
        		 sqlStr ="SELECT * FROM yangsheng WHERE tag=? order by readnumber desc";
    			 preSql = con.prepareStatement(sqlStr);	
    			 preSql.setString(1, tagflag);
    			 rs=preSql.executeQuery();
    			 
    			 while(rs.next()) {
    				 yangsheng ys=new yangsheng();
    				 ys.setId(rs.getInt("id"));
    				 ys.setTitle(rs.getString("title"));
    				 ys.setContent(rs.getString("content"));
    				 ys.setTag(rs.getString("tag"));
    				 ys.setReadnumber(rs.getInt("readnumber"));
    				 ys.setDate(rs.getString("date"));
    				 ys.setImg(rs.getString("img"));
    				 yangshenglist.add(ys);
    			 }
    			// System.out.println(yangshenglist);
    			 String json = new Gson().toJson(yangshenglist);
    		 		 Writer out = response.getWriter();
    		 		 out.write(json);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 
        }else if(type.equals("one")) {
        	try {
				sql=con.createStatement();
				int id = Integer.parseInt(request.getParameter("id"));
				sqlStr ="SELECT * FROM yangsheng WHERE id=?";
				 preSql = con.prepareStatement(sqlStr);	
				 preSql.setInt(1, id);
				 rs=preSql.executeQuery();
				 if(rs.next()) {
					 yangsheng ys=new yangsheng();
    				 ys.setId(rs.getInt("id"));
    				 ys.setTitle(rs.getString("title"));
    				 ys.setContent(rs.getString("content"));
    				 ys.setTag(rs.getString("tag"));
    				 ys.setReadnumber(rs.getInt("readnumber"));
    				 ys.setDate(rs.getString("date"));
    				 ys.setImg(rs.getString("img"));
    				 String json = new Gson().toJson(ys);
     		 		 Writer out = response.getWriter();
     		 		 out.write(json);
				 }
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
   		 	
        	
        }else {
        	try {
        		System.out.println("update id begin");
				sql=con.createStatement();
				int id = Integer.parseInt(request.getParameter("id"));
				System.out.println("update id:"+id);
				sqlStr ="update yangsheng set readnumber=readnumber+1 WHERE id=?";
				 preSql = con.prepareStatement(sqlStr);	
				 preSql.setInt(1, id);
				 int ok=preSql.executeUpdate();
				 
				 if(ok!=0) {
					 Writer out = response.getWriter();
     		 		 out.write("update success");
				 }
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }

	}

}
