<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%
 request.setAttribute("top", "/log/loginForm.jsp");
 request.setAttribute("left", "/left.jsp");
 request.setAttribute("right", "/right.jsp");
 request.setAttribute("bottom", "/bottom.jsp");
%>
<jsp:forward page="/template.jsp" />


