<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<link href="${path}/static/style/register/register.css" rel="stylesheet" type="text/css" />
<link href="${path}/static/style/style.css" rel="stylesheet" type="text/css" />
<link href="${path}/static/style/admin/admin.css" rel="stylesheet" type="text/css" />
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>

<div class="container1">
	<h1 style="color:#660066">회원 목록</h1>
	<br/>
	<ul class="usersList">
		<li>회원 아이디</li>
		<li>이메일</li>
		<li>회원 이름</li>
		<li>연락처</li>
		<li>등록일</li>
		<c:forEach var="users" items="${list}">
			<li><a href="userEdit/${users.userid}">${users.userid}</a></li>
			<li>${users.email}</li>
			<li>${users.username}</li>
			<li>${users.tel}</li>
			<li>${users.signupdate }</li>
		</c:forEach>
	</ul>
</div>