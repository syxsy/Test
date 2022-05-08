<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@page import="java.sql.*,javax.sql.*" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>显示doctorusers表</title>
</head>
<body>

<table border="1">
	<tr>
		<td>doctorname</td>
		<td>password</td>
		<td>workdepartment</td>
	</tr>	
<c:forEach var="doctoruserslist" items="${doctoruserslist }">
	<tr>
	<td>${doctoruserslist.doctorname }</td>
	<td>${doctoruserslist.password }</td>
	<td>${doctoruserslist.getWorkDepartment() }</td>
	</tr>
	
</c:forEach>
</table>

</body>
</html>