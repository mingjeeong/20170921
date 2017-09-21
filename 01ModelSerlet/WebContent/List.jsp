<%@page import="java.util.ArrayList"%>
<%@page import="work.notice.Notice"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<!-- 초기화 메서드 재정의 -->

<%!
	public ArrayList<Notice> list = new ArrayList();
	

	//초기화공지 3개만 생성해서 list에 추가
	public void jspInit(){
		list.add(new Notice(1,"1","1"));
		list.add(new Notice(2,"2","2"));
		list.add(new Notice(3,"3","3"));
		
		System.out.println("공지내용");
		for(int i = 0 ; i < list.size(); i++){
			System.out.println(list.get(i));
		}
		
	}
	public void jspDestroy(){
		System.out.println("3.자원해제 수행");
	}
%>

<!-- logo -->
<%@ include file="sampleLogo.jsp" %>

<!-- menu -->
<%@ include file="sampleMenu.jsp" %>

<!-- contents -->
<!-- new instance -->
	<jsp:useBean id="dto" class="work.notice.Notice" scope="page" />
	
<!-- set property -->
	<jsp:setProperty name="dto" property="*" />
	
<!-- collection 공지등록 추가 -->
<%
	list.add(dto);

%>

<%
/*
	Notice dto = new Notice();

	int noticeNo = Integer.parseInt(request.getParameter("noticeNo"));
	String title = request.getParameter("title");
	String contents = request.getParameter("contents");
	
	dto.setNoticeNo(noticeNo);
	dto.setTitle(title);
	dto.setContents(contents);
	
	list.add(dto);
	*/
%>
<h3>전체공지 보기</h3><hr>
<table border="1" width="500px">
	<tr>
		<th>번호</th>
		<th>제목</th>
		<th>내용</th>
	</tr>
<%
	Notice dto2 = null;
	for(int i = 0 ; i < list.size(); i++){	
		dto2=list.get(i);
%>
	<tr>
		<td><%= dto2.getNoticeNo() %></td>
		<td><%= dto2.getTitle() %></td>
		<td><%= dto2.getContents() %></td>
	</tr>
<%
	}
%>
</table>
<!-- footer -->
<jsp:include page="sampleFooter.jsp">
	<jsp:param value="개인정보처리방침" name="footer1"/>
	<jsp:param value="이용약관" name="footer2"/>
	<jsp:param value="이메일무단수집거부" name="footer3"/>
</jsp:include>
</body>
</html>