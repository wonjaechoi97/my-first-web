<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	table{
		border-collapse: collapse;
		width: 100%;
	}
	td,th{
	 border:1px solid black;
	}
	
</style>
</head>
<body>
<%@ include file="/include/header.jsp" %>
<h1>도서 조회 결과</h1>
<form method="post" action="${root}/main">
<input type="hidden" name="action" value="delm">
<c:if test="${!empty books}">
<table>
<tr><th>번호</th><th>ISBN</th><th>제목</th><th>저자</th><th>가격</th><th>설명</th><th>이미지</th><th>삭제</th></tr>
	<c:forEach items="${books}" var="book" varStatus="vs">
		
		<tr><td>${vs.count}</td>
		<td>${book.isbn}</td>
		<td><a href="${root}/main?action=view&isbn=${book.isbn}">${book.title}</a></td>
		<td>${book.author}</td>
		<td>${book.price}</td>
		<td>${book.desc}</td>
		<td>${book.img}</td>
		<td><input type="checkbox" name="isbns" value="${book.isbn}"></td></tr>
	</c:forEach>
	
</table>
<input type="submit" value="삭제">
<input type="reset" value="취소">
</c:if>
</form>


</body>
</html>