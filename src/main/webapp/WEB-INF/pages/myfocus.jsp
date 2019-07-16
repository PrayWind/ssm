<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
	<script src="./js/layer/layer.js"></script>

	<title>我的关注展示页</title>
	<script type="text/javascript">
		function delFocus(id){
			confirm = confirm("确定取消关注该用户？");
			if (confirm==true){
				$.ajax({
					type:"post",
					url:"delFocusUser.do",
					data:{id:id},
					success:function(result){
						layer.msg(result).setTimeout(3000);
					}
				});
			} 
			window.location.href="showMyFocus.do";
		}
	</script>

</head>
<body> 

<p align="center">欢迎你，${user.username }</p> <br><br>
	<table width="100%" border=1>
		<tr>
			<td>用户ID</td>
			<td>用户名</td>
			<td>用户密码</td>
		</tr>
		<c:forEach items="${focusUserDetail}" var="focusUser">
			<tr>	
				<td>${focusUser.id}</td>
				<td>${focusUser.username}</td>
				<td>${focusUser.password}</td>
				<td><button onclick="delFocus(${focusUser.id})">取消关注</button></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>