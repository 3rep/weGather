<%@ include file="/WEB-INF/views/inc/user/header.jspf" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

	<!-- 메인화면 contents부분 -->
	<!-- 배경에 이미지(A) 깔고 
	그 위에 
		1. 로고 + 회원가입, 로그인 버튼?  있는 화면 : 백그라운드 연하게
			> 불투명 백그라운드(B) + 내용들어있는 div(C)
		2. 회원가입화면 바로 밑에 붙여서 소개 div(D)
	
		하나의 container에 넣어서 flex 적용시킨다.
		
		맨 뒤 바탕사진(A)은 스크롤할때 1씩 간다면,
		그 위에 1,2div는 5씩 이동해야함
	-->
	

	<section id="container" class="section-main"> <!-- css우선순위: id가 css보다 우선적용 -->
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
	</section>
	
	<!-- 사이트 소개 -->
	<section id="section-info">
		<div class="section-title">WE GATHER, JUST DO IT</div>
		<div class="section-content">
			<div class="info-img">이미지</div>
			<div class="info">
				<div class="info-title-wrap">
					<span class="title">경기신청 버튼하나로 끝</span>
					<span class="desc">오직 경기신청만! 나머지는 wegather가 준비합니다.</span>
				</div>
				<div class="info-items">
					<div class="item-wrap left">
						<div class="info-item">
							<span class="title">인원모집 및 예약</span>
							<span class="desc">기능에 대한 간단한 설명이 여기에 들어갑니다</span>
						</div>
						<div class="info-item">
							<span class="title">매니저 지원 서비스</span>
							<span class="desc">기능에 대한 간단한 설명이 여기에 들어갑니다</span>
						</div>
					</div>
					<div class="item-wrap right">
						<div class="info-item">
							<span class="title">랭크 시스템</span>
							<span class="desc">기능에 대한 간단한 설명이 여기에 들어갑니다</span>
						</div>
						<div class="info-item">
							<span class="title">맞춤형 스포츠 추천</span>
							<span class="desc">기능에 대한 간단한 설명이 여기에 들어갑니다</span>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
	
	<!-- 경기 소개 -->
	<section id="section-game">
		<img src="" class="game-img" />
		<div class="game-wrap">
			<div class="game">
				<span class="title">랭크경기</span>
				<span class="desc">랭크경기는 설명 설명 설명</span>
				<a href="#">둘러보기????</a>
			</div>
			<div class="game">
				<span class="title">일반경기</span>
				<span class="desc">일반경기는 설명 설명 설명</span>
				<a href="#">둘러보기????</a>
			</div>
		</div>
		<img src="" class="game-img" />
	</section>
	
	<!-- 스포츠추천, 랭크보드 -->
	<section id="section-others">
		<div class="item-wrap">
			<img src="" class="item-img" />
			<div class="item">
				<span class="title">스포츠추천</span>
				<span class="desc">스포츠추천에 대한 설명들</span>
				<a href="#">둘러보기?</a>
			</div>
		</div>
		<div class="item-wrap">
			<div class="item">
				<span class="title">랭크보드</span>
				<span class="desc">랭크보드에 대한 설명들</span>
				<a href="#">둘러보기?</a>
			</div>
			<img src="" class="item-img" />
		</div>
	</section>
		
		<!-- <div class="item" id="info"> -->
		
			
			<!-- <img class="infoImg" src="static/img/imgMain/info.png" alt="info"/> -->
			<!--  
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
		-->

<%@ include file="/WEB-INF/views/inc/user/footer.jspf" %>
	
