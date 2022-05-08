<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="insert-servlet"method="post">
  <label>健身房名称<input type="text" name="title" size="15" /><br></label> 
   <label> 地址<input type="text" name="address" size="15"/><br></label> 
   <label> 价格<input type="text" name="price" size="15" /><br></label> 
 <label> 评分<input type="text" name="score" size="15" /><br></label> 
 <label> 距离<input type="text" name="distance" size="15" /><br></label> 
 <label> 图片<input type="text" name="img" size="15" /><br></label> 
    <label><input type="submit" value="添加健身房" /> </label>
</form>
</body>
</html>