<%@page import="com.jdbc.app.entity.Temp"%>
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
			<td>날짜</td>
			<td>온도</td>
			<td>지역</td>
			<td>작성자</td>
		<tr>
		<tr>
			<td>${tp.date}</td>
			<td>${tp.temp}</td>
			<td>${tp.locid}</td>
			<td>${tp.writer}</td>
		</tr>
	</table>
</body>
</html>