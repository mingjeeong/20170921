<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<script type="text/javascript">
		
	/* ������ �ʱ�ȭ �Լ�*/
	function init() {
		document.joinform.username.focus();
	}
	
	/*���̵� �ʼ� �Է��׸� ���� �Լ�
		���̵� �Է� ���ڿ� : String
		���ڿ� ����: length(�Ӽ�)
		�ʼ��Է¿���
		�ּұ��� ����
		���â �޼��� ����Ŀ� �߸��Է��� ���̵� �׸����� ��Ŀ�� �̵�
		
	 */
	function checkuserid(takeElement, takeData) {
		
		var useridElement = document.joinform.userid;
		var useridElement2 = document.getElementById("userid");

		var length = takeData.trim().length;
		var userid = takeElement.value;
		var message = "";

		if (length < 6) {
			message = "id 6�ڸ� �̻� �Է����ּ���";
			alert(message);
			userid.focus();
		} else if (length == 0) {
			alert("�ʼ��Է� �׸��Դϴ�.");
			document.joinform.userid.focus();
		}
	}

	function checkuserpw() {
		var userpwElement = document.getElementById("userpw");
		var userpw2Element = document.getElementById("userpw2");
		
		if (userpwElement.value != userpw2Element.value) {
			alert("��й�ȣ�� �������� �ʽ��ϴ�. �ٽ� Ȯ�����ּ���");
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
			alert("�̸����� �Է����ּ���");
			document.joinform.email1.focus();
			console.log(email);
			console.log(email.options[0].values);
			joinform.emailSelected.value = email.options[0].value;
		} else if (email.value == "���� �Է�") {
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

	
	
	/*���̵��ߺ�Ȯ�� �Լ�
	Ŭ���ϸ� ������ ���� :isId.html
	�θ�â���� �Է��� ���̵������� �ڽ�â�� ���̵������� �ʱ�ȭ ����
	 */
	function openisid() {
		var url = 'CheckId.jsp';
		var winName = 'idCheck';
		var winConfig = 'top=100,left=100,height=160,width=520,resizable=no,scrollbar=no';
		var childWin = window.open(url, winName, winConfig);

		//�θ�â�� �Է��� ���̵� ������ ����
		var userid = document.getElementById("userid").value.trim();

		//�ڽ�â�� ���̵�� �ʱⰪ ����
		//childWin.document.isId.checkuserid=userid.value;

	}

	
	window.onload = function() {
		init();
	}

	//�Լ�ȣ��
	//printInfo();
</script>
<noscript>�ڹٽ�ũ��Ʈ�� ���� �������� �ʽ��ϴ�</noscript>
</head>
<body>
	<h3>ȸ������</h3>
	<hr>
	>��� �׸���
	<u><b>�ʼ� �Է�</b></u>�Դϴ�. ��Ȯ�� �Է��Ͻø� ���� ���ϰ� �̿��Ͻ� �� �ֽ��ϴ�.
	<br>
	<br>
	
	<form name="joinform" action="controller" method="post">
	<table border="1" class="jointable" align="center">
		<tr>
			<th class="thcolor">�̸�</th>
			<td><input type="text" name="username" id="username"
				size="20" maxlength="20"></td>
		</tr>
		<tr>
			<th class="thcolor">�������</th>
			<td><input  type ="text" name="birthYear" id="birthYear">
				
			�� <select name="birthMonth" id="birthMonth"><option value="����">����</option>
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
			</select>�� <select name="birthDate" id="birthDate"><option value="����">����</option>
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
			</select>��  
		</td>
	</tr>
	<tr>
		<th class="thcolor">���̵�</th>
		<td><input type="text" name="userid" id="userid" size=20 maxlength="20" onblur="checkuserid(this,this.value)" >
			<input type="button" name="checkId" id="checkId" value="�ߺ�Ȯ��" onclick="openisid()">
			
		</td>
	</tr>
	<tr>
		<th class="thcolor">��й�ȣ</th>
		<td><input type="password" name="userpw" id="userpw" size=20 maxlength="20">
			<span class="checkpw">*10~20�ڸ� �Է��� �ּ���</<span>
		</td>
	</tr>
	<tr>
		<th class="thcolor">��й�ȣ Ȯ��</th>
		<td><input type="password" name="userpw2" id="userpw2" size=20 maxlength="20" onblur="checkuserpw()" >
			<span class="checkpw">*���� ��й�ȣ�� �ѹ� �� �Է��� �ּ���</<span>
		</td>
	</tr>
	
	<tr>
		<th class="thcolor">�̸���</th>
		<td><input type="text" name="email1" id="email1" size=10 maxlength="20">@
			<input type="text" name="email2" id="email2" size=10 maxlength="20">
			<select name="email3" id="email3" onchange="selectEmail(this)" >
					<option value="�����Է�">�����Է�</option>
					<option value="naver.com">naver.com</option>
					<option value="nate.com">nate.com</option>
					<option value="hanmail.net">hanmail.net</option>
					<option value="daum.com">daum.com</option>
					<option value="gamil.com">gamil.com</option>
			</select></td>
		</tr>
		<tr>
			<th class="thcolor">�ּ�</th>
			<td><input type="text" name="address" id="address" size=100
				maxlength="100"></td>
		</tr>
		<tr>
			<th class="thcolor">����ó</th>
			<td><select name="mobile1" id="mobile1">
					<option value="����">����</option>
					<option value="010">010</option>
					<option value="011">011</option>
					<option value="019">019</option>
			</select>- <input type="text" name="mobile2" id="mobile2" maxlength="4">- <input
				type="text" name="mobile3" id="mobile3" maxlength="4"></td>
		</tr>
		<tr>
			<th class="thcolor">��ȣ�ϴ� ���� �о�</th>
			<td><input type="text" name="preference" id="preference" size=100
				maxlength="100"></td>
		</tr>
	</table>
	
	<div align="center" margin="10px">
			<input type="hidden" name="action" value="join">
			<input type="submit" name="submit" id="submit" value="Ȯ��">
			<input type="reset" name="cancel" id="cancel" value="���">
	</div>
	</form>
</body>
</html>