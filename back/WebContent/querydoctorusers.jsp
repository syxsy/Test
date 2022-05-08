<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<p>插入数据</p>
<form action="insert-doctor"method="post">
  <label>doctorname<input type="text" name="doctorname" size="15" /><br></label> 
   <label> password<input type="text" name="password" size="15"/><br></label> 
    <label> workdepartment<input type="text" name="workdepartment" size="15"/><br></label>
    <label><input type="submit" value="插入" /> </label>
</form>

<h3>查询医生信息</h3>
<form action="query-doctor"method="post">
  <label>输入查询的医生用户名<input type="text" name="doctorname" size="15" /><br></label>
   <label> password<input type="text" name="password" size="15"/><br></label> 
<label><input type="submit"value="查询"  /></label> 
</form>

<h3>更改密码</h3>
<form action="update-doctorps"method="post">
  <label>doctorname<input type="text" name="doctorname" size="15" /><br></label> 
   <label> password<input type="text" name="password" size="15"/><br></label> 
<label><input type="submit"value="更改"  /></label> 
</form>


</body>
</html>