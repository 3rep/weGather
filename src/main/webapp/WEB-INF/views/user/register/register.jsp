<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
	<form class="register-form" method="post" id="registerForm">
		
		<ul>
			<li>구분</li>
			<li>
				<input type="radio" name="type" value="user" checked/> 사용자
			</li>
			<li>아이디</li>
			<li>
				<input type="text" placeholder="아이디를 입력하세요..."name="userid" id="userid" minlength="4" maxlength="15" />
				<input type="button" value="아이디중복검사" />
				<input type="hidden" id="idStatus" value="N"/>
			</li>
			<li>비밀번호</li>
		<li><input type="password" placeholder="비밀번호를 입력하세요..." name="password" id="userpwd" minlength="4" maxlength="15" /></li>
		<li>성별</li>
			<li>
				<input type="radio" name="gender" value="남성"/> 남성
				<input type="radio" name="gender" value="여성"/> 여성
			</li>
		<li><input type="text" placeholder="이름을 입력하세요..."name="username" id="username" minlength="2" maxlength="10" /></li>
		<li>연락처</li>
		<li>
			<select name="tel1" id="tel1">
				<option value="010">010</option>
				<option value="02">02</option>
				<option value="031">031</option>
				<option value="041">041</option>
				<option value="051">051</option>
			</select>
			<input type="text" name="tel2" id="tel2" maxlength="4" />
			<input type="text" name="tel3" id="tel3" maxlength="4" />
		</li>
		<li>이메일</li>
		<li><input type="text" name="email" id="email"/></li>
		<li>주소</li>
		<li><input type="text" name="address" id="address"/></li>
		<li>MBTI</li>
		<li><input type="text" name="mbti" id="mbti"/>
		<br/>
		<li>
			<input type="submit" value="회원가입"/>
		</li>
		</ul>	
		
	</form>
	<form>
	<img class="register-img" src="static/img/futsal.jpeg" >
	</form>
</div>

