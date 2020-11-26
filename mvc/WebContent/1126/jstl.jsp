<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<h1>jstl page .....!!!!!</h1>

<c:set var="msg" value="hello"></c:set>
<c:set var="num" value="100"></c:set>

<c:if test="${num > 0}">
	<h1>0보다 크다 11</h1>
</c:if>
<c:if test="${num < 0}">
	0보다 작다 22
</c:if>
<c:if test="${num == 0}">
	0보다 크다 33
</c:if>

<c:choose>
	<c:when test="${num > 0}">
	<h1>choose 0보다 크다</h1>
	</c:when>
	<c:when test="${num == 0}">
	choose 0과 같다
	</c:when>
	<c:otherwise>
	choose 0보다작다
	</c:otherwise>
</c:choose>

<!-- for문으로 지정된 변수값만큼 가능 -->
<c:forEach begin="1" end="10" step="3" var="a">
${a}
</c:forEach>

<c:forEach var="x" items="${list}" > 
	${x.id}====${x.passwd}
</c:forEach>

<c:forTokens var="y" items="aaa,bbb,ccc,ddd" delims=",">
${y} <br/>
</c:forTokens>

<c:import var="aaa" url="http://localhost:8080/mvc/form.do" />
${aaa}
${aaa}

<br/><br/>


<h1>${day}</h1>

<h1> <fmt:formatDate value="${day}"/> </h1>
<h1> <fmt:formatDate value="${day}" type="both"/> </h1>
<h1> <fmt:formatDate value="${day}" type="date"/> </h1>
<h1> <fmt:formatDate value="${day}" type="time"/> </h1>
<!-- full , default , short , medium , long -->
<h4> <fmt:formatDate value="${day}" type="both" dateStyle="full" timeStyle="full" /> </h4>
<h4> <fmt:formatDate value="${day}" type="both" dateStyle="short" timeStyle="short"/> </h4>
<h4> <fmt:formatDate value="${day}" type="both" dateStyle="medium" timeStyle="medium"/> </h4>
<h4> <fmt:formatDate value="${day}" type="both" dateStyle="long" timeStyle="long"/> </h4>
<h4> <fmt:formatDate value="${day}" type="both" dateStyle="default" timeStyle="default"/> </h4>

<h4> <fmt:formatDate value="${day}" type="both" pattern="yyyy년 MM월 dd일"/> </h4>

<h1>타임존 설정...!!</h1>
<fmt:timeZone value="KST">
	<h4> <fmt:formatDate value="${day}" type="both" dateStyle="full" timeStyle="full" /> </h4>
</fmt:timeZone>

<h1>한글</h1>
<fmt:requestEncoding value="UTF-8" /> <!-- 인코딩 -->
<h1>한글</h1>
<h1><fmt:formatNumber value="123456.789" type="number" /></h1>
<h1><fmt:formatNumber value="123456.789" type="currency" currencySymbol="\\" /></h1>
<h1><fmt:formatNumber value="123456.789" type="currency" currencySymbol="$" /></h1>
<h1><fmt:formatNumber value="0.789" type="percent" /></h1>
<h1><fmt:formatNumber value="123456.789" pattern=".00" /></h1>






