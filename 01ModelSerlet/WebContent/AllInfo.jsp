<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@page import="model.dto.MemberDto"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<% 
	//ArrayList<MemberDto> list = (ArrayList<MemberDto>)request.getAttribute("list");
%>

<jsp:useBean id="list" class="java.util.ArrayList" scope="request" />

<table border="1">
	<tr>
		<td>���̵�</td>
		<td>�̸�</td>
		<td>�������</td>
		<td>����ó</td>
		<td>�̸���</td>
		<td>�ּ�</td>
		<td>��ȣ�ϴ� ���� �о�</td>
		
	</tr>
<%
	MemberDto dto = null;
	
	for(int i = 0 ; i < list.size(); i++) {	
		dto = (MemberDto)list.get(i);
%>
	<tr>
		<td><%= dto.getUserid() %></td>
		<td><%= dto.getUsername() %></td>
		<td><%= dto.getBirth() %></td>
		<td><%= dto.getMobile() %></td>
		<td><%= dto.getEmail() %></td>
		<td><%= dto.getAddress() %></td>
		<td><%= dto.getPreference() %></td>
	</tr>
<%
	}
%>
	
</table>
</body>
</html>