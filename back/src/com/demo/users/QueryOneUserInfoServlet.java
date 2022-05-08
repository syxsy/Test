package com.demo.users;

import java.io.IOException;



import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.Dao.Dao;
import com.domain.*;

import net.sf.json.JSONObject;

/**
 * Servlet implementation class QueryOneUserInfoServlet
 */
@WebServlet("/queryoneuserinfoservlet")
public class QueryOneUserInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QueryOneUserInfoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 request.setCharacterEncoding("utf-8");
	        response.setContentType("text/html;charset=utf-8");
	    
			
		String openid = request.getParameter("openid");
		openid = new String(openid.getBytes("iso8859-1"),"UTF-8");
		 String username = request.getParameter("username");
		 username = new String(username.getBytes("iso8859-1"),"UTF-8");
		 Dao publicusersdao=new Dao();
		 PublicUsersInfo publicusers=new PublicUsersInfo();
		 publicusers.setUsername(username);
		 publicusers.setOpenid(openid);
		 PrintWriter out = response.getWriter();
		if(!publicusersdao.queryUsers(publicusers,TableFlag.publicusersinfo,SqlStr.select_PublicUsers)) {
			out.write("login failed");
			response.sendError(204, "login failed");
			
		}else{
			out.write("login success");
		}
	}

}
