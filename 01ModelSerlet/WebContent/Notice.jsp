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
<h3>�������</h3>
<hr>
<form action="List.jsp" >
	<table>
		<tr>
			<td>������ȣ</td>
			<td><input type="text" name="noticeNo" id="noticeNo"></td>
		</tr>
		<tr>
			<td>����</td>
			<td><input type="text" name="title" id="title"></td>
		</tr>
		<tr>
			<td>����</td>
			<td><input type="text" name="contents" id="contents"></td>
		</tr>
	</table>
	<input type="submit" name="submit" id="submit" value="���">
	
</form>

<!-- footer -->
<jsp:include page="sampleFooter.jsp">
	<jsp:param value="��������ó����ħ" name="footer1"/>
	<jsp:param value="�̿���" name="footer2"/>
	<jsp:param value="�̸��Ϲ��ܼ����ź�" name="footer3"/>
</jsp:include>
</body>
</html>