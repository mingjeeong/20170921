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
<h3>EL (Expression Language)</h3>
\${5*3}=${5*3}<br>
${pageContext.request.requestURI}<br>
Msg : ${param.msg}<br>
Msg : ${empty param}<br>
Msg : ${!empty param}<br>
Cookie : ${cookie}<br>
Cookie : ${cookie.JSESSIONID}

<c:set var="msg" value="Hello JSTL" />
<c:out value="${msg}" />
<c:remove var="msg" />

<c:if test="${!empty param.name}">
	이름: ${param.name}<br>
</c:if>

<c:if test="${empty param.name}">
	이름: Guest(손님)<br>
</c:if>
			
<!-- 1-10까지 반복 출력하고 전체 덧셈 결과 출력 -->
<c:forEach var="no" begin="1" end="10" step="1">
	<c:set var="sum" value="${sum=sum+no}" />
	<c:out value="${no}" />
</c:forEach>			
합계 : <c:out value="${sum}" />
</body>
</html>