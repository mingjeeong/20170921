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
����� ���̵� : <%= session.getAttribute("userid") %><br>
����� �̸� : <%= session.getAttribute("username") %>

<h3><a href="List.jsp">������ ����</a></h3>
<h3><a href="controller?action=allinfo">ȸ�� ��ü ����</a></h3>
<h3><a href="controller?action=myinfo">�� ���� ����</a></h3>
<h3><a href="controller?action=updateinfo">�� ���� ����</a></h3>
<h3><a href="controller?action=updateinfo">��й�ȣ ����</a></h3>
<h3><a href="controller?action=logout">�α׾ƿ�</a></h3>



</body>
</html>