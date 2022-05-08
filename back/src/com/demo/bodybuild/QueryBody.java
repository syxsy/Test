package com.demo.bodybuild;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;

import com.domain.GetDBConnection;

/**
 * Servlet implementation class QueryBody
 */
@WebServlet("/querybody-servlet")
public class QueryBody extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public QueryBody() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		Connection con = null;
		Statement sql;
		ResultSet rs;
		PreparedStatement preSql;
		con = GetDBConnection.connectDB("healthymysql", "root", "12345");
		if (con == null)
			return;
		try {
			sql = con.createStatement();
			String sqlStr = "SELECT * FROM body";
			preSql = con.prepareStatement(sqlStr);
			rs = preSql.executeQuery();
			ServletOutputStream sos = response.getOutputStream();
			while (rs.next()) {
				String filename = rs.getString("title");

				String filepath = request.getSession().getServletContext().getRealPath("/WEB-INF/upload/" + filename);
				//Blob blob = rs.getBlob("body");
				response.setContentType("APPLICATION/OCTET-STREAM");

				response.setHeader("Content-disposition",
						"inline; filename*=UTF-8''" + URLEncoder.encode(rs.getString("title"), "UTF-8"));
				sos.write(rs.getBytes("img"));

			}
		} catch (SQLException e) {
			// RequestDispatcher view = request.getRequestDispatcher("/index.jsp");
			// view.forward(request, response);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
