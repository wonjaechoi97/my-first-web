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
<h1>도서 등록</h1>
<form method="post" action="${root}/main">
<fieldset>
	<input type="hidden" name="action" value="regist">
	<label for="isbn"> 번호 : </label>  <input type="text" name="isbn" value="123" ><br>
	<label for="title"> 제목 : </label>  <input type="text" name="title" value="자바 프로그래밍" ><br>
	<label for="author"> 저자 : </label>  <input type="text" name="author" value="안효인" ><br>
	<label for="price"> 가격 : </label>  <input type="text" name="price" value="25000" ><br>
	<label for="desc"> 설명 : </label> <textarea name="desc" >자바 프로그래밍  설명</textarea> <br>
	<label for="img"> 이미지 : </label>  <input type="text" name="img" value="img.jpg" ><br>
	<input type="submit" value="등록">
	<input type="reset" value="취소">
</fieldset>

</form>

</body>
</html>