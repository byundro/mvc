<%@ page  contentType="text/html; charset=euc-kr"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ include file="/resource/etc/color.jspf"%> 
<html>
<head>
<title>ȸ��Ż��</title>
<link href="/resource/style/bootstrap-3.3.7-dist/css/bootstrap.css"  rel="stylesheet" type="text/css">
</head>

<c:if test="${check ==1 }"
<body bgcolor="<%=bodyback_c%>">
<form method="post" action="main.jsp" name="userinput" >
<table width="270" border="0" cellspacing="0" cellpadding="5" align="center">
  <tr bgcolor="<%=title_c%>"> 
    <td height="39" align="center">
	  <font size="+1" ><b>ȸ�������� �����Ǿ����ϴ�.</b></font></td>
  </tr>
  <tr bgcolor="<%=value_c%>">
    <td align="center"> 
      <p>����.... �����մϴ�. �ȳ��� ������.</p>
      <meta http-equiv="Refresh" content="5;url=main.jsp" >
    </td>
  </tr>
  <tr bgcolor="<%=value_c%>">
    <td align="center"> 
      <input type="submit" value="Ȯ��">
    </td>
  </tr>
</table>
</form>
</c:if>
<%}else {%>
	<script> 
	  alert("��й�ȣ�� ���� �ʽ��ϴ�.");
      history.go(-1);
	</script>
<%}%>

</body>
</html>
