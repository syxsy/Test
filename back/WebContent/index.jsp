<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@page import="java.sql.*,javax.sql.*" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>操作users表</title>
</head>
<body>

<form action="insertadmin-servlet"method="post">
  <label>username<input type="text" name="username" size="15" /><br></label> 
   <label> password<input type="text" name="password" size="15"/><br></label> 
    <label><input type="submit" value="注册" /> </label>
</form>
<form action="adminlogin-servlet"method="post">
  <label>username<input type="text" name="username" size="15" /><br></label> 
   <label> password<input type="text" name="password" size="15"/><br></label> 
    <label><input type="submit" value="登录" /> </label>
</form>





</body>
</html>