<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
    String id = request.getParameter("id");//用request得到
    request.setAttribute("id", id);
%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update user</title>
</head>
<body>

	<div align="center">
		<body>
			<form action="updateUser.do" method="post">
				用户id：<input id="id" type="text" name="id" value="<%=id %>" readonly="readonly"> </br>
				账号：<input id="username" type="text" name="username"></br>
				密码：<input id="password" type="text" name="password"></br>
				<input type="submit" value="修改" > &nbsp;&nbsp;
				<input type="reset" value="重置">
			</form>
		</body>
	</div>

</body>
</html>