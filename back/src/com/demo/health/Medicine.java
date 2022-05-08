package com.demo.health;

import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.domain.Pharmaceuticals;
import com.google.gson.Gson;

/**
 * Servlet implementation class Medicine
 */
@WebServlet("/medicine-servlet")
public class Medicine extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Medicine() {
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
        String sort = request.getParameter("sort");
        sort = new String(sort.getBytes("iso8859-1"),"UTF-8");
    	 ArrayList<Pharmaceuticals> Pharmaceuticalslist = new ArrayList<>();
    	 Pharmaceuticalslist=joUtil.getPharmaceuticalslist(sort);
    	 String json = new Gson().toJson(Pharmaceuticalslist);
 		System.out.println(json);
 		 Writer out = response.getWriter();
 		 out.write(json);

	}

}
