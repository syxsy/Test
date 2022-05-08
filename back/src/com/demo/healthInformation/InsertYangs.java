package com.demo.healthInformation;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.domain.GetDBConnection;

/**
 * Servlet implementation class InsertYangs
 */
@WebServlet("/insertyangsheng-servlet")
public class InsertYangs extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertYangs() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
	      //在响应的时候设置编码是utf-8
	     response.setCharacterEncoding("utf-8");
		String title = request.getParameter("title");
		//title = new String(title.getBytes("iso8859-1"), "UTF-8");
		String content = request.getParameter("content");
		//content = new String(content.getBytes("iso8859-1"), "UTF-8");
		String date = request.getParameter("date");
		//date = new String(date.getBytes("iso8859-1"), "UTF-8");
		String img = request.getParameter("img");
		//img = new String(img.getBytes("iso8859-1"), "UTF-8");
		String tag = request.getParameter("tag");
		//tag = new String(tag.getBytes("iso8859-1"), "UTF-8");
		int readnumber=Integer.parseInt(request.getParameter("readnumber"));
		System.out.println("readnumber:"+request.getParameter("readnumber"));
		System.out.println("title:"+request.getParameter("title"));
		System.out.println("content:"+content);
		System.out.println("tag:"+tag);
		System.out.println("date:"+date);
		System.out.println("img:"+img);
	//	System.out.println("readnumber:"+readnumber);
		Connection con = GetDBConnection.connectDB("HealthyMySQL", "root", "12345");
		Statement sql;
		ResultSet rs = null;
		PrintWriter out = response.getWriter();
		String sqlstr = "insert into yangsheng(title,content,tag,readnumber,date,img) values(?,?,?,?,?,?)";
		try {
			sql=con.createStatement();
			 PreparedStatement preparedStatement = con.prepareStatement(sqlstr);
			preparedStatement.setString(1, title);
			preparedStatement.setString(2, content);
			preparedStatement.setString(3, tag);
			preparedStatement.setInt(4, readnumber);
			preparedStatement.setString(5, date);
			preparedStatement.setString(6, img);
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
