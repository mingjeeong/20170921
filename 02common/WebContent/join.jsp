<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<form action="regFormProc.jsp" name="form" method="post">
 <table width="1400" height="650">
  <tr>
   <td width="100%" height="10%">&nbsp;ȸ������
   </td>
  </tr>
  <tr>
   <td height="15%">
   </td>
  </tr>
  <tr>
   <td height="60%" align="center" valign="top">
   <hr><br>
   <p align="left" style="padding-left:160px">
   <b> ���������Է�</b>
   <br><br>
   ID : <input type="text" size="10" maxlength="15" name="id"><br><br>
   ��й�ȣ : <input type="password" size="15" maxlength="20" name="pass"><br><br>
   ��й�ȣ Ȯ�� : <input type="password" size="15" maxlength="20" name="pass2"><br><br>
   �̸� : <input type="text" size="13" maxlength="12" name="name"><br><br>
   �̸��� : <input type="text" size="15" name="email1">@<input type="text" size="15" name="email2"><br><br>
   �̸��� ���ſ��� : <input type="radio" name="sent" value="ok"> ������&nbsp;&nbsp;
   <input type="radio" name="sent" value="no"> ���Ű���<br><br>
   �޴��� : <select name="ph1">
       <option value="010">010</option>
       <option value="011">011</option>
       <option value="016">016</option>
       <option value="017">017</option>
       <option value="019">019</option>
     </select>
     - <input type="text" name="ph2" size="5" maxlength="4"> - <input type="text" name="ph3" size="5" maxlength="4"><br><br>
   ���� : <input type="radio" name="gender" value="����"> ����&nbsp;&nbsp;
   <input type="radio" name="gender" value="����"> ����<br><br>
   ������� : <select name="birth1">
       <option value="2013">2013</option>
       <option value="2012">2012</option>
       <option value="2011">2011</option>
       <option value="2010">2010</option>
       <option value="2009">2009</option>
       <option value="2008">2008</option>
       <option value="2007">2007</option>
       <option value="2006">2006</option>
       <option value="2005">2005</option>
       <option value="2004">2004</option>
       <option value="2003">2003</option>
       <option value="2002">2002</option>
       <option value="2001">2001</option>
       <option value="2000">2000</option>
     </select>��&nbsp;
     <select name="birth2">
       <option value="1">1</option>
       <option value="2">2</option>
       <option value="3">3</option>
       <option value="4">4</option>
       <option value="5">5</option>
       <option value="6">6</option>
       <option value="7">7</option>
       <option value="8">8</option>
       <option value="9">9</option>
       <option value="10">10</option>
       <option value="11">11</option>
       <option value="12">12</option>
     </select>
     <select name="birth3">
       <option value="1">1</option>
       <option value="2">2</option>
       <option value="3">3</option>
       <option value="4">4</option>
       <option value="5">5</option>
       <option value="6">6</option>
       <option value="7">7</option>
       <option value="8">8</option>
       <option value="9">9</option>
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
     </select>��<br><br>
   �ּ� : <input type="text" name="address" size="15" maxlength="15"><br>
   *�ּҴ� (��/��)�� �Է����ּ��� (��: ��⵵, ����Ư����, ��󳲵� ��)
   </p>
  </td>
  </tr>
  <tr>
   <td align="center">
   <hr><br>
    <input type="submit" value="���Խ�û">&nbsp;
    <input type="reset" value="�ٽ��Է�">&nbsp;
    <input type="button" value="���">
   </td>
  </tr>
 </table>
</form>


</body>
</html>