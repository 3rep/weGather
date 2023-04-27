<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<link href="static/style/style.css" rel="stylesheet" type="text/css" />

<link href="${path}/static/style/manager/manager.css" rel="stylesheet" type="text/css" />
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>


<div class="loginMan_container">
	<br/><br/><br/><br/>
	<h1>로그인</h1>
	<form method="post" action="loginManOk" id="logManFrm">
		
		<ul>
			<br/>
			<li>아이디</li>
			<li><input type="text" name="managerid" id="login_managerid"/></li>
			<li>비밀번호</li>
			<li><input type="password" name="password" id="login_password"/></li>
			<br/>
			<li><input type="submit" value="LOGIN" id="login_LOGIN"/></li>
			
		</ul>
	</form>
	<div class="login_register">
		<a href="manager">회원가입</a>
	</div>
	<br/>
	<div>
		<img src="static/img/manager.jpg" id="login_img">
	</div>
</div>