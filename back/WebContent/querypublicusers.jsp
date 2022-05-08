<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>查询</title>

</head>
<body>

<p>查询users表</p>
<form action="query-servlet"method="post">
<label><input type="submit"value="查询"  /></label> 
</form>

<p>插入数据</p>
<form action="insert-servlet"method="post">
  <label>username<input type="text" name="username" size="15" /><br></label> 
   <label> password<input type="text" name="password" size="15"/><br></label> 
    <label><input type="submit" value="插入" /> </label>
</form>

<p>修改数据</p>
<form action="update-servlet"method="post">

  <label>username<input type="text" name="username" size="15" /><br></label>
   <label> password<input type="text" name="password" size="15" /><br></label> 
   <label> <input type="submit" value="修改" /> </label> 
</form>

<form action="queryoneuserinfoservlet"method="post">
<h3>登录</h3>
  <label>username<input type="text" name="username" size="15" /><br></label>
   <label>"password"<input type="text" name="password" size="15" /><br></label>
   <label> <input type="submit" value="登录" /> </label> 
</form>
</body>
</html>