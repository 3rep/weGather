<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="container">
	<h2 id="page-title">회원목록</h2>

<div class="usersList_container">
	<ul class="usersList">
		<li id="id">회원 아이디</li>
		<li id="pwd">이메일</li>
		<li id="name">회원 이름</li>
		<li id="tel">연락처</li>
		<li id="date">등록일</li>
		<c:forEach var="users" items="${list}">
			<li><a href="userEdit/${users.userid}">${users.userid}</a></li>
			<li>${users.email}</li>
			<li><a href="userLog/${users.userid}">${users.username}</a></li>
			<li>${users.tel}</li>
			<li>${users.signupdate }</li>
		</c:forEach>
	</ul>
</div>

</div>
</body>
</html>