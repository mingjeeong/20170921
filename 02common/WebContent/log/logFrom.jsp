<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<script type="text/javascript">

	
	function loginchk(){
		 var regx = /^[a-zA-Z0-9]*$/;
		 var id = document.form.id.value;
		 var pass = document.form.pass.value;
		 if (id.length == 0 || id == null) {
		  alert("아이디를 입력하시오");
		  document.form.id.focus();
		  return;
		 }
		 if (!regx.test(id)){
		  alert("아이디는 영어, 숫자만 입력가능합니다.");
		  document.form.id.focus();
		  return false;
		 }
		 if (pass.length < 6 || pass == null) {
		  alert("비밀번호는 6글자이상입니다^^");
		  document.form.pass.focus();
		  return;
		 }
		 document.form.submit();
		}


</script>
<style type="text/css">
b {
	font-size: '13px';
	font-family: '돋움';
	color: #000000;
}

.inputid {
	font-size: 13px;
	width: 80px;
	height: 15px;
	border-color: green;
	border-width: 5px;
}

.inputpass {
	font-size: 13px;
	width: 120px;
	height: 15px;
	border-color: green;
	border-width: 5px;
}
hr{
 border-color: green;
 border-width: 5px;
}

</style>
<title> 로그인 </title>
</head>
<body>
<p align="right">
<form action="log/loginProc.jsp" method="post" name="form">
	<b>아이디 :</b> <input type="text" size="10" maxlength="15" name="id" class="inputid">&nbsp;
	<b>비밀번호 :</b> <input type="password" size="10" maxlength="15" name="pass" class="inputpass">&nbsp;
	<img src="log/image/loginbutton.png" width="50" height="30" align="middle" onclick="loginchk()">

</form>
<hr width="100%">
</body>
</html>