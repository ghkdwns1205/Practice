<%@page import="com.jdbc.app.entity.Notice"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>0
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table border=1>
	
		<% Notice nts =(Notice)request.getAttribute("nts"); 
		
		pageContext.setAttribute("n",nts);
			%>
		<tr>
			<td>${n.id}</td>
			<td>${n.title}</td>
			<td>${n.content}</td>
			<td>${n.writerId}</td>
			<td>${n.regDate}</td>
			
		</tr>
	</table>
</body>
</html>