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

<h3><a href="Login.jsp">�α���</a></h3>
<h3><a href="Join.jsp">ȸ������</a></h3>
<h3><a href="FindId.jsp">���̵� ã��</a></h3>
<h3><a href="FindPw.jsp">�н����� ã��</a></h3>
<h3><a href="List.jsp">������ ����</a></h3>


<!-- footer -->
<jsp:include page="sampleFooter.jsp">
	<jsp:param value="��������ó����ħ" name="footer1"/>
	<jsp:param value="�̿���" name="footer2"/>
	<jsp:param value="�̸��Ϲ��ܼ����ź�" name="footer3"/>
</jsp:include>

</body>
</html>