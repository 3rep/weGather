<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<!-- 시작하기 버튼 클릭후 입장화면 = 로그인 안했을때 화면 = 로그아웃했을때 화면 -->
<div id="container" class="main-container"> 
	<!-- <div class="rank-visual" > -->
	
	<img class="img" src="static/img/imgMain/stadium.jpg" alt="football"/> 
	
	<div class="item" id="cloudy"> <!-- A -->
		<div class="login"> <!-- B -->
			<span>We gather &emsp;</span><br/>
			<span>&emsp; together </span><br/>
			<span id="featSpan">feat. sport</span><br/>
			<br/>
			<button class="button button--ujarak button--border-medium button--round-s button--text-upper" onclick="location.href='login'">회원</button>
         		<button class="button button--ujarak button--border-medium button--round-s button--text-upper" onclick="location.href='loginMan'">매니저</button>
		</div>
	</div>
	<div class="item" id="info">
		
		<!-- <img class="infoImg" src="static/img/imgMain/info.png" alt="info"/> -->
		
		<div class="infoTxt">
			<span class="first">신청, 경기시작 </span><br/>
			<span class="second">We gather, Just do it!</span> 
			<div class="jb-division-line"></div>
			<div class="third">
				인원모집 및 예약 서비스 <br/>
				랭크 시스템<br/>
				매니저 지원 서비스<br/>
				맞춤형 스포츠 추천
			</div>
		</div>
	</div>
</div>
