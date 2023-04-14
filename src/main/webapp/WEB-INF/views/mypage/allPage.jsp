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
			<!-- 여자, 남자에 따라 다른 사진 들어가게 
			<li><img src="${path}/static/img/mypage/womanicon.png"/></li> 
			-->
			<li class=img>
				<img src="${path}/static/img/mypage/manicon.png"/><br/>
				''토르''
			</li> 
			
			
			<li><a href="main">신청목록</a></li>
			<li><a href="rank">나의 랭크</a></li>
			<li><a href="paymentList">결제내역</a></li>
			<li><a href="info">내정보수정</a></li> <!-- mypage/${userid}/info  POST로 보내야해-->
		</ul>
		