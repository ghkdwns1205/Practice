<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>JSP Board</title>
	</head>
	<body>
	<%
		session.invalidate();
	%>
		<script>
		alert('Log out 되었습니다.');
		location.href="login.jsp";
		</script>
		
	</body>
</html>