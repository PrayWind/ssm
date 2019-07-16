<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
	<script src="./js/layer/layer.js"></script>

	
	<title>用户列表展示页</title>
	<script type="text/javascript">
		function del(id){
			confirm = confirm("确认删除？");
			if (confirm==true){
				$.ajax({
					type:"post",
					url:"delUserById.do",
					data:{id:id},
					success:function(result){
						// 样式可以，因为下面有刷新操作所以显示很短暂
						layer.msg(result).setTimeout(3000);
					}
				});
			}
			window.location = "findAllUser.do";
		}
		function update(id, username, password){
			alert("修改");
			$.ajax({
				type:"post",
				url:"updateUser.do",
				data:{id:id, username:username, password:password},
				success:function(result){
					layer.msg(result).setTimeout(3000);
				}
			});
		}
		function focusUser(id){
			$.ajax({
				type:"post",
				url:"focusUser.do",
				data:{id:id},
				success:function(result){
					// 样式可以，因为下面有刷新操作所以显示很短暂
					layer.msg(result).setTimeout(3000);
				}
			});
			window.location = "findAllUser.do";
		}
	</script>
</head>
<body> 

<p align="center">欢迎你，${user.username }</p>
	<table width="100%" border=1>
		<tr>
			<td>用户ID</td>
			<td>用户账号</td>
			<td>用户密码</td>
		</tr>
		<c:forEach items="${userList}" var="user">
			<tr>	
				<td>${user.id}</td>
				<td>${user.username}</td>
				<td>${user.password}</td>
				<td>
					<button onclick	="del(${user.id})">删除</button>
					
					<!-- 判断是否已关注,0：未关注，1：已关注 -->
					<c:set var="flag" value="0" />
					<c:forEach items="${myFocusUserId}" var="focusId" >
						<c:if test="${user.id == focusId}">
							<c:set var="flag" value="1" />
						</c:if>
					</c:forEach>
					<c:if test="${flag == 0}">
						<button onclick="focusUser(${user.id})">关注</button>
					</c:if>
					<c:if test="${flag == 1}">
						<button disabled="disabled">已关注</button>
					</c:if>

					<button onclick="window.location.href='updateuser.jsp?id=${user.id}'">修改</button>
				</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>