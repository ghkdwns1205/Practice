<%@page import="com.jdbc.app.entity.User"%>
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
			<td>seq</td>
			<td>아이디</td>
			<td>이름</td>
			<td>이메일</td>
			<td>번호</td>
			<td>날짜</td>
			<td>flag</td>
		<tr>
		<tr>
			<td>${user.seq}</td>
			<td>${user.id}</td>
			<td>${user.name}</td>
			<td>${user.email}</td>
			<td>${user.hp}</td>
			<td>${user.regdate}</td>
			<td>${user.flag}</td>
		</tr>
	</table>
</body>
</html>