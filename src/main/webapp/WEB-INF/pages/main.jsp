<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Main</title>
</head>
<body>

	<div align="center">
		欢迎你，${user.username } <br><br>
		
		<a href="adduser.jsp">添加用户</a> <br>
		<a href="findAllUser.do">显示所有用户</a> <br>
		<a href="finduser.jsp">查询用户</a> <br>
		<a href="showMyFocus.do">我的关注</a> <br>
		<br><br><br>
		
	</div>
	
</body>
</html>