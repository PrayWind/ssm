<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add user</title>
</head>
<body>

	<div align="center">
		<form action="addUser.do" method="post">
				用户名：<input type="text" name="username"></br>
				密&nbsp&nbsp&nbsp码：<input type="password" name="password"></br>
				<input type="submit" value="添加用户"> &nbsp;&nbsp;
				<input type="reset" value="重置">
		</form>
	</div>

</body>
</html>