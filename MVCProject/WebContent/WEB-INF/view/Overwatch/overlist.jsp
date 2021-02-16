<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix = "c" uri ="http://java.sun.com/jsp/jstl/core"%>
    <%@ taglib prefix = "fmt" uri ="http://java.sun.com/jsp/jstl/fmt" %>
    <%@ taglib prefix = "fn" uri ="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<form action = "find">
	<table>
		<tr>
			<td>이름입력<input type ="text" name = "name"  >
			</td>
			<td><input type ="submit"  value = "찾기" >
			</td>
		</tr>
	</table>
</form>
<form action = "write">
	<table>
		<tr>
			<td><input type = "button" onclick = "location.href('write')" value = "글 추가" />
			</td>
		</tr>
	</table>
</form>
<table border=1>
	<tr>
		<td>지역</td>
		<td>날짜</td>
		<td>아이디</td>
		<td>이름</td>
		<td>적</td>
		<td>멘트</td>
		
	</tr>
		<c:forEach var= "n" items = "${over}"  varStatus = "t">
		<tr>
			<td>${n.location}</td>
			<td>${n.date}</td>
			<td><a href="select?id=${n.id}">${n.id}</a></td>
			<td>${n.name}</td>
			<td>${n.enemy}</td>
			<td>${n.content}</td>
		</tr>
		</c:forEach>
	</table>
	<c:set var = "page" value = "${empty param?1:param.p}"></c:set>
	<c:set var = "startNum" value = "${page-(page-1)%5}"></c:set>
	<c:set var = "lastNum" value = "${fn:substringBefore(Math.ceil(count/7),'.')}"></c:set>
	<br>
	
	<div>
		<h3>현재 페이지</h3>
		<div><span>${(empty param.p)?1:param.p}</span>/ ${lastNum} page</div>
	</div>
	
		<c:if test="${startNum > 1}">
			<a href = "?p=${startNum-1}&t=&q=">prev</a>
		</c:if>
		<c:if test="${startNum <= 1}">
			<a href = "#" onclick="alert('첫번째 페이지입니다.');">prev</a>
		</c:if>
		
	<tr>
		<c:forEach var="i" begin="0" end="4">
		<c:if test="${param.p == (startNum+i)}">
				<c:set var= "style" value= "font-weight:bold; color:red;" />
		</c:if>
		
		<c:if test="${param.p != (startNum+i)}">
				<c:set var= "style" value= "" />
		</c:if>
		<td>　
		</td>
		<c:if test="${(startNum+i)<=lastNum}">
		<td><a style = "${style}" href="?p=${startNum+i}&f=${param.f}&q=${param.q}">${startNum+i}</a>
		</td>
		</c:if>
		</c:forEach>
		<td>　
		</td>
	</tr>
	
		<c:if test="${startNum+5 < lastNum}">
			<a href = "?p=${startNum+5}&t=&q=">next</a>
		</c:if>
		<c:if test="${startNum+5 > lastNum}">
			<a href = "#" onclick="alert('마지막 페이지입니다.');">next</a>
		</c:if>
</body>
</html>