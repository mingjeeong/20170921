<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<!-- logo -->
<%@ include file="sampleLogo.jsp" %>

<!-- menu -->
<%@ include file="sampleMenu.jsp" %>

<!-- notice -->
<h3>공지등록</h3>
<hr>
<form action="List.jsp" >
	<table>
		<tr>
			<td>공지번호</td>
			<td><input type="text" name="noticeNo" id="noticeNo"></td>
		</tr>
		<tr>
			<td>제목</td>
			<td><input type="text" name="title" id="title"></td>
		</tr>
		<tr>
			<td>내용</td>
			<td><input type="text" name="contents" id="contents"></td>
		</tr>
	</table>
	<input type="submit" name="submit" id="submit" value="등록">
	
</form>

<!-- footer -->
<jsp:include page="sampleFooter.jsp">
	<jsp:param value="개인정보처리방침" name="footer1"/>
	<jsp:param value="이용약관" name="footer2"/>
	<jsp:param value="이메일무단수집거부" name="footer3"/>
</jsp:include>
</body>
</html>