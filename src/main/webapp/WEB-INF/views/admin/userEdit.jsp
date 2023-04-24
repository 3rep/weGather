<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<link href="${path}/static/style/style.css" rel="stylesheet" type="text/css" />
<link href="${path}/static/style/register.css" rel="stylesheet" type="text/css" />
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
<style>
	

</style>
<script>
	
	$(function(){
		
		$("#userEditForm").submit(function(){
			//form태그의 action속성 설정하기/
			$("#userEditForm").attr("action","${pageContext.request.contextPath}/userEditOk");
			return true;
		});
		
		
	});

</script>
<div class="container1">
	<br/>
	<h1 style="color:#660066">회원정보</h1>
	<br/>
	<form method="post" id="userEditForm">
		
		<ul>
			<li>
				<input type="text" id="username" minlength="4" maxlength="15" value="${dto.username}" readonly style="width:250px; height:40px;"/>
				<input type="text" name="rank" id="rank" value="${dto.rank}" style="width:60px; height:40px">
				<input type="submit" value="랭크수정" style="height:40px">
			</li>
			<hr/>
			<li>구분</li>
			<li>
				<input type="radio" name="type" value="user"<c:if test="${dto.type=='user'}">checked</c:if>/> 사용자
				<input type="radio" name="type" value="manager"<c:if test="${dto.type=='manager'}">checked</c:if>/> 매니저
			</li>
		<li>아이디</li>
		<li>
			<input type="text" name="userid" id="userid" minlength="4" maxlength="15" value="${dto.userid}" readonly style="width:500px; height:40px;"/>
		</li>
			<li>비밀번호</li>
		<li><input type="password" placeholder="비밀번호를 입력하세요..." name="password" id="userpwd" minlength="4" maxlength="15"value="${dto.password}" readonly style="width:500px; height:40px;"/></li>
		<li>성별</li>
			<li>
				<input type="radio" name="gender" value="남성"<c:if test="${dto.gender=='남성'}">checked</c:if>/> 남성
				<input type="radio" name="gender" value="여성"<c:if test="${dto.gender=='여성'}">checked</c:if>/> 여성
			</li>
		<li><input type="text" placeholder="이름을 입력하세요..."name="username" id="username" readonly value="${dto.username}"style="width:500px; height:40px;"/></li>
		<li>연락처</li>
		<li>
			<select name="tel1" id="tel1" readonly style="width:50px; height:40px;">
				<option value="010" <c:if test="${dto.tel1=='010'}">selected</c:if>>010</option>
					<option value="02" <c:if test="${dto.tel1=='02'}">selected</c:if>>02</option>
					<option value="031" <c:if test="${dto.tel1=='031'}">selected</c:if>>031</option>
					<option value="041" <c:if test="${dto.tel1=='041'}">selected</c:if>>041</option>
					<option value="051" <c:if test="${dto.tel1=='051'}">selected</c:if>>051</option>
			</select>
			<input type="text" name="tel2" id="tel2" readonly maxlength="4" value="${dto.tel2}"style="width:220px; height:40px;"/>
			<input type="text" name="tel3" id="tel3" maxlength="4" readonly value="${dto.tel3}"style="width:220px; height:40px;"/>
		</li>
		<li>이메일</li>
		<li><input type="text" name="email" id="email" readonly value="${dto.email}" style="width:500px; height:40px;"/></li>
		<li>주소</li>
		<li><input type="text" name="address" id="address" readonly value="${dto.address}"style="width:500px; height:40px;"/></li>
		<li>MBTI</li>
		<li><input type="text" name="mbti" id="mbti" readonly value="${dto.mbti }"style="width:500px; height:40px;"/>
		<br/><br/>
		<li>
			<a href="/userList">회원목록</a>
			회원 활동 내역
		</li>
		</ul>	
		<img src="${path}/static/img/futsal.jpeg" width= "500px" height= "400px">
	</form>

</div>

