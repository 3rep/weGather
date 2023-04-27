<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<link href="${path}/static/style/register/login.css" rel="stylesheet" type="text/css" />


<div class="login_container">
	<h1>로그인</h1>
	<form method="post" action="loginOk" id="logFrm">
		
		<ul>
			<li>아이디</li>
			<li><input type="text" name="id" id="log_id"/></li>
			<li>비밀번호</li>
			<li><input type="password" name="password" id="log_password"/></li>
			<br/>
			<li><input type="submit" value="LOGIN" id="log_LOGIN"/></li>
			<br/>
			<li id="log_register"><a href="register" >회원가입</a></li>
		</ul>
	</form>
	<br/>
	<!--   
	<div>
		<img src="static/img/futsal.jpeg" id="log_img" >
	</div>
	-->
</div>