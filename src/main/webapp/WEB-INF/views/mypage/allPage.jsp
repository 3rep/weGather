<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MyPage</title>	
<link href="${path}/static/style/style.css" rel="stylesheet" type="text/css" />
<link href="${path}/static/style/mypage/allPage.css" rel="stylesheet" type="text/css">
</head>
<body>
<body>
	<div class="container" >
		<!-- 왼쪽 메뉴바 -->
		<ul id="leftMenu">
			<li class=h>마이페이지</li>
			<!-- 여자, 남자에 따라 다른 사진 들어가게 -->
			
			<c:if test="${logGender=='여' }">
				<li class=img>
					<img src="${path}/static/img/mypage/female.png"/><br/> 
					[[[[${logName}]]]]
				</li>	
			</c:if>
			<c:if test="${logGender!='여' }">
				<li class=img>
					<img src="${path}/static/img/mypage/male.png"/><br/>
					[[[[${logName}]]]]
				</li> 
			</c:if>
			<div class="menuList" >
 				<li><img src="${path}/static/img/mypage/calendar.png"/></li>
 				<li><a href="main">신청목록</a></li>
 				
 				<!--    -->
 				<li><img src="${path}/static/img/mypage/corner.png"/></li>
 				<li><a href="main">랭킹전</a></li>
 				<li><img src="${path}/static/img/mypage/corner.png"/></li>
 				<li><a href="main">일반전</a></li>
 				 				
 				<!--    -->
 				
 				<li><img src="${path}/static/img/mypage/prize.png"/></li>
				<li><a href="rank">나의 랭크</a></li>
				<li><img src="${path}/static/img/mypage/align.png"/></li>
				<li><a href="paymentList">결제내역</a></li>
				<li><img src="${path}/static/img/mypage/info.png"/></li>
				<li><a href="info">내정보수정</a></li> <!-- mypage/${userid}/info  POST로 보내야해-->
				
			</div>
		</ul>
		