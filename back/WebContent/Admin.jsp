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

	<form action="admininsertbody-servlet" method="post" >
		<label>title<input type="text" name="title" size="15" /><br></label>
		<label> address<input type="text" name="address" size="15" /><br></label>
		<label> price<input type="text" name="price" size="15" /><br></label>
		<label> score<input type="text" name="score" size="15" /><br></label>
		<label> distance<input type="text" name="distance" size="15" /><br></label>
		<label>path<input type="text" name="path" size="100" /><br></label>
		<label><input type="submit" value="添加" /> </label>
	</form>
	<br>
	<br>
	<br>
	<br>
	<form action="insertyangsheng-servlet" method="post">
		<label>title<input type="text" id="title" name="title" size="15" /><br></label>
		<label> content<input type="text" id="content" name="content" size="55" /><br></label>
		<label> tag<input type="text" id="tag" name="tag" size="15" /><br></label>
		<label> readnumber<input type="text" id="readnumber" name="readnumber" size="15" /><br></label>
		<label> date<input type="text" id="date" name="date" size="15" /><br></label>
		<label>img<input type="text" id="img" name="img" size="100" /><br></label>
		<label><input type="submit" value="添加" /> </label>
	</form>




</body>
</html>