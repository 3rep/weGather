<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="container" id="container-allManager">
	<h2>매니저 승인 대기 목록</h2>
	<ul class="approve_list">
		<li>번호</li>
		<li>이름</li>
		<li>아이디</li>
		<li>이메일</li>
		<li>연락처</li>
		<li>입금계좌</li>
		<li>성별</li>
		<li>가입날짜</li>
		<li>종목</li>

		<c:set var="no" value="${1}" />
		<c:forEach var="mDTO" items="${list}">
		<li><a href="/admin/manager/approvedetail?managerid=${mDTO.managerid}">${no}</a></li>
		<li><a href="/admin/manager/approvedetail?managerid=${mDTO.managerid}">${mDTO.m_name}</a></li>
		<li><a href="/admin/manager/approvedetail?managerid=${mDTO.managerid}">${mDTO.managerid}</a></li>
		<li><a href="/admin/manager/approvedetail?managerid=${mDTO.managerid}">${mDTO.email}</a></li>
		<li><a href="/admin/manager/approvedetail?managerid=${mDTO.managerid}">${mDTO.tel}</a></li>
		<li><a href="/admin/manager/approvedetail?managerid=${mDTO.managerid}">${mDTO.m_account}</a></li>
		<li><a href="/admin/manager/approvedetail?managerid=${mDTO.managerid}">${mDTO.gender}</a></li>
		<li><a href="/admin/manager/approvedetail?managerid=${mDTO.managerid}">${mDTO.signupdate}</a></li>
		<li><a href="/admin/manager/approvedetail?managerid=${mDTO.managerid}">${mDTO.sportname}</a></li>
		<c:set var="no" value="${no+1}" />
		</c:forEach>
	</ul>
</div>
</body>
</html>
