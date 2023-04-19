<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!-- 오른쪽 내용칸 -->
	<div id="content"> 
		<h3>신청경기</h3><br/>
		<hr/>
		<select name="listFilter">
			<option value="latest">최신순</option>
			<option value="ordest">오래된순</option>
		</select>
		
		<!-- 테이블 -------------------------------------------------------->
		<table>
		    <thead>
		    <tr>
		        <th>번호</th>
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
			        <td>100</td>
			        <td>${list.sportname }</td>
			        <td><fmt:formatDate pattern="yyyy-MM-dd HH:mm" value="${list.gametime }"/></td>
			        <td><a href="">${list.stadium }</a></td>
			        <td>신청완료 신청취소</td>
			    </tr>
		    </c:forEach>
		    
		    <tr>
		        <td>99</td>
		        <td>달리기</td>
		        <td>2023-03-31</td>
		        <td><a href="">운동장직운직운동장직운동장직운동장직운동장직운동장직운동장직운동장직운동장직운동장</a></td>
		        <td>경기종료</td>
		    </tr>
		    <tr>
		        <td>98</td>
		        <td>둥글게</td>
		        <td>2023-01-01</td>
		        <td><a href="">서울시</a></td>
		        <td>경기종료</td>
		    </tr>
		    
		    </tbody>
		</table>
		
		<!-- --------------------------------------------------------- -->
		
		
		<div>
		map 데이터 넘어오기 테스트중
		${map }
			<c:forEach var="testmap" items="${map }">
				<li>${testMap.key} : ${testMap.value }</li>
				
				
			</c:forEach>
		</div>
		
		</div>
	</div>
</body>
</html>