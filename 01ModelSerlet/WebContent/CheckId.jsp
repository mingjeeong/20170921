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
		//checkMemberId �̰� ���̵��� ��ü�� ��� ǥ���ҷ�
		console.log(document.getElementById('checkMemberId').value);
		window.opener.document.getElementById('userid').value=document.getElementById('checkMemberId').value;
		window.opener.document.getElementById('userid').readOnly=true;
		window.close();
	}
	
	function checkid() {
		for(index=0 ; index<memberIds.length ; index++){
			if(document.getElementById('checkMemberId').value == memberIds[index]){
				//alert('�ߺ��� ���̵� ����');
				document.getElementById('useId').disabled = true;
				document.getElementById('text').innerHTML="�ߺ��� ���̵� ����";
				
				break;
			}
			else{
				//alert('�ߺ��� ���̵� ���� ��밡��');
				document.getElementById('useId').disabled = false;
				document.getElementById('text').innerHTML="�ߺ��� ���̵� ���� ��밡��";
			}
		}
	}
	function checkkeyup() {
		//console.log("Ű���������־�...");
		document.getElementById('useId').disabled = true;

	}
</script>
</head>
<body>
<h3>���̵� �ߺ�Ȯ��</h3>
<form name="checkid" id="checkid">
	<input type="text" id="checkMemberId" name="checkMemberId" onkeyup="checkkeyup()" >
	<input type="button" value="�ߺ�Ȯ��" onclick="checkid()" >
	<input type="button" value="����ϱ�" id="useId" name="useId" onclick="useId2()" maxlength="20" disabled>
	<input type="button" value="â�ݱ�" onclick="window.close()">
	<span id="text"></span>

</form>

<span></span>
</body>
</html>