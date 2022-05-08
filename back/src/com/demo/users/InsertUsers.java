package com.demo.users;

import java.io.IOException;




import java.io.PrintWriter;
import java.io.Writer;
import java.sql.Connection;
import java.sql.DriverManager;
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

import org.apache.hc.client5.http.classic.HttpClient;
import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.omg.CORBA.portable.ResponseHandler;

import com.Dao.Dao;
import com.domain.*;
import com.google.gson.Gson;

import net.sf.json.JSONObject;

/**
 * Servlet implementation class InsertServlet
 */
@WebServlet("/insert-servlet")
public class InsertUsers extends HttpServlet {
	private static final long serialVersionUID = 1L;



       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertUsers() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 
		response.setContentType("text/html;charset=utf-8");
        /*设置响应头允许ajax跨域访问*/
		response.setHeader("Access-Control-Allow-Origin", "*");
		
		/* 星号表示所有的异域请求都可以接受， */
        response.setHeader("Access-Control-Allow-Methods", "GET,POST");
        
        
      //获取微信小程序get的参数值并打印
        String code = request.getParameter("code");
        String encryptedData = request.getParameter("encryptedData");
        String iv = request.getParameter("iv");
 
        WechatLoginController getopenid=new WechatLoginController();
		//调用访问微信服务器工具方法，传入三个参数获取带有openid、session_key的json字符串
		String jsonId=getopenid.getOpenId(TableFlag.APPID,TableFlag.SECRET,code);
		JSONObject jsonObject = JSONObject.fromObject(jsonId); 
		//从json字符串获取openid和session_key
		String openid=jsonObject.getString("openid");
		String session_key=jsonObject.getString("session_key");
		
		System.out.println("openid："+openid);
		System.out.println("session_key："+session_key);
		System.out.println("encryptedData："+encryptedData);
		System.out.println("iv："+iv);
		String username=null;
		String avatarUrl=null;
        try {
        	 Map map = new HashMap();
            String result = AesCbcUtil.decrypt(encryptedData, session_key, iv, "UTF-8");
            if (null != result && result.length() > 0) {
                map.put("code", 1);
                map.put("msg", "解密成功");
               

                JSONObject userInfoJSON = JSONObject.fromObject(result);
                username=(String) userInfoJSON.get("nickName");
                avatarUrl=(String) userInfoJSON.get("avatarUrl");
                System.out.println("userInfoJSON:"+userInfoJSON.toString());
                System.out.println("nickname:"+userInfoJSON.get("nickName"));
                System.out.println("avatarUrl:"+userInfoJSON.get("avatarUrl"));
                
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        

			 
			 Dao publicusersdao=new Dao();
			 PublicUsersInfo publicusers=new PublicUsersInfo();
			 publicusers.setUsername(username);
			 publicusers.setOpenid(openid);
			 publicusers.setAvatarUrl(avatarUrl);
			 Writer out = response.getWriter();
			 Map<String, Object> result = new HashMap<String, Object>();
				result.put("username", username);
				result.put("openid", openid);
				result.put("avatarUrl", avatarUrl);
				String json = new Gson().toJson(publicusers);
				System.out.println("json:"+json);
			 out.write(json);
			 
			if(!publicusersdao.queryUsers(publicusers,TableFlag.publicusersinfo,SqlStr.select_PublicUsers)) {
				if(!publicusersdao.addUsers(publicusers,TableFlag.publicusersinfo,SqlStr.add_PublicUsers)) {
					response.sendError(204, "resgister failed");
					//out.write("resgister failed");
				}else{
					//out.write("resgister success");
				}
				
			}else{
				//out.write("login success");
			}
			 
			
		
	}

}


