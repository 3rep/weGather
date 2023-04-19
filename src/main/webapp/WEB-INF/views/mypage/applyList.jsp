<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!-- 오른쪽 내용칸 -->
	<div id="content"> 
		<h3>신청경기</h3><br/>
		<hr/>
		<!-- <select name="listFilter">
			<option value="latest">최신순</option>
			<option value="ordest">오래된순</option>
		</select> -->
		
		<!-- 테이블 -------------------------------------------------------->
		<table>
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

			    <!-- 서버에서 넘어온 list에 담긴 DTO를 gametime 최신순으로 정렬 -->
			    <c:forEach var="list" items="${list }">
				    <tr>
				    	<!-- 경기유형: 랭크->4자리수 / 일반-> 3자리수 -->
				    	<c:if test="${list.no>1000 }">
					    	<td class="rg" >
								랭킹
							</td>
						</c:if>
						<c:if test="${list.no<1000 }">
							<td class="ng">
								일반
							</td>
						</c:if>
						
						
				        <td>${list.sportname }</td>
				        <td><fmt:formatDate pattern="yyyy-MM-dd HH:mm" value="${list.gametime }"/></td>
				        <td><a href="">${list.stadium }</a></td>
				        
				        <!-- g_status : 2(취소)/1(확정)/0(대기) -->
					    <!-- 경기취소 = 랭크경기에서 인원이 안차서 취소될떄 : g_status=2 -->
					    <!-- 신청완료, 신청취소 : gametime 이틀전까지 + g_status=1 -->
					    <!-- 경기종료 : g_status=1 + gametime이 현재날짜를 지난경우 -->  
					 
					    <!-- 현재시간 구하기 -->
			 		 	<c:set var="today" value="<%=new java.util.Date()%>" />
			  		  	<c:set var="date"><fmt:formatDate value="${today}" pattern="yyyy-MM-dd hh:mm" /></c:set> 
					  
					    <td>
						    <c:if test="${list.g_status==2 }">
						    	경기취소
						    </c:if>
						     <c:if test="${list.g_status==1}"> <!-- 이틀전까지 어떻게 나타내지!!! -->
						    	신청완료 / 신청취소
						    </c:if>
						    <c:if test="${list.g_status==1 && list.gametime<date}"> <!-- 얘도 이상한데? -->
						    	경기종료
						    </c:if>
						</td>
						    
				    </tr>
			    </c:forEach>
		    
		    </tbody>
		</table>
		
		<!-- --------------------------------------------------------- -->
		
		
		<div>
		<%-- map 데이터 넘어오기 테스트중
		<c:set var="gametime" value="${ list.gametime}"/>
		[[[   ${gametime } ]]]] --%>
		</div>
		
		</div>
	</div>
</body>
</html>