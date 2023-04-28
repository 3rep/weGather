<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="${path}/static/style/style.css" rel="stylesheet" type="text/css" />
<style>
#settlement-container {
	flex: auto;
	padding: 76px 78px;
	height: 100vh;
	overflow-y: auto;
}

#settlement-container h1 {
	font-size: 32px;
	margin: 0 0 57px 0;
}

table {
	border-collapse: separate;
	border-spacing: 0;
	width: 100%;
	background-color: #F8F9FB;
}

th, td {
	padding: 6px 15px;
}

.settlement-sum {
	margin-bottom: 20px;
	border: 1px solid #c6c9cc;
	border-radius: 6px;
}
.settlement-table th {
	background: #656363;
	color: #fff;
	text-align: center;
}
#td-num, #td-dstatus, #td-amount{
	text-align: center;
}
.settlement-table td {
	border-right: 1px solid #c6c9cc;
	border-bottom: 1px solid #c6c9cc;
}

td:first-child {
	border-left: 1px solid #c6c9cc;
}

tr:first-child th:first-child {
	border-top-left-radius: 6px;
}

tr:first-child th:last-child {
	border-top-right-radius: 6px;
}

tr:last-child td:first-child {
	border-bottom-left-radius: 6px;
}

tr:last-child td:last-child {
	border-bottom-right-radius: 6px;
}
/* 페이지네이션 */
ul.pagination {
	list-style: none;
	display: flex;
	justify-content: center;
	align-items: center;
}

ul.pagination li {
	margin: 0 5px;
	border: 1px solid #ccc;
	padding: 5px 10px;
}

ul.pagination li.active {
	background-color: black;
	border-color: #F8F9FB;
}

ul.pagination li:hover {
	background-color: #F8F9FB;
}

ul.pagination li a {
	color: black;
}

ul.pagination li.active a {
	color: white;
}

ul.pagination li:hover a {
	color: black;
	font-weight: bold;
	text-decoration: underline;
}
/*검색,필터*/
.search_area form {
    display: flex;
    flex-direction: row;
    align-items: center;
    height: 50px;
}

.search_area form * {
    margin-top:5px;
    margin-right: 20px;
    margin-bottom: 5px;
    margin-left: 0px;
}
.search_wrap{
	margin-bottom: 10px;
}
#search-word, #submit-btn, #search-date, #sort-by{
	height:40px;
	background-color: #F8F9FB;
	border: 1px solid #c6c9cc;
	border-radius: 6px;
}
#search-word{
	width:500px;
}
#submit-btn{
	width:60px;
	font-size:13px;
	font-family: 'Noto Sans KR', sans-serif;
}
#search-date{
	width:200px;
}
#check-status{
	width:15px;
	height:15px;
}
#sort-by {
	display:flex;
	align-items:center;
}
#sort-by span{
	font-size:13px;
	font-family: 'Noto Sans KR', sans-serif;
	margin-left:7px;
}
</style>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script>
<!--페이지네이션-->
	$(function(){
		$(".paginate-button a").on("click", function(e){
			e.preventDefault();//페이지이동 무시 시킨다.
			$("#pageNum").val($(this).attr("href"));
			$("#actionForm").submit();
		});
	
		//웹에서 날짜 선택시 자동 제출	
		$("#search-date").on("change",function(){
			$("#search-form").submit();
		});
		
		//입금상태 체크시, 자동 제출
		$("#check-status").on("change",function(){
			$("#search-form").submit();	
		}); 
		
	});
	
</script>
</head>
<body>
	<div id="settlement-container">
		<h1>정산 내역</h1>
		<div class="search_wrap">
			<div class="search_area">
				<form id="search-form" action="/manager/settlement" method="get">
					<input id="search-word" type="text" name="keyword" placeholder="검색어를 입력해주세요">
					<button id="submit-btn"type="submit">검색</button>
					<input id="search-date" type="date" name="datetime">
					<label id="sort-by"><span> 정렬기준 : 입금 완료</span><input id="check-status"type="checkbox" name="dStatusOrder"></label>
				</form>
			</div>
		</div>
		<div>
			<table class=settlement-sum>
				<tr>
					<th>정산완료금액</th>
					<td>${completedamount }원</td>
					<th>정산예정금액</th>
					<td>${inprogressamount }원</td>
				</tr>
			</table>
		</div>                  
		<div>
			<table class=settlement-table>
		    <thead>
				    <tr>
				    	<th>순번</th>
				      	<th>참여경기</th>
				     	 <th>경기날짜</th>
				     	 <th>입금상태</th>
				     	 <th>금액</th>
					</tr>
				</thead>
				<!-- 매니저로그인 합치면, mapper에 where절 매니저아이디 추가 -->
				<c:forEach var="settlement" items="${settlement }" varStatus="status">
					<tbody>
						    <tr>
						      <!--<td>${status.count }</td>-->
						      <td id="td-num">${(pageMaker.mscriteria.pageNum-1) * pageMaker.mscriteria.amount + status.count }</td>
						      <td>${settlement.stadium }</td>
						      <td><fmt:formatDate pattern="yyyy년 MM월 dd일 E요일 HH:mm" value="${settlement.gametime }"/></td>
						      <td id="td-dstatus">
						      	<c:choose>
						      		<c:when test="${settlement.d_status == 0 }">처리중</c:when>
						      		<c:when test="${settlement.d_status == 1 }">완료</c:when>
						      	</c:choose>
						      </td>
						      <td id="td-amount">${settlement.amount }원</td>
						    </tr>
				     </tbody>
			     </c:forEach>
		     </table>
		    </div>
			<!-- 페이지네이션 -->
			<ul class="pagination">
				<c:if test="${pageMaker.prev }">
					<!-- 이전 페이지 : 시작페이지가 1~10이 아닌 경우 보임 -->
					<li class="paginate-button previous"><a
						href="${pageMaker.startPage-1 }">Previous</a></li>
				</c:if>
	
				<c:forEach begin="${pageMaker.startPage }"
					end="${pageMaker.endPage }" var="num">
					<li class="paginate-button ${pageMaker.mscriteria.pageNum == num ? "active":""}"><a
						href="${num }">${num }</a></li>
				</c:forEach>
	
				<c:if test="${pageMaker.next }">
					<!-- 다음 페이지 : 끝페이지가 마지막 페이지가 아닌 경우 보임. 끝페이지의 다음페이지로 이동 -->
					<li class="paginate-button next"><a
						href="${pageMaker.endPage+1 }">Next</a></li>
				</c:if>
			</ul>
		<!--end 페이지네이션 -->
	</div>
	<!-- 페이지네이션 클릭시 페이지이동-->
	<form id="actionForm" action="/manager/settlement" method='get'>
		<!-- 클릭한 href에 들어있는 이동 페이지 번호로 바꿔준다 -->
		<input id="pageNum" type="hidden" name="pageNum" value="${pageMaker.mscriteria.pageNum }"> 
		<input type="hidden" name="amount" value="${pageMaker.mscriteria.amount }">
		<input type="hidden" name="keyword" value="${pageMaker.mscriteria.keyword }">
		<input type="hidden" name="datetime" value="${pageMaker.mscriteria.datetime }">
		<input type="hidden" name="dStatusOrder" value="${pageMaker.mscriteria.DStatusOrder}">
	</form> 
	
</body>
</html>