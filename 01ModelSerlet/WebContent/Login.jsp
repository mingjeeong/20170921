<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h3>�α���</h3>
<form action="controller" method="post" >
	���̵�<input type="text" name="userid" id="userid" maxlength="20" >
	��й�ȣ<input type="password" name="userpw" id="userpw" maxlength="20">
	<input type="hidden" name="action" value="login">
	<input type="submit" value="�α���">
	<input type="reset" value="�ʱ�ȭ">
</form>
</body>
</html>