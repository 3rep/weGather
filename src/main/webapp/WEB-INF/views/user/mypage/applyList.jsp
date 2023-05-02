<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
	<script>
	$(function(){
		//웹에서 날짜 선택시 자동 제출	
		$("#aplSelect").on("change",function(){
			$("#aplSelect").submit();
		});
	});
	
	</script>
	<!-- 오른쪽 내용칸 -->
	<div id="applyListContent"> 
		<h3 class="aplh3">신청경기</h3>
		<hr/>
		<div class="aplBtn">
			<button class="applyListBtn" id="all" onclick="location.href='applyList'">전 체</button>
			<button class="applyListBtn" id="rank" onclick="location.href='rankList'">랭킹전</button>
			<button class="applyListBtn" id="norm" onclick="location.href='normList'">일반전</button>	
			<!-- 날짜 필터링 : 달력에서 클릭한 값이 DB로 들어감 = DTO에 들어감 : gametime과 비교하는 쿼리문 쓰면 됨 -->
			<form id="aplSelect" method="post" action="applyList">
				<input type="date" name="aplSelectedDate" class="aplDate" value="" />
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
				        <td>${list.stadium }</td> 
				       
				        <!--g_status에 따라 경기상태 변경
				        
				        랭크경기 : 2(취소)/1(확정)/0(대기) 
							경기취소 = 랭크경기에서 인원이 안차서 취소될떄 : g_status=2 
							신청완료, 신청취소 : gametime 이틀전까지 + g_status=0 
							경기확정 : g_status=1 + gametime이 현재날짜를 지나지 않은 경우
							경기종료 : g_status=1 + gametime이 현재날짜를 지난경우 
						
						일반경기 : 3(취소)/2(확정)/1(개설 및 대기)/0(미개설)
							경기취소 : g_status=3
							신청완료, 신청취소 : gametime 이틀전(gt2ago >= now) + g_status=1
							경기확정 : g_status = 2 + gametime >=now
							경기종료 : g_status= 2+ gametime < now
						-->
						
				        <!-- 신청완료(취소), 경기확정의 경우 경기세부정보페이지로 이동링크 건다. 
				        		랭크경기, 일반경깅 구분해서 링크달아야해  -->
					<c:choose>
				       		<c:when test="${list.no>1000 }"> 
						        <c:if test="${list.g_status==2}">	
						        	<td class="aplStatus">경기취소</td>
						        </c:if>
						        <c:if test="${list.g_status==1 && list.gametime<now }">	
						        	<td class="aplStatus">경기종료
						        </c:if>
						        <c:if test="${list.g_status==0 && list.gt2ago>now }">	
						        	<td class="aplLink">
						        		<a href="/rankgame/detail?no=${list.no }" class="linkToGame">신청완료(취소)</a>
						        	</td>
						        </c:if>
						        <c:if test="${list.g_status==1 && list.gametime>=now }">	
						        	<td class="aplLink">
						        		<a href="/rankgame/detail?no=${list.no }" class="linkToGame">경기확정</a>
						        	</td>
						        </c:if>
					    	</c:when>
					    	<c:when test="${list.no<1000 }">    
					        	<c:if test="${list.g_status==3}">	
						        	<td class="aplStatus">경기취소</td>
						        </c:if>
						        <c:if test="${list.g_status==2 && list.gametime<now }">	
						        	<td class="aplStatus">경기종료
						        </c:if>
						        <c:if test="${list.g_status==1 && list.gt2ago>now }">	
						        	<td class="aplLink">
						        		<a href="/normgame/detail?no=${list.no }" class="linkToGame">신청완료(취소)</a>
						        	</td>
						        </c:if>
						        <c:if test="${list.g_status==2 && list.gametime>=now }">	
						        	<td class="aplLink">
						        		<a href="/normgame/detail?no=${list.no }" class="linkToGame">경기확정</a>
						        	</td>
						        </c:if>
				        	</c:when>
				        </c:choose>
				    </tr>
			    </c:forEach>
		    </tbody>
		</table>
		
		<!-- 페이징 -->
		<div class="pagingDiv">
		<ul>
			<!-- 이전페이지 -->
			<c:if test="${vo.nowPage>1}">
				<li><a href="applyList?nowPage=${vo.nowPage-1}">이전</a></li>
			</c:if>
			<!-- 페이지번호 -->
			<c:forEach var="pageNum" begin="${vo.startPageNum}" end="${vo.startPageNum+(vo.onePageNumCount-1)}" step="1">
				<c:if test="${pageNum<=vo.totalPage}">
					<li>
					<c:if test="${vo.nowPage==pageNum }"><b></c:if>
					<a href="applyList?nowPage=${pageNum}">${pageNum}</a>
					<c:if test="${vo.nowPage==pageNum }"></b></c:if>
					</li>
				</c:if>
			</c:forEach>
			<!-- 다음페이지 -->
			<c:if test="${vo.nowPage<vo.totalPage}">
				<li><a href="applyList?nowPage=${vo.nowPage+1}">다음</a></li>
			</c:if>
		</ul>
		</div>
	</div>