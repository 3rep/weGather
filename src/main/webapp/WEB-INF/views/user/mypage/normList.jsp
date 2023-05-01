<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

	<!-- 오른쪽 내용칸 -->
	<div id="applyListContent"> 
		<h3 class="aplh3">신청경기</h3>
		<hr/>
		<div class="aplBtn">
			<button class="applyListBtn" id="all" onclick="location.href='applyList'">전 체</button>
			<button class="applyListBtn" id="rank" onclick="location.href='rankList'">랭킹전</button>
			<button class="applyListBtn" id="norm" onclick="location.href='normList'">일반전</button>	
			<form id="aplSelect" method="get" action="applyList">
				<input type="date" name="aplSelectedDate" class="aplDate" />
			</form>	
		</div>
			
		<!-- 테이블 -------------------------------------------------------->
		<table id="aplTable">
		    <thead id="aplThead">
		    <tr id="aplThTr">
		    	<th class="aplTh">유형</th>
		        <th class="aplTh">종목</th>
		        <th id="aplDate">날짜</th>
		        <th id="aplStadium">경기명(구장명)</th>
		        <th id="aplStatus" >상태</th>
		    </tr>
		    </thead>
		    <tbody class="aplTbody">
			    <c:forEach var="list" items="${list }">
				    <tr id="aplTbTr" >
				    	<td class="ng">일반</td>
				        <td>${list.sportname }</td>
				        <td><fmt:formatDate pattern="yyyy-MM-dd HH:mm" value="${list.gametime }"/></td>
				        <td>${list.stadium }</td>
				     
				       <!--g_status : 3(취소)/2(확정)/1(대기)/0(미개설) -->
				        <c:if test="${list.g_status==3}">	
				        	<td class="aplStatus">경기취소</td>
				        </c:if>
				        <c:if test="${list.g_status==2 && list.gametime<now }">	
				        	<td class="aplStatus">경기종료
				        </c:if>
				        <c:if test="${list.g_status==1 && (list.gt1ago>now) }">	
				        	<td class="aplLink">
				        		<a href="/normgame/detail?no=${list.no }" class="linkToGame">신청완료(취소)</a>
				        	</td>
				        </c:if>
				        <c:if test="${list.g_status==2 && list.gametime>=now }">	
				        	<td class="aplLink">
				        		<a href="/normgame/detail?no=${list.no }" class="linkToGame">경기확정</a>
				        	</td>
				        </c:if>
				    </tr>
			    </c:forEach>
		    </tbody>
		</table>
	</div>
