<%@page import="org.apache.ibatis.reflection.SystemMetaObject"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div id="container" class="main-container">

	<%
		String logStatus = (String)session.getAttribute("logStatus");
		//System.out.println(logStatus);		
		pageContext.setAttribute("logStatus", logStatus);
	%>
	
	<!-- 로그인한 경우 -->
	<c:if test="${logStatus == 'Y'}">
		<img class="img" src="static/img/imgMain/football.jpg" alt="stadium"/>
		<div class="item" id="cloudy"> <!-- A -->
			<div class="login"> <!-- B -->
				<img src="/static/img/imgMain/quoteLeft.png" class="login-quote"/>
				<h3 class="userHomeH3"> ${logName }님 </h3>
				<p class="userHomeP">
				환영합니다!<br/>
				<!-- 경기를 시작해볼까요? -->
				</p>
				<img src="/static/img/imgMain/quoteRight.png" class="login-quote"/>
			</div>
		</div>
	</c:if> 	
	
	<!-- 로그인 하지 않은 경우 -->
	<c:if test="${logStatus != 'Y' }">
		<img class="img" src="static/img/imgMain/stadium.jpg" alt="football"/> 
		<div class="item" id="cloudy"> <!-- A -->
			<div class="login"> <!-- B -->
				<span>We Gather &emsp;</span><br/>
				<span>&emsp; Together </span><br/>
				<span id="featSpan">feat. sport</span><br/>
				<br/>
				<button class="button button--ujarak button--border-medium button--round-s button--text-upper" onclick="location.href='login'">회원</button>
	         	<button class="button button--ujarak button--border-medium button--round-s button--text-upper" onclick="location.href='loginMan'">매니저</button>
			</div>
		</div>
	</c:if>

	<div class="item" id="info">
		<div class="infoTxt">
			<span class="title">신청, 경기시작</span><br/>
			<span class="subTitle">We gather, Just do it!</span> 
			<div class="jb-division-line"></div>
			<div class="contents">
				인원모집 및 예약 서비스 <br/>
				랭크 시스템<br/>
				매니저 지원 서비스<br/>
				맞춤형 스포츠 추천
			</div>
			<div class="goToHome">
				<a href="/">WE GATHER 소개보기</a>
			</div>
		</div>
	</div>
	
</div>