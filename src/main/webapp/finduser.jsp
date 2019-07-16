<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Find user</title>
</head>
<body>

	<div align="center">
		<form action="findUserByUsername.do" method="post">
				输入用户名：<input type="text" name="username"></br>
				<input type="submit" value="查询"> &nbsp;&nbsp;
				<input type="reset" value="重置">
		</form>
	</div>

</body>
</html>