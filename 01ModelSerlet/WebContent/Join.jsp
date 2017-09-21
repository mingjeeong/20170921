<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<script type="text/javascript">
		
	/* 페이지 초기화 함수*/
	function init() {
		document.joinform.username.focus();
	}
	
	/*아이디 필수 입력항목 검증 함수
		아이디 입력 문자열 : String
		문자열 길이: length(속성)
		필수입력여부
		최소길이 검증
		경고창 메세지 출력후에 잘못입력한 아이디 항목으로 포커스 이동
		
	 */
	function checkuserid(takeElement, takeData) {
		
		var useridElement = document.joinform.userid;
		var useridElement2 = document.getElementById("userid");

		var length = takeData.trim().length;
		var userid = takeElement.value;
		var message = "";

		if (length < 6) {
			message = "id 6자리 이상 입력해주세요";
			alert(message);
			userid.focus();
		} else if (length == 0) {
			alert("필수입력 항목입니다.");
			document.joinform.userid.focus();
		}
	}

	function checkuserpw() {
		var userpwElement = document.getElementById("userpw");
		var userpw2Element = document.getElementById("userpw2");
		
		if (userpwElement.value != userpw2Element.value) {
			alert("비밀번호가 동일하지 않습니다. 다시 확인해주세요");
			userpwElement.focus();
		}
	}
	
	function showPw() {
		if (joinform.isDisplayOn.checked) {
			joinform.userpw.type = "text";
			joinform.userpwConfirm.type = "text";
		} else {
			joinform.userpw.type = "password";
			joinform.userpwConfirm.type = "password";
		}
	}

	function setreadonly() {
		joinform.email2.readonly = false;
	}
	
	function selectEmail(email) {
		if (joinform.email1.value.trim().length == 0) {
			alert("이메일을 입력해주세요");
			document.joinform.email1.focus();
			console.log(email);
			console.log(email.options[0].values);
			joinform.emailSelected.value = email.options[0].value;
		} else if (email.value == "직접 입력") {
			joinform.email2.value = "";
			document.joinform.email2.readOnly = false;
			joinform.email2.style.background = "#ffffff";
		} else {
			joinform.email2.value = email.value;
			document.joinform.email2.readOnly = true;
		}
	}

	function mobilenext() {
	}

	
	
	/*아이디중복확인 함수
	클릭하면 페이지 열기 :isId.html
	부모창에서 입력한 아이디정보를 자식창의 아이디정보로 초기화 설정
	 */
	function openisid() {
		var url = 'CheckId.jsp';
		var winName = 'idCheck';
		var winConfig = 'top=100,left=100,height=160,width=520,resizable=no,scrollbar=no';
		var childWin = window.open(url, winName, winConfig);

		//부모창에 입력한 아이디 가지고 오기
		var userid = document.getElementById("userid").value.trim();

		//자식창의 아이디로 초기값 설정
		//childWin.document.isId.checkuserid=userid.value;

	}

	
	window.onload = function() {
		init();
	}

	//함수호출
	//printInfo();
</script>
<noscript>자바스크립트가 정상 구동되지 않습니다</noscript>
</head>
<body>
	<h3>회원가입</h3>
	<hr>
	>모든 항목은
	<u><b>필수 입력</b></u>입니다. 정확히 입력하시면 더욱 편리하게 이용하실 수 있습니다.
	<br>
	<br>
	
	<form name="joinform" action="controller" method="post">
	<table border="1" class="jointable" align="center">
		<tr>
			<th class="thcolor">이름</th>
			<td><input type="text" name="username" id="username"
				size="20" maxlength="20"></td>
		</tr>
		<tr>
			<th class="thcolor">생년월일</th>
			<td><input  type ="text" name="birthYear" id="birthYear">
				
			년 <select name="birthMonth" id="birthMonth"><option value="선택">선택</option>
					<option value="1">01</option>
					<option value="2">02</option>
					<option value="3">03</option>
					<option value="4">04</option>
					<option value="5">05</option>
					<option value="6">06</option>
					<option value="7">07</option>
					<option value="8">08</option>
					<option value="9">09</option>
					<option value="10">10</option>
					<option value="11">11</option>
					<option value="12">12</option>
			</select>월 <select name="birthDate" id="birthDate"><option value="선택">선택</option>
					<option value="1">01</option>
					<option value="2">02</option>
					<option value="3">03</option>
					<option value="4">04</option>
					<option value="5">05</option>
					<option value="6">06</option>
					<option value="7">07</option>
					<option value="8">08</option>
					<option value="9">09</option>
					<option value="10">10</option>
					<option value="11">11</option>
					<option value="12">12</option>
					<option value="13">13</option>
					<option value="14">14</option>
					<option value="15">15</option>
					<option value="16">16</option>
					<option value="17">17</option>
					<option value="18">18</option>
					<option value="19">19</option>
					<option value="20">20</option>
					<option value="21">21</option>
					<option value="22">22</option>
					<option value="23">23</option>
					<option value="24">24</option>
					<option value="25">25</option>
					<option value="26">26</option>
					<option value="27">27</option>
					<option value="28">28</option>
					<option value="29">29</option>
					<option value="30">30</option>
					<option value="31">31</option>
			</select>일  
		</td>
	</tr>
	<tr>
		<th class="thcolor">아이디</th>
		<td><input type="text" name="userid" id="userid" size=20 maxlength="20" onblur="checkuserid(this,this.value)" >
			<input type="button" name="checkId" id="checkId" value="중복확인" onclick="openisid()">
			
		</td>
	</tr>
	<tr>
		<th class="thcolor">비밀번호</th>
		<td><input type="password" name="userpw" id="userpw" size=20 maxlength="20">
			<span class="checkpw">*10~20자리 입력해 주세요</<span>
		</td>
	</tr>
	<tr>
		<th class="thcolor">비밀번호 확인</th>
		<td><input type="password" name="userpw2" id="userpw2" size=20 maxlength="20" onblur="checkuserpw()" >
			<span class="checkpw">*위의 비밀번호를 한번 더 입력해 주세요</<span>
		</td>
	</tr>
	
	<tr>
		<th class="thcolor">이메일</th>
		<td><input type="text" name="email1" id="email1" size=10 maxlength="20">@
			<input type="text" name="email2" id="email2" size=10 maxlength="20">
			<select name="email3" id="email3" onchange="selectEmail(this)" >
					<option value="직접입력">직접입력</option>
					<option value="naver.com">naver.com</option>
					<option value="nate.com">nate.com</option>
					<option value="hanmail.net">hanmail.net</option>
					<option value="daum.com">daum.com</option>
					<option value="gamil.com">gamil.com</option>
			</select></td>
		</tr>
		<tr>
			<th class="thcolor">주소</th>
			<td><input type="text" name="address" id="address" size=100
				maxlength="100"></td>
		</tr>
		<tr>
			<th class="thcolor">연락처</th>
			<td><select name="mobile1" id="mobile1">
					<option value="선택">선택</option>
					<option value="010">010</option>
					<option value="011">011</option>
					<option value="019">019</option>
			</select>- <input type="text" name="mobile2" id="mobile2" maxlength="4">- <input
				type="text" name="mobile3" id="mobile3" maxlength="4"></td>
		</tr>
		<tr>
			<th class="thcolor">선호하는 도서 분야</th>
			<td><input type="text" name="preference" id="preference" size=100
				maxlength="100"></td>
		</tr>
	</table>
	
	<div align="center" margin="10px">
			<input type="hidden" name="action" value="join">
			<input type="submit" name="submit" id="submit" value="확인">
			<input type="reset" name="cancel" id="cancel" value="취소">
	</div>
	</form>
</body>
</html>