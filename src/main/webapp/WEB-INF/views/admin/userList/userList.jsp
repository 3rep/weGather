<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<div class="container">
	<h2 id="page-title">회원목록</h2>
	<div class="usersList_container">
	<h4>※회원 아이디 선택 시 회원 정보수정, 회원 이름 선택 시 회원 활동내역 페이지 이동</h4>
		<ul class="usersList">
			<li id="id">회원 아이디</li>
			<li id="pwd">이메일</li>
			<li id="name">회원 이름</li>
			<li id="tel">연락처</li>
			<li id="date">등록일</li>
			<c:set var="recordNum" value="${vo.totalRecord - (vo.nowPage-1)*vo.onePageRecord}"/>
			<c:forEach var="users" items="${list}">
				<li><a href="userEdit/${users.userid}">${users.userid}</a></li>
				<li>${users.email}</li>
				<li><a href="userLog/${users.userid}">${users.username}</a></li>
				<li>${users.tel}</li>
				<li>${users.signupdate }</li>
				<c:set var="recordNum" value="${recordNum-1 }"/>
			</c:forEach>
		</ul>
	</div>
	
	<!-- 페이징 -->
	<div class="userlist_pagingDiv">
		<ul>
			<!-- 이전페이지 	:	nowPage를 기준으로 -->
			<c:if test="${vo.nowPage==1}"><!-- 현재페이지가 첫번째 페이지일때 -->
				<li>prev</li>
			</c:if>
			<c:if test="${vo.nowPage>1}"><!-- 현재페이지가 첫번째페이지가 아닐때 -->
				<li><a href="userList?nowPage=${vo.nowPage-1}">prev</a></li>
			</c:if>
			
			<!-- 페이지 번호 -->
			<c:forEach var="p" begin="${vo.startPageNum}" end="${vo.startPageNum+vo.onePageNumCount-1}">
				
				<c:if test="${p<=vo.totalPage}"><!-- 표시할 페이지번호가 총페이지수보다 작거나같을때 페이지번호 출력 -->
					<!-- 현재페이지 표시하기 -->
					<c:if test="${p==vo.nowPage }">
						<li style="background:#ddd;">
					</c:if>
					<c:if test="${p!=vo.nowPage }">
						<li>
					</c:if>
						<a href="userList?nowPage=${p}">${p}</a></li>
				</c:if>
			</c:forEach>
			

			<!-- 다음페이지 -->
			<c:if test="${vo.nowPage<vo.totalPage }"><!-- 다음페이지가 있을때 -->
				<li><a href="userList?nowPage=${vo.nowPage+1}">next</a></li>
			</c:if>
			<c:if test="${vo.nowPage==vo.totalPage }"><!-- 현재페이지가 마지막일때 -->
				<li>next</li>
			</c:if>
		</ul>
	</div>
</div>
</body>
</html>