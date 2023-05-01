<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="container">
	<h2 id="page-title">지출 내역</h2>
	<div class="expense_container">
	
		<ul class="expense">
			<li id="no">회원 번호</li>
			<li id="managerid">매니저 아이디</li>
			<li id="datetime">날짜</li>
			<li id="d_status">등록 상태</li>
			<li id="amount">금액</li>
			 
			<c:forEach var="m_settlement" items="${expense}">
				<li>${m_settlement.no}</li>
				<li>${m_settlement.managerid}</li>
				<li>${m_settlement.datetime}</li>
				<li>${m_settlement.d_status}</li>
				<li>${m_settlement.amount}</li>
				<form method=post action="waitOk"id="m_settleForm">
				<c:if test="${m_settlement.d_status==0}">
					<input type="submit" value="결제대기" id="wait"/>
					<input type="hidden" value="${m_settlement.managerid}" name="managerid"/>
				</c:if>
				<c:if test="${m_settlement.d_status==1}">
					<li>결제완료</li>
				</c:if>
				</form>
			</c:forEach>
		</ul>
	</div>

</div>
</body>
</html>