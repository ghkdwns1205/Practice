<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<a href = "admin/board/notice/list">공지사항관리</a><br>
	<a href = "notice/list">공지사항</a><br>
	
</body>
</html>

<!-- String sql = "Select * "
				   + "from (Select @rownum:=@rownum+1 as num, n.* "
				   + "	       from(select * "
				   + "				  From notice "
				   + "				 where pubflag = 'Y' "
				   + "				   and	"+field+" like ? "
				   + "			     order by regdate desc)n, "
				   + "			   (select @rownum:=0)v)num "
				   + " Where num.id between ? and ? ";    슨생님이 테스트한것 -->