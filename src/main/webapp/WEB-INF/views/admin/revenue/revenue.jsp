<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<div class="container">
	<h2 id="page-title">수입 내역</h2>
	<div id="revenue_container">
		<table>
			<tr class="revenue">
				<th id="">번호</th>
				<th id="paid_amount">금액</th>
				<th id="">수입목록</th>
				<th id="payer_name">입금자</th>
				<th id="payment_no">결제번호</th>
				<th id="paid_at">결제일</th>
			</tr>
			<c:forEach var="user_pay" items="${pay}" varStatus="status">
				<tr>
					<td>${status.index+1}</td>
					<td>${user_pay.paid_amount} ￦</td>
					<td>경기 참여</td>
					<td>${user_pay.payer_name}</td>
					<td>${user_pay.payment_no}</td>
					<!---- unix타입스탬프 -> 2023-04-12형태로 변환하기 ----->
			    	
			    	<c:set var="paidTime" value="${user_pay.paid_at}" />
					<%
					Long ptLong = (Long)pageContext.getAttribute("paidTime");
					Date ptDate = new Date(ptLong*1000);
					pageContext.setAttribute("ptDate", ptDate );
					System.out.println("ptDate::"+ptDate);
					%>
				
					<!-- 자바에서 받은 date타입 값을 fmt이용하여 2023-04-12형태로 변환 -->
			    	<td><fmt:formatDate pattern="yyyy-MM-dd HH:mm" value="${ptDate}"/></td>
				</tr>
			</c:forEach>
			
		</table>

			
			
			 
			
	</div>

</div>
</body>
</html>