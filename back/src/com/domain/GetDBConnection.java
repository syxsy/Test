package com.domain;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException; 
public class GetDBConnection {
   public static Connection connectDB(String DBName,String id,String p) {
      Connection con = null;
      String 
      uri = "jdbc:mysql://localhost:3306/"+DBName+"?useSSL=true&characterEncoding=utf-8";
      try{  Class.forName("com.mysql.jdbc.Driver");
      }
      catch(Exception e){}
      try{  
         con = DriverManager.getConnection(uri,id,p); 
      }
      catch(SQLException e){}
      return con;
   }
}