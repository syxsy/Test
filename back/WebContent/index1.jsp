<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@page import="java.sql.*,javax.sql.*" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="admininsertbody-servlet" method="post" enctype="multipart/form-data">
		<label>title<input type="text" name="title" size="15" /><br></label>
		<label> address<input type="text" name="address" size="15" /><br></label>
		<label> price<input type="text" name="price" size="15" /><br></label>
		<label> score<input type="text" name="score" size="15" /><br></label>
		<label> distance<input type="text" name="distance" size="15" /><br></label>
		<label><input type="file" name="img" /> </label>
		<label><input type="submit" value="注册" /> </label>
	</form>
	
	<form action="readfil-servlet" method="post">
<input type="submit"size="15" value="下载文件"/>
</form>
	<form action="insertyangsheng-servlet" method="post">
		<label>title<input type="text" name="title" size="15" /><br></label>
		<label> content<input type="text" name="content" size="15" /><br></label>
		<label> tag<input type="text" name="tag" size="15" /><br></label>
		<label> readnumber<input type="text" name=" readnumber" size="15" /><br></label>
		<label> date<input type="text" name="date" size="15" /><br></label>
		<label>img<input type="text" name="img" size="15" /><br></label>
		<label><input type="submit" value="登录" /> </label>
	</form>
</body>
</html>