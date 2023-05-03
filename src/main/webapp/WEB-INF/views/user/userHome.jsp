<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div id="container" class="main-container"> 
	<img class="img" src="static/img/imgMain/football.jpg" alt="football"/>
	<div class="item" id="cloudy"> <!-- A -->
		<div class="login"> <!-- B -->
			<h3> 
				환영합니다. ${logName }님<br/> 
				or 취미추천링크 or 랭크보드?
			</h3>
		</div>
	</div>
	<div class="item" id="info">
		<div class="infoTxt">
			<span class="first">신청, 경기시작</span><br/>
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