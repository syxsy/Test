package com.demo.Adminusers;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.domain.GetDBConnection;

/**
 * Servlet implementation class Insertadmin
 */
@WebServlet("/insertadmin-servlet")
public class Insertadmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Insertadmin() {
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
		 String password = request.getParameter("password");
		 password = new String(password.getBytes("iso8859-1"),"UTF-8");
		 Connection con = GetDBConnection.connectDB("HealthyMySQL","root","12345");
			Statement sql; 
		    ResultSet rs = null;
		    PrintWriter out = response.getWriter();
		    String sqlstr="insert into admin values(?,?)";
		    try {
				PreparedStatement preparedStatement = con.prepareStatement(sqlstr);
				preparedStatement.setString(1,username);
				preparedStatement.setString(2,password);
				int ok=preparedStatement.executeUpdate();
				if(preparedStatement.getUpdateCount() != 0) {
					out.println("resgister success");
					
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

}
