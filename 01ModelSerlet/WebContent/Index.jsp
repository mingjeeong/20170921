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

<h3><a href="Login.jsp">로그인</a></h3>
<h3><a href="Join.jsp">회원가입</a></h3>
<h3><a href="FindId.jsp">아이디 찾기</a></h3>
<h3><a href="FindPw.jsp">패스워드 찾기</a></h3>
<h3><a href="List.jsp">공지글 보기</a></h3>


<!-- footer -->
<jsp:include page="sampleFooter.jsp">
	<jsp:param value="개인정보처리방침" name="footer1"/>
	<jsp:param value="이용약관" name="footer2"/>
	<jsp:param value="이메일무단수집거부" name="footer3"/>
</jsp:include>

</body>
</html>