<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<div class="container">
	<h2 id="page-title">지출 내역</h2>
	<div id="expense_container">
		<table>
			<tr class="expense">
				<th id="">번호</th>
				<th id="amount">금액</th>
				<th id="">지출목록</th>
				<th id="">지출상세</th>
				<th id="datetime">날짜</th>
			</tr>
			<c:forEach var="m_settlement" items="${expense}" varStatus="status">
				<tr>
					<td>${status.index+1}</td>
					<td>${m_settlement.amount}</td>
					<td>매니저 수당</td>
					<td>${m_settlement.m_name} 매니저 [지급계좌: ${m_settlement.m_account}]</td>
					<td>
						<c:if test="${m_settlement.datetime==null}">
							<span>-</span>
						</c:if>
						<fmt:formatDate pattern="yyyy-MM-dd" value="${m_settlement.datetime}" />
					</td>
				<tr>
			</c:forEach>
		</table>
	</div>
</div>
</body>
</html>