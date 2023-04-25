<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MyPage</title>	
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
<link href="${path}/static/style/style.css" rel="stylesheet" type="text/css" />
<link href="${path}/static/style/mypage/allPage.css" rel="stylesheet" type="text/css">
<link href="${path}/static/style/mypage/applyList.css" rel="stylesheet" type="text/css">
<link href="${path}/static/style/mypage/rank.css" rel="stylesheet" type="text/css">
</head>

<body>
	<div class="container-mypage-all" >
		<!-- 왼쪽 메뉴바 -->
		<ul id="leftMenu">
			<li class=h>마이페이지</li>
			
			<!-- 여자, 남자에 따라 다른 사진 들어가게 -->
			<c:if test="${logGender=='여성' }">
				<li class=img>
					<img src="${path}/static/img/mypage/female.png"/><br/> 
					${logName}<span>님</span>
				</li>	
			</c:if>
			<c:if test="${logGender!='여성' }">
				<li class=img>
					<img src="${path}/static/img/mypage/male.png"/><br/>
					${logName}<span>님</span>
				</li> 
			</c:if>
			<div class="line"></div>
			
			<div id="menuList" >
				<li><img src="${path}/static/img/mypage/calendar.png"/></li>
	 			<li><a href="applyList">My 경기</a></li>
 				<li><img src="${path}/static/img/mypage/prize.png"/></li>
				<li><a href="rank">My 랭크</a></li>
				<li><img src="${path}/static/img/mypage/align.png"/></li>
				<li><a href="paymentList">결제내역</a></li>
				<li><img src="${path}/static/img/mypage/info.png"/></li>
				<li><a href="info">내정보수정</a></li> <!-- mypage/${userid}/info  POST로 보내야해-->
			</div>
		</ul>
		