<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>操作users表</title>
</head>
<body>
<H3>插入BMI信息</H3>
<form action="insert-bmi"method="post">
  <label>username<input type="text" name="username" size="15" /><br></label>
   <label> age<input type="text" name="age" size="15"/><br></label> 
   <label> high<input type="text" name="high" size="15"/><br></label> 
   <label> weight<input type="text" name="weight" size="15"/><br></label> 
    <label><input type="submit" value="插入" /> </label>
</form>

<h3>查询bmi信息</h3>
<form action="query-bmi"method="post">
  <label>输入查询的用户名<input type="text" name="username" size="15" /><br></label>
<label><input type="submit"value="查询"  /></label> 
</form>
</html>