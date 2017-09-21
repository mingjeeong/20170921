<%@page import="model.dto.MemberDto"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    
<!-- jstl ��� ȯ�漳�� -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h3>���� ����</h3><hr>
<% //MemberDto dto= (MemberDto)request.getAttribute("dto"); %>

<jsp:useBean id="dto" class="model.dto.MemberDto" scope="request" />
<table border="1">
	<tr>
		<td>���̵�</td>
		<td>
			<%= dto.getUserid() %>
			${requestScope.dto.userid}
		</td>
	</tr>
	<tr>
		<td>�̸�</td>
		<td>
			<%= dto.getUsername()  %>
			${requestScope.dto.username}
		</td>
	</tr>
	<tr>
		<td>�������</td>
		<td>
			<%= dto.getBirth() %>
			${requestScope.dto.birth}
		</td>
	</tr>
	<tr>
		<td>����ó</td>
		<td><%= dto.getMobile() %>
			${requestScope.dto.mobile}
		</td>
	</tr>
	<tr>
		<td>�̸���</td>
		<td><%= dto.getEmail() %>
			${requestScope.dto.email}
		</td>
	</tr>
	<tr>
		<td>�ּ�</td>
		<td><%= dto.getAddress() %>
			${requestScope.MyInfo.address}
		</td>
	</tr>
	<tr>
		<td>��ȣ�ϴ� ���� �о�</td>
		<td><%= dto.getPreference() %>
			${requestScope.MyInfo.preference}
		</td>
	</tr>
</table>

</body>
</html>