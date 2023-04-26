<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div id="container-login">
	<h1 style="color:#660066">로그인</h1>
	<form method="post" action="loginOk" id="logFrm">
		<ul>
			<li>아이디</li>
			<li><input type="text" name="userid" id="userid" /></li>
			<li>비밀번호</li>
			<li><input type="password" name="password" id="password" /></li>
			<li><input type="submit" value="LOGIN" /></li>
			
		</ul>
	</form>
	<div class="login-register" >
		<a href="register">회원가입</a>
	</div>
	<br/>
	<div >
		<img id="login-img" src="static/img/futsal.jpeg">
	</div>
</div>