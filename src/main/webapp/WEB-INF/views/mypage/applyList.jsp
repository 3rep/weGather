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
			<li><img src="${path}/static/img/mypage/manicon.png"/></li> 
			
			<li><a href="">신청목록</a></li>
			<li><a href="">나의 랭크</a></li>
			<li><a href="">결제내역</a></li>
			<li><a href="mypage/info">내정보수정</a></li> <!-- mypage/${userid}/info  POST로 보내야해-->
		</ul>
		<!-- 오른쪽 내용칸 -->
		<div id="content"> 
			오른쪽 본문 들어가는 칸<br/>
			<hr/>
			<p>
			예시본문<br/>
			백곰이라고도 한다. 몸길이 수컷 190~250cm, 암컷 170~250cm, 꼬리길이 8~10cm, 어깨높이 120~140cm, 뒷발길이 30~37cm, 귀길이 9~15cm, 몸무게 수컷 300~800kg, 암컷 150~500kg이다. 암컷은 수컷보다 몸이 작다. 다른 곰보다 머리가 작고 목이 길며 귀는 작고 둥글다. 발바닥에는 털이 있으며 척구(蹠球)는 작아서 얼음 위를 걸어 다니기에 알맞다. 몸빛은 털갈이 직후에는 흰색이나 차츰 황백색으로 변한다. 어린 것은 어미보다 희끗희끗하다. 눈·코·척구는 검은색이다. 이빨은 38~42개이다.
[네이버 지식백과] 북극곰 [Polar Bear] (두산백과 두피디아, 두산백과)
			</p>
		</div>
	</div>
</body>
</html>