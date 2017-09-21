<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<script  type="text/javascript">

	var memberIds = new Array("user01","user02","user03");

	window.onload = function() {
		console.log(window.opener.document.getElementById('userid').value);
		document.getElementById('checkMemberId').value=window.opener.document.getElementById('userid').value;
	}
	
	function useId2() {
		console.log("ddd");
		//checkMemberId 이게 아이디인 객체를 어떻게 표현할래
		console.log(document.getElementById('checkMemberId').value);
		window.opener.document.getElementById('userid').value=document.getElementById('checkMemberId').value;
		window.opener.document.getElementById('userid').readOnly=true;
		window.close();
	}
	
	function checkid() {
		for(index=0 ; index<memberIds.length ; index++){
			if(document.getElementById('checkMemberId').value == memberIds[index]){
				//alert('중복된 아이디가 있음');
				document.getElementById('useId').disabled = true;
				document.getElementById('text').innerHTML="중복된 아이디가 있음";
				
				break;
			}
			else{
				//alert('중복된 아이디가 없음 사용가능');
				document.getElementById('useId').disabled = false;
				document.getElementById('text').innerHTML="중복된 아이디가 없음 사용가능";
			}
		}
	}
	function checkkeyup() {
		//console.log("키가쳐지고있어...");
		document.getElementById('useId').disabled = true;

	}
</script>
</head>
<body>
<h3>아이디 중복확인</h3>
<form name="checkid" id="checkid">
	<input type="text" id="checkMemberId" name="checkMemberId" onkeyup="checkkeyup()" >
	<input type="button" value="중복확인" onclick="checkid()" >
	<input type="button" value="사용하기" id="useId" name="useId" onclick="useId2()" maxlength="20" disabled>
	<input type="button" value="창닫기" onclick="window.close()">
	<span id="text"></span>

</form>

<span></span>
</body>
</html>