<%@page import="org.apache.ibatis.reflection.SystemMetaObject"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

	<!-- 오른쪽 내용칸 -->
	<div id="paymentListContent"> 
		<h3 class="pmlh3">결제내역</h3>
		<hr/>
		<div class=pmView>
			<input type="date" class="pmDate"/>
		
		</div>
		
		<!-- 결제내역 테이블 -->
		<table id="pmTable">
		    <thead>
			    <tr id="pmThTr">
			    	<th>결제번호</th>
			    	<th>경기일</th>
			        <th>결제금액</th>
			        <th>결제시각</th>
			        <th>상태</th>
			    </tr> 
		    </thead>
		    <tbody>
		    	<c:forEach var="list" items="${list }">
			    	<tr id="pmTbTr">
				    	<td >${list.payment_no }</td>
				    	<td >${list.gametime }</td>
				    	<td class="pmTd">${list.paid_amount }</td>
				    	
				    	<!---- unix타입스탬프 -> 2023-04-12형태로 변환하기 ----->
				    	<c:set var="paidTime" value="${list.paid_at}" />
						<%
						Long paid_at = (Long)pageContext.getAttribute("paidTime");
							System.out.println("paid_at"+paid_at);						
						Date mpPaid_at = new Date(paid_at*1000);
							System.out.println("mpPaid_at"+mpPaid_at);						
						pageContext.setAttribute("mpPaid_at", mpPaid_at );
						
						%>
				    	<td ><fmt:formatDate pattern="yyyy-MM-dd HH:mm" value="${mpPaid_at}"/></td>
				    	
				    	<c:if test="${list.success == 's'}">
				    		<td class="pmTd">결제완료</td>
				    	</c:if>
				    </tr>
		    	</c:forEach>
			    
		    </tbody>
		</table>
	</div><!-- 오른쪽 내용칸 end ------------>
</div>
