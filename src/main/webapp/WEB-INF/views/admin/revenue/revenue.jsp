<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<div class="container">
	<h2 id="page-title">수입 내역</h2>
	<div class="revenue_container">
		
		<ul class="revenue">
			
			<li id="payment_no">결제번호</li>
			<li id="payer_name">입금 내역</li>
			<li id="paid_amount">금액</li>
			<li id="pay_success">결제 성공 여부</li>
			<li id="paid_at">등록일</li>
			 
			<c:forEach var="user_pay" items="${pay}">
				<li>${user_pay.payment_no}</li>
				<li>${user_pay.payer_name}</li>
				<li>${user_pay.paid_amount}</li>
				<li>${user_pay.success}</li>
				<!---- unix타입스탬프 -> 2023-04-12형태로 변환하기 ----->
		    	
		    	<c:set var="paidTime" value="${user_pay.paid_at}" />
				<%
				Long ptLong = (Long)pageContext.getAttribute("paidTime");
				Date ptDate = new Date(ptLong*1000);
				pageContext.setAttribute("ptDate", ptDate );
				System.out.println("ptDate::"+ptDate);
				%>
			
				<!-- 자바에서 받은 date타입 값을 fmt이용하여 2023-04-12형태로 변환 -->
		    	<fmt:formatDate pattern="yyyy-MM-dd HH:mm" value="${ptDate}"/>
		
			</c:forEach>
		</ul>
	</div>

</div>
</body>
</html>