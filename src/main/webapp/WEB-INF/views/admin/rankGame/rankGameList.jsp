<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<div class="container" id="ranklist_container">
	<h2 id="page-title">랭크경기 목록</h2>
	<table>
        <tr>
            <th>경기번호</th>
            <th>종목</th>
            <th>구장이름</th>
            <th>경기일정</th>
            <th>매니저</th>
            <th>경기상태</th>
        </tr>
		<c:forEach var="rankGame" items="${rankGameList}">
			<tr>
				<td>${rankGame.no}</td>
				<td>${rankGame.sportname}</td>
				<td><a href="edit/no=${rankGame.no}" class="stadium">${rankGame.stadium}</a></td>
				<td><fmt:formatDate pattern="yyyy년 MM월 dd일 E요일 HH:mm" value="${rankGame.gametime}" /></td>
				<td>${rankGame.managerid}</td>
				<td>
					<c:set var="status" value="${rankGame.g_status}"/>
					<c:choose>
						<c:when test="${status==0}">
			            	대기
						</c:when>
			         	<c:when test="${status==1}">
			            	확정
			         	</c:when>
			         	<c:when test="${status==2}">
			            	취소
			         	</c:when>
			      	</c:choose>
				</td>
        	</tr>
		</c:forEach>
	</table>
	<a href="new" class="btn-black new-game">경기 등록</a>
</div>
</body>
</html>