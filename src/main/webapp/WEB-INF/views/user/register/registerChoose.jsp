<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<link href="${path}/static/style/register/register.css" rel="stylesheet" type="text/css" />
<link href="${path}/static/style/style.css" rel="stylesheet" type="text/css" />



<div class="container1">
<h1>회원가입 선택</h1>
<div class="box1">
		<a href="register"><h2>사용자 회원가입</h2></a>
</div>
<div class="box2">
	<a href="manager"><h2>매니저 회원가입</h2></a>

</div>
</div>
