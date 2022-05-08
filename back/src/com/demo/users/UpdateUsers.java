package com.demo.users;

import java.io.IOException;



import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Dao.Dao;
import com.domain.*;

/**
 * Servlet implementation class UpdateServlet
 */
@WebServlet("/update-servlet")
public class UpdateUsers extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateUsers() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		 String username = request.getParameter("username");
		 username = new String(username.getBytes("iso8859-1"),"UTF-8");
		 String openid = request.getParameter("openid");
		 openid = new String(openid.getBytes("iso8859-1"),"UTF-8");
		 Dao publicusersdao=new Dao();
		 PublicUsersInfo publicusers=new PublicUsersInfo();
		 publicusers.setOpenid(openid);
		 publicusers.setUsername(username);
			 PrintWriter out = response.getWriter();
			if(!publicusersdao.updateUsers(publicusers,TableFlag.publicusersinfo,SqlStr.update_PublicUsers)) {
				response.sendError(204, "insert failed");
				out.println("update failed");
			}else{
				out.println("update success");
			}
	}

}
