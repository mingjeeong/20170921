<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h3>���̵� ã��</h3><hr>
<form method="post" action="controller">
	<table>
		<tr>
			<th>�̸�</th>
			<td><input type="text" name="username" id="username" size="20" maxlength="20"></td>
		</tr>
		<tr>
			<th>�޴��� ��ȣ</th>
			<td><input type="text" name="mobile" id="mobile" size="20" maxlength="20"></td>
		</tr>
	</table>
	<input type="hidden" name="action" value="findid">
	<input type="submit" name="submit" id="submit" value="Ȯ��">
	<input type="reset" name="submit" id="submit" value="���">
</form>
</body>
</html>