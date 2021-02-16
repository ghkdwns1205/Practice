<%@page import="com.jdbc.app.entity.Overwatch"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table border =1>
		<tr>
			<td>아이디</td>
			<td>비밀번호</td>
			<td>이름</td>
			<td>이메일</td>
			<td>flag</td>
		<tr>
		<tr>
			<td>${find.id}</td>
			<td>${find.pass}</td>
			<td>${find.name1}</td>
			<td>${find.email}</td>
			<td>${find.flag}</td>
		</tr>
	</table>
</body>
</html>