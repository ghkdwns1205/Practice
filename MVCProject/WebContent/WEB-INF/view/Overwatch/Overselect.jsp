<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix = "c" uri ="http://java.sun.com/jsp/jstl/core"%>
    <%@ taglib prefix = "fmt" uri ="http://java.sun.com/jsp/jstl/fmt"%>
    <%@ taglib prefix = "fn" uri ="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script type="text/javascript">

  function checkYN(){
	let fm = document.check;
	fm.action = "select";
	fm.method = "post";
	let yn = confirm("정말로 삭제하시겠습니까?");
	console.log(yn);
	if(yn==true){
		fm.submit();
		document.getElementById("a").submit();
	}else{
		
	}
}
</script>

</head>
<body>
<form name = "check">
${id}

<table border = 1>
	<tr>
		<td>지역</td>
		<td>날짜</td>
		<td>아이디</td>
		<td>이름</td>
		<td>적</td>
		<td>멘트</td>
		<td>선택</td>
	</tr>
	
	<c:forEach var= "n" items = "${id}"  varStatus = "t">
	<tr>
		<td>${n.location}</td>
		<td>${n.date}</td>
		<td>${n.id}</td>
		<td>${n.name}</td>
		<td>${n.enemy}</td>
		<td>${n.content}</td>
		<td><input type= "checkbox" name = "c" value= "${n.seq}"></td>
	
		

	</tr>
	</c:forEach>

</table>
<br>
선택한 목록
<br>
	<input type = "button"  value = "수정" />
	<input type = "button" onclick="checkYN()" value = "삭제" />
	
</form>
	<form id="a" action="select" method="get">
	<c:forEach var= "n" items = "${id}"  varStatus = "t">
		<input type="hidden" name = "id" value="${n.id}">
		</c:forEach>
</form>

</body>
</html>