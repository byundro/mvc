<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:if test="1234"></c:if>

<% 
String id = request.getParameter("id");
String num = request.getParameter("num");
%>
<h1>id = <%= id %></h1>
<h1>num = <%= num+100 %></h1>
<h1>id = ${id}</</h1>
<h1>num = ${num+"100"}</h1>
<h1>num = ${num+"10"}</h1>

${10+10}
${10*10}
${10>10}
${10 lt 20}
${10 gt 20}