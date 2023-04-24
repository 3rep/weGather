<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<link href="${path}/static/style/register/register.css" rel="stylesheet" type="text/css" />
<link href="${path}/static/style/style.css" rel="stylesheet" type="text/css" />



<div class="container1">
<h1>로그인 선택</h1>
<div class="box1">
		<a href="login"><h2>로그인</h2></a>
</div>
<div class="box2">
	<a href="/loginMan"><h2>매니저 로그인</h2></a>

</div>
<div class="box3">
	<a href="/loginAdmin"><h2>관리자 로그인</h2></a>
</div>
</div>
