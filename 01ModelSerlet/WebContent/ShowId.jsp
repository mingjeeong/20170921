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
<input type="button" name="gologin" id="gologin" value="�α��� �Ϸ�����" onclick="location='Login.jsp'">
<input type="button" name="findpw" id="findpw" value="��й�ȣ ã��" onclick="location='FindPw.jsp'">
</body>
</html>