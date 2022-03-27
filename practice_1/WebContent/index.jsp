<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>index</title>
</head>
<body>
<%@ include file="/include/header.jsp" %>
<h1>메뉴</h1>
<ul>
	<li><a href="${root}/main?action=regist_form">도서 등록</a>
	<li><a href="${root}/main?action=list">도서 목록</a>
	<li><a href="${root}/main?action=endbook">마지막 등록 도서</a>
</ul>
</body>
</html>