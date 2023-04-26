<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!-- 오른쪽 내용칸 -->
	<div id="applyListContent"> 
		<h3>신청경기</h3><br/>
		<hr/>
		<button class="applyListBtn" id="all" onclick="location.href='applyList'">전체</button>
		<button class="applyListBtn" id="rank" onclick="location.href='rankList'">랭킹전</button>
		<button class="applyListBtn" id="norm" onclick="location.href='normList'">일반전</button>	
		
		<!-- 테이블 -------------------------------------------------------->
		<table id="table">
			<colgroup>
	        	<col width="8%" />
	        	<col width="8%" />
	        	<col width="15%" />
	        	<col width="25%" />
	        	<col width="5%" />
	        </colgroup>
		    <thead>
		    <tr>
		    	<th>유형</th>
		        <th>종목</th>
		        <th>날짜</th>
		        <th>경기명(구장명)</th>
		        <th>상태</th>
		
		    </tr>
		    </thead>
		    <tbody>

			    <c:forEach var="list" items="${list }">
				    <tr>
				    	<td class="rg">랭킹</td>
				        <td>${list.sportname }</td>
				        <td><fmt:formatDate pattern="yyyy-MM-dd HH:mm" value="${list.gametime }"/></td>
				        <td><a href="">${list.stadium }</a></td>
				       
				       <!--g_status : 2(취소)/1(확정)/0(대기) 
						경기취소 = 랭크경기에서 인원이 안차서 취소될떄 : g_status=2 
						신청완료, 신청취소 : gametime 이틀전까지 + g_status=0 
						경기확정 : g_status=1
						경기종료 : g_status=1 + gametime이 현재날짜를 지난경우    -->
				        <c:if test="${list.g_status==2}">	
				        	<td>경기취소</td>
				        </c:if>
				        <c:if test="${list.g_status==0 && (list.gametime>list.gt2ago) }">	
				        	<td>신청완료/신청취소</td>
				        </c:if>
				        
				        <c:if test="${list.g_status==1 && list.gametime<now }">	
				        	<td>경기종료</td>
				        </c:if>
				        <c:if test="${list.g_status==1 && list.gametime>=now }">	
				        	<td>경기확정</td>
				        </c:if>
				         
				    </tr>
			    </c:forEach>
		    </tbody>
		</table>
		
		<!-- --------------------------------------------------------- -->
		
</div>
</body>
</html>