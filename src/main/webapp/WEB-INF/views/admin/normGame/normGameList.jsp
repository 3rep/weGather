<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<div class="container" id="normlist_container">
	<h2 id="page-title">일반경기 목록</h2>
	<table>
        <tr>
            <th>경기번호</th>
            <th>종목</th>
            <th>구장이름</th>
            <th>경기일정</th>
            <th>이용시간</th>
            <th>1인당 결제금액</th>
            <th>경기상태</th>
        </tr>
		<c:forEach var="normGame" items="${normGameList}">
			<tr>
				<td>${normGame.no}</td>
				<td>${normGame.sportname}</td>
				<td><a href="edit?no=${normGame.no}" class="stadium">${normGame.stadium}</a></td>
				<td><fmt:formatDate pattern="yyyy년 MM월 dd일 E요일 HH:mm" value="${normGame.gametime}" /></td>
				<td>${normGame.usetime}</td>
				<td>${normGame.payment} 원</td>
				<td>
					<c:set var="status" value="${normGame.g_status}"/>
					<c:choose>
						<c:when test="${status==0}">
			            	미개설
						</c:when>
			         	<c:when test="${status==1}">
			            	대기
			         	</c:when>
			         	<c:when test="${status==2}">
			            	확정
			         	</c:when>
			         	<c:when test="${status==3}">
			            	취소
			         	</c:when>
			      	</c:choose>
				</td>
        	</tr>
		</c:forEach>
	</table>
	<a href="${path}/admin/game/new" class="btn-black new-game">경기 등록</a>
</div>
</body>
</html>