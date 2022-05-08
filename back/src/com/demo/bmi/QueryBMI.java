package com.demo.bmi;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
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
import com.google.gson.Gson;

import net.sf.json.JSONObject;

/**
 * Servlet implementation class QueryBMI
 */
@WebServlet("/query-bmi")
public class QueryBMI extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public QueryBMI() {
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
		response.setContentType("text/html;charset=utf-8");
		/* 设置响应头允许ajax跨域访问 */
		response.setHeader("Access-Control-Allow-Origin", "*");
		/* 星号表示所有的异域请求都可以接受， */
		response.setHeader("Access-Control-Allow-Methods", "GET,POST");
		Connection con = null;
		Statement sql;
		ResultSet rs;
		PreparedStatement preSql;
		String sqlStr;
		con = GetDBConnection.connectDB("HealthyMySQL", "root", "12345");
		if (con == null)
			return;
		String type = request.getParameter("type");
		type = new String(type.getBytes("iso8859-1"), "UTF-8");
		if (type.endsWith("all")) {
			String openid = request.getParameter("openid");
			openid = new String(openid.getBytes("iso8859-1"), "UTF-8");
			ArrayList<BMIManageInfo> bmilist = new ArrayList<>();
			Dao bmidao = new Dao();
			BMIManageInfo bmiinfo = new BMIManageInfo();
			bmiinfo.setOpenid(openid);
			bmilist = bmidao.queryAllBMI(SqlStr.querybmi, bmiinfo);
			String json = new Gson().toJson(bmilist);
			System.out.println(json);
			Writer out = response.getWriter();
			out.write(json);
		} else if (type.endsWith("one")) {
			String openid = request.getParameter("openid");
			openid = new String(openid.getBytes("iso8859-1"), "UTF-8");
			try {
				sql = con.createStatement();
				sqlStr = "SELECT * FROM (select * from bmimanage where openid=?) a order by a.bmiid desc limit 1";
				preSql = con.prepareStatement(sqlStr);
				preSql.setString(1, openid);
				rs = preSql.executeQuery();
				if(rs.next()) {
					BMIManageInfo bmiinfo1 = new BMIManageInfo();
					bmiinfo1.setUsername(rs.getString("username"));
	            	bmiinfo1.setOpenid(rs.getString("openid"));
	            	bmiinfo1.setHight(rs.getFloat("high"));
	            	bmiinfo1.setWeight(rs.getFloat("weight"));
	            	bmiinfo1.setBMI(rs.getFloat("BMI"));
	            	bmiinfo1.setDate(rs.getString("date"));
	            	bmiinfo1.setBmiid(rs.getInt("bmiid"));
	            	bmiinfo1.setBody(rs.getString("body"));
	            	bmiinfo1.setDisease(rs.getString("disease"));
	            	 String json = new Gson().toJson(bmiinfo1);
     		 		 Writer out = response.getWriter();
     		 		 out.write(json);
					
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			

		}

	}

}
