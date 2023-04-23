<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<!-- 스타일태그를 인라인으로 넣어서 외부에서 가져오는 css보다 먼저 적용되도록 한다.
	헤더, 푸터가 include되어서 head태그에 link태그를 걸수가 없음 -->
<!-- <style type="text/css">
@import url(static/style/main.css);
</style> -->


	<!-- 배경에 이미지 깔고 
	그 위에 
		1. 1. 로고 + 회원가입, 로그인 버튼?  있는 화면 : 백그라운드 연하게
		2. 회원가입화면 바로 밑에 붙여서 소개 div
	
		1,2 는 하나의 container에 넣어서 flex 적용시킨다.
	-->
	
	<div class="container">
		<div class="item" id="item1">
			<div class="login"> 
				<span>We gather, together !</span>
				<button>로그인</button >
				<button>회원가입</button>
			</div>
		</div>
		<div class="item" id="item2">
			<div class="info">
				소개메세지
			</div>
		</div>
	</div>
		
