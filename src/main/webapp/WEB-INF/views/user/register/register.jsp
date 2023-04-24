<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<link href="static/style/style.css" rel="stylesheet" type="text/css" />
<link href="static/style/register.css" rel="stylesheet" type="text/css" />
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
<style>
	
	
	
</style>
<script>
	
	$(function(){
		//아이디 중복검사
		$("input[value=아이디중복검사]").click(function(){
			if($("#userid").val()!=""){
				window.open("idCheck?userid="+$("#userid").val(), "chk","width=450,height=300");
			}else{
				alert("아이디를 입력 후 중복검사하세요.");
			}
		});
		
		$("#registerForm").submit(function(){
			//form태그의 action속성 설정하기
			$("#registerForm").attr("action","registerOk");
			return true;
		});
		
		
	});

</script>
<div class="container2">
	<br/>
	<h1 style="color:#162888">회원가입</h1>
	<br/>
	<form method="post" id="registerForm">
		
		<ul>
			<li>구분</li>
			<li>
				<input type="radio" name="type" value="user"/> 사용자
				<input type="radio" name="type" value="manager"/> 매니저
			</li>
			<li>아이디</li>
			<li>
				<input type="text" placeholder="아이디를 입력하세요..."name="userid" id="userid" minlength="4" maxlength="15" style="width:370px; height:40px;"/>
				<input type="button" value="아이디중복검사" style="height:40px"/>
				<input type="hidden" id="idStatus" value="N"/>
			</li>
			<li>비밀번호</li>
		<li><input type="password" placeholder="비밀번호를 입력하세요..." name="password" id="userpwd" minlength="4" maxlength="15" style="width:500px; height:40px;"/></li>
		<li>성별</li>
			<li>
				<input type="radio" name="gender" value="남성"/> 남성
				<input type="radio" name="gender" value="여성"/> 여성
			</li>
		<li><input type="text" placeholder="이름을 입력하세요..."name="username" id="username" minlength="2" maxlength="10" style="width:500px; height:40px;"/></li>
		<li>연락처</li>
		<li>
			<select name="tel1" id="tel1"style="width:50px; height:40px;">
				<option value="010">010</option>
				<option value="02">02</option>
				<option value="031">031</option>
				<option value="041">041</option>
				<option value="051">051</option>
			</select>
			<input type="text" name="tel2" id="tel2" maxlength="4" style="width:220px; height:40px;"/>
			<input type="text" name="tel3" id="tel3" maxlength="4" style="width:220px; height:40px;"/>
		</li>
		<li>이메일</li>
		<li><input type="text" name="email" id="email" style="width:500px; height:40px;"/></li>
		<li>주소</li>
		<li><input type="text" name="address" id="address"style="width:500px; height:40px;"/></li>
		<li>MBTI</li>
		<li><input type="text" name="mbti" id="mbti"style="width:500px; height:40px;"/>
		<br/>
		<li>
			<input type="submit" value="회원가입"style="width:500px; height:40px;"/>
		</li>
		</ul>	
		
	</form>
	<form>
	<img src="static/img/futsal.jpeg" width= "600px" height= "450px">
	</form>
</div>

