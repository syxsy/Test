package com.demo.bodybuild;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.rowset.serial.SerialBlob;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.IOUtils;

import com.domain.GetDBConnection;

/**
 * Servlet implementation class Insertbody
 */
@WebServlet(name = "AdminInsertbody", urlPatterns = { "/admininsertbody-servlet" })
public class Insertbody extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Insertbody() {
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
		String title = request.getParameter("title");
		title = new String(title.getBytes("iso8859-1"), "UTF-8");
		String address = request.getParameter("address");
		address = new String(address.getBytes("iso8859-1"), "UTF-8");
		String path = request.getParameter("path");
		path = new String(path.getBytes("iso8859-1"), "UTF-8");
		float price = Float.parseFloat(request.getParameter("price"));
		float score = Float.parseFloat(request.getParameter("score"));
		float distance = Float.parseFloat(request.getParameter("distance"));
		
		Connection con = GetDBConnection.connectDB("HealthyMySQL", "root", "12345");
		Statement sql;
		ResultSet rs = null;
		PrintWriter out = response.getWriter();
		String sqlstr = "insert into body(title,address,price,score,distance,path) values(?,?,?,?,?,?)";
		try {
			sql=con.createStatement();
			 PreparedStatement preparedStatement = con.prepareStatement(sqlstr);
			preparedStatement.setString(1, title);
			preparedStatement.setString(2, address);
			preparedStatement.setFloat(3, price);
			preparedStatement.setFloat(4, score);
			preparedStatement.setFloat(5, distance);
			preparedStatement.setString(6, path);
			int ok = preparedStatement.executeUpdate();
			if (preparedStatement.getUpdateCount() != 0) {
				out.println("resgister success");

			}
		} catch (SQLException  e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
