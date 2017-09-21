<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<%= request.getAttribute("successMessage") %><br>
사용자 아이디 : <%= session.getAttribute("userid") %><br>
사용자 이름 : <%= session.getAttribute("username") %>

<h3><a href="List.jsp">공지글 보기</a></h3>
<h3><a href="controller?action=allinfo">회원 전체 보기</a></h3>
<h3><a href="controller?action=myinfo">내 정보 보기</a></h3>
<h3><a href="controller?action=updateinfo">내 정보 변경</a></h3>
<h3><a href="controller?action=updateinfo">비밀번호 변경</a></h3>
<h3><a href="controller?action=logout">로그아웃</a></h3>



</body>
</html>