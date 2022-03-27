<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@ include file="/include/header.jsp" %>
<h2>도서 검색 결과</h2>
번호 : ${book.isbn} <br>
제목 : ${book.title} <br>
저자 : ${book.author} <br>
가격 : ${book.price} <br>
설명 : ${book.desc} <br>
이미지 : ${book.img} <br>
<a href="${root}/main?action=dele&isbn=${book.isbn}">삭제</a>
</body>
</html>