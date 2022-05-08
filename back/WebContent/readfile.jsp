<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@page import="java.sql.*,javax.sql.*" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>下载文件</title>
</head>
<body>
<form action="readfil-servlet" method="post">
<label>filename<input type="text" name="filename" size="15" /><br></label>
	文件下载点击下方<hr>
<input type="submit"size="15" />
</form>
</body>
</html>