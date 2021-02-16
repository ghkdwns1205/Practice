<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri ="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div>
	추가 가능 지역 선택
</div>
	<table border=1>
		<tr>
			<c:forEach var= "n" items = "${list}" >
		
				<td>
					<input type="checkbox" name = "add" value= "${n.location}" />${n.location}
				</td>
			</c:forEach>
		</tr>
		<tr>
			<td>
	
	
	</table>
	

</body>
</html>