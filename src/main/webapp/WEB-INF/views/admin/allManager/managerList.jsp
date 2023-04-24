<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<script>

</script>
<div class="container" id="container-allManager2">
	<h2>매니저 목록</h2>
	<form method="post" id="">
	<ul class="manager_list">
		<li>선택</li>
		<li>번호</li>
		<li>이름</li>
		<li>아이디</li>
		<li>이메일</li>
		<li>연락처</li>
		<li>입금계좌</li>
		<li>성별</li>
		<li>최근활동</li>
		<li>종목</li>
		
		
		<c:set var="no" value="${1}" />
		<c:forEach var="mDTO" items="${list}">
			<li><input type="checkbox" name="managerid" value="${mDTO.managerid}" /></li>
			<li>${no}</li>
			<li><a href="admin/manager/managerdetail?managerid=${mDTO.managerid}">${mDTO.m_name}</a></li>
			<li><a href="admin/manager/managerdetail?managerid=${mDTO.managerid}">${mDTO.managerid}</a></li>
			<li><a href="admin/manager/managerdetail?managerid=${mDTO.managerid}">${mDTO.email}</a></li>
			<li><a href="admin/manager/managerdetail?managerid=${mDTO.managerid}">${mDTO.tel}</a></li>
			<li><a href="admin/manager/managerdetail?managerid=${mDTO.managerid}">${mDTO.m_account}</a></li>
			<li><a href="admin/manager/managerdetail?managerid=${mDTO.managerid}">${mDTO.gender}</a></li>
			<c:if test="${mDTO.rankgameList != null}">
				<li><a href="admin/manager/managerdetail?managerid=${mDTO.managerid}"><fmt:formatDate pattern="yyyy년 MM월 dd일" value="${mDTO.rankgameList[0].gametime}" /></a></li>
			</c:if>
			<c:if test="${mDTO.rankgameList == null}">
				<li><a href="admin/manager/managerdetail?managerid=${mDTO.managerid}">&nbsp;-&nbsp;</a></li>
			</c:if>
			<li><a href="admin/manager/managerdetail?managerid=${mDTO.managerid}">${mDTO.sportname}</a></li>
			<c:set var="no" value="${no+1}" />
		</c:forEach>
	</ul>
	</form>
	<div class="button_box">
		<input type="submit" value="매니저 제명" id="dismiss"/>
	</div>
</div>
</body>
</html>
