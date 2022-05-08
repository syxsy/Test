<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@page import="java.sql.*,javax.sql.*" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>bmi表</title>
</head>
<body>
<table border="1">
	<tr>
		<td>hight</td>
		<td>weight</td>
		<td>BMI</td>
		<td>Date</td>
	</tr>	
<c:forEach var="bmi" items="${bmilist }">
	<tr>
	<td>${bmi.hight }</td>
	<td>${bmi.weight }</td>
	<td>${bmi.BMI }</td>
	<td>${bmi.date }</td>
	</tr>
	
</c:forEach>
</table>
</body>
</html>