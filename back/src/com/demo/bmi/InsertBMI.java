package com.demo.bmi;

import java.io.IOException;

import java.io.PrintWriter;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.text.SimpleDateFormat;

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
 * Servlet implementation class InsertBMI
 */
@WebServlet("/insert-bmi")
public class InsertBMI extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertBMI() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//username,date,age,high,weight,BMI
		 String username = request.getParameter("username");
		 username = new String(username.getBytes("iso8859-1"),"UTF-8");
		 String openid = request.getParameter("openid");
		 openid = new String(openid.getBytes("iso8859-1"),"UTF-8");
		 Date date = new Date();
		 SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); //格式化为：年月日 时分秒 以匹配数据库相应字段的类型
		 String datetime = sdf.format(date);
		 float high = Float.parseFloat(request.getParameter("high"));
		 float weight = Float.parseFloat(request.getParameter("weight"));
		 float BMI=(weight/(high*high));
		 Dao bmidao=new Dao();
		 BMIManageInfo bmimanageinfo=new BMIManageInfo();
		 bmimanageinfo.setOpenid(openid);
		 bmimanageinfo.setUsername(username);
		 bmimanageinfo.setDate(datetime);
		 bmimanageinfo.setHight(high);
		 bmimanageinfo.setWeight(weight);
		 bmimanageinfo.setBMI(BMI);
		 String disease=null,body=null;
		 if(BMI<18.5) {
			 disease="偏瘦";
			 body="低";
		 }else if((BMI>=18.5)&&(BMI<22.9)) {
			 disease="正常";
			 body="平均水平";
		 }else if((BMI>=22.9)&&(BMI<24.9)) {
			 disease="偏胖";
			 body="增加";
		 }else if((BMI>=24.9)&&(BMI<29.9)) {
			 disease="肥胖";
			 body="重度增加";
		 }else if(BMI>=29.9) {
			 disease="重度偏胖";
			 body="严重增加";
		 }
		 bmimanageinfo.setDisease(disease);
		 bmimanageinfo.setBody(body);
		 Map<String, Object> result = new HashMap<String, Object>();
			result.put("date", datetime);
			result.put("BMI", BMI);
			result.put("weight", weight);
			String json = new Gson().toJson(result);
		 PrintWriter out = response.getWriter();
		 if(!bmidao.addUsers(bmimanageinfo,TableFlag.bmimanageinfo,SqlStr.addbmi)) {
				response.sendError(204, "insert failed");
				
				out.println("insertbmi failed");
		 }else{
			 
				out.write(json);
		}
	}

}
