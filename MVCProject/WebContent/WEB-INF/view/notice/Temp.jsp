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
	<form method = "get" action = "templist">
		<table>
			<tr>
				<td><label for = "date">날짜</label>
				</td>
				<td><input id = "date" type = "text" name = "date">
				</td>
			</tr>
			<tr>
				<td><label for = "locid">지역번호</label>
				</td>
				<td><input id = "locid" type = "text" name = "locid">
				</td>
			</tr>
		</table>
		<input type = "submit" value = "입력">
	</form>
</body>
</html>