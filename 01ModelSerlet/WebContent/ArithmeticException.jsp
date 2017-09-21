<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!-- jsp 오류 처리 페이지 설정 : exception 내장객체 생성 -->
<%@ page isErrorPage ="true" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h3>나눗셈 에러 처리 페이지</h3>
<hr>
<h3>에러 발생 클래스 이름 : <%= exception.getClass().getName() %></h3>
<h3>에러 메세지 : <%= exception.getMessage() %></h3>
</body>
</html>