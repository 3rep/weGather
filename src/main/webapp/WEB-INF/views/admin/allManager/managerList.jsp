<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<div class="container" id="container-allManager2">
	<h2>매니저 목록</h2>
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
		<li><input type="checkbox"/></li>
		<li>${no}</li>
		<li>${mDTO.m_name}</li>
		<li>${mDTO.managerid}</li>
		<li>${mDTO.email}</li>
		<li>${mDTO.tel}</li>
		<li>${mDTO.m_account}</li>
		<li>${mDTO.gender}</li>
		<c:if test="${mDTO.rankgameList != null}"><li><fmt:formatDate pattern="yyyy년 MM월 dd일" value="${mDTO.rankgameList[0].gametime}"/></li></c:if>
		<c:if test="${mDTO.rankgameList == null}"><li>&nbsp;-&nbsp;</li></c:if>
		<li>${mDTO.sportname}</li>
		<c:set var="no" value="${no+1}" />
		</c:forEach>
	</ul>
</div>

</body>
</html>
