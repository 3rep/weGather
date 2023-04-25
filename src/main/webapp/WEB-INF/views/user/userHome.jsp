<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>

	<!-- 배경에 이미지(A) 깔고 
	그 위에 
		1. 로고 + 회원가입, 로그인 버튼?  있는 화면 : 백그라운드 연하게
			> 불투명 백그라운드(B) + 내용들어있는 div(C)
		2. 회원가입화면 바로 밑에 붙여서 소개 div(D)
	
		하나의 container에 넣어서 flex 적용시킨다.
		
		맨 뒤 바탕사진(A)은 스크롤할때 1씩 간다면,
		그 위에 1,2div는 5씩 이동해야함
	-->
	
	<div id="container" class="main-container"> <!-- css우선순위: id가 css보다 우선적용 -->
		<img class="img" src="static/img/imgMain/tennis.jpg" alt="volley"/>
		<div class="item" id="cloudy"> <!-- A -->
			<div class="login"> <!-- B -->
				<span>We gather,&emsp;</span><br/>
				<span>&emsp; together !</span><br/>
				<span class="featSpan">feat. sport</span><br/>
				<br/>
				환영합니다. ***님<br/> 
				or 취미추천링크 or 랭크보드?
			</div>
		</div>
		<div class="item" id="info">
			<div class="infoTxt">
				사이트 소개글
			</div>
		</div>
	</div>