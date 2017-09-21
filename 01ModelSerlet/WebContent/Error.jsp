<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    
<!-- jstl 사용 환경설정 -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>

<c:if test="${!empty requestScope.errorMessage }">
	<%= request.getAttribute("errorMessage")  %>
	${requestScope.errorMessage }
</c:if>
<c:if test="${empty requestScope.errorMessage }">
	<img src="images/flower_image01">
	
</c:if>

<c:choose>
	<c:when test="${!empty requestScope.errorMessage }">
		${requestScope.errorMessage }
	</c:when>
	<c:otherwise>
		<img src="images/flower_image01">
	</c:otherwise>
</c:choose>





</body>
</html>