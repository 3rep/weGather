<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!-- 오른쪽 내용칸 -->
	<div id="content"> 
		<h3>신청경기</h3><br/>
		<hr/>
		
		<a href="applyList" title="Button border blue/green" class="button btnBorder btnBlueGreen" id="all">전체</a>
    	<a href="rankList" title="Button border orange" class="button btnBorder btnOrange" id="rank">랭킹전</a>
		<a href="normList" title="Button border lightblue" class="button btnBorder btnLightBlue" id="norm">일반전</a>
		
		
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
	
</div>
</body>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script> 
</html>