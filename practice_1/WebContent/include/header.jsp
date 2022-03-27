<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="root" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>도서 관리 </title>
<style >
	.head{
		text-align: center;
	}
	.userinfo{
		text-align: right;
	}
</style>
</head>
<body>
	<h1 class="head"><a href="${root}/index.jsp">Hello SSAFY!</a></h1>
	<div class="userinfo">
	<c:if test="${!empty userinfo}">
		<p>${userinfo.name}님 환영합니다. <a href="${root}/main?action=logout">로그아웃</a></p>
		
	</c:if>
	<c:if test="${empty userinfo}">
		<form method="post" action="${root}/main">
			<input type="hidden" name="action" value="login">
			아이디 : <input type="text" name="id" value="ssafy">
			비밀번호 : <input type="password" name="pass" value="123">
			<input type="submit" value="로그인">
		</form>
	</c:if>
	</div>
</body>
<script >
	var msg = "${msg}"
	if(msg){
		alert(msg);
	}
</script>
</html>
