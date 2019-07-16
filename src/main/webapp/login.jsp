<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
	<script src="./js/layer/layer.js"></script>
	
	<title>Login</title>
	<script type="text/javascript">
		function login() {
			//查看是否取到账号和密码
			var un = $("#username").val();
			var pw = $("#password").val();
			if(un=="" || un==null || pw=="" || pw==null){
				alert("请输入账号或密码!");
			} else {
				return true;
			}
		}
	</script>
</head>

<div align="center">
	<body>
		<form id="myForm" action="login.do" method="post">
			账号：<input id="username" type="text" name="username"></br>
			密码：<input id="password" type="password" name="password"></br>
			<input type="submit" value="登录" onclick="login()"> &nbsp;&nbsp;
			<input type="reset" value="重置">
		</form>
	</body>
</div>

</html>