<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<link href="${path}/static/style/style.css" rel="stylesheet" type="text/css" />
<html>
<head>
<meta charset="UTF-8">

<style>
		/*테이블*/
		#notice-container {flex:auto;padding:40px 78px;height:auto;width:1400px;margin:0 auto;}
		#notice-container h1 {font-size:32px;margin: 0 0 57px 0;}
		.notice-table {border-collapse:collapse;border-top: 5px solid #eee; border-spacing:0;width:100%;color: #757575; margin-bottom: 5px;}
		.notice-table th, td {padding:6px 15px; font-weight: bold;}
		.notice-table td {border-top: 2px solid #eee;}
		.notice-table thead th {height: 40px;font-size: 18px;font-weight: bold; text-align: center;}
		.notice-table tbody tr {height: 50px;font-size:18px; background-color: #FFF;border-bottom: 2px solid #fff; text-align: center;}
		.td-tag a{color: #757575;}
		.td-tag{text-align: left;}
		
		/*검색,필터*/
		.search-form {position:relative;height:50px;display: flex; align-items: center; margin-bottom:10px;}		
		.search-form input, button {height:40px;background-color:#fff;border:1px solid #e1e1e5;margin:5px 20px 5px 0px;}
		#search-word {position:absolute;left:380px;top:4px;width:458px;margin-left: auto;margin-right:0px; margin-left:346px;padding:0px;border-right: 0px;}
		#submit-btn {position:absolute;left:1184px;top:9px;width:60px;font-size:18px;font-family:'Noto Sans', 'Noto Sans KR', -apple-system, BlinkMacSystemFont, Roboto, Arial, sans-serif; color:#000000; font:bold;margin:0; padding:0;border-left: 0px;}
		
		/* 페이지네이션 */
		.pagination-container{margin-top:13px;}
		.pagination-container ul {list-style:none;display:flex;justify-content:center;align-items:center;}
		.pagination li {margin:0 5px;border:1px solid #ccc;padding:5px 10px;cursor:pointer;}
		.pagination li.active {background-color:gray;border-color:#F8F9FB;}
		.pagination li:hover {background-color:#F8F9FB;}
		.pagination li a {color:black;}
		.pagination li.active a {color:white;}
		.pagination li:hover a {color:black;font-weight:bold;text-decoration:underline;}
</style>
<script>
<!--페이지네이션-->
	$(function(){
		
		$(".paginate-button a").on("click", function(e){
			e.preventDefault();//페이지이동 무시 시킨다.
			$("#pageNum").val($(this).attr("href"));
			$("#actionForm").submit();
		});
	});
</script>
</head>
<body>
<div id="notice-container">
		<div>
			<h2>공지사항</h2>
		</div>
		<div class="search_wrap">
			<div class="search-form">
				<form id="search-btn" action="/board/noticeBoard" method="get">
					<input id="search-word" type="text" name="keyword" placeholder="  게시글 검색">
					<button id="submit-btn" type="submit">검색</button>
				</form>
			</div>	
		</div>
		<div>
			<table class=notice-table>
				<colgroup>
					<col style="width: 15%"/>
					<col style="width: 40%"/>
					<col style="width: 15%"/>
					<col style="width: 30%"/>
				</colgroup>
				<thead>
					<tr>
						<th>글번호</th>
						<th>제목</th>
						<th>글쓴이</th>
						<th>작성일시</th>
					</tr>
				</thead>
				<tbody>
				<c:forEach var="list" items="${list }"> 
					<tr>
						<td>${list.no }</td>
						<td class=td-tag><a href='/board/noticeBoard/detail?no=${list.no}'>${list.title }</a></td>
						<td>${list.adminid }</td>
						<td><fmt:formatDate pattern = "yyyy-MM-dd" value ="${list.writedate }"/></td>
					</tr>
				</c:forEach>
				</tbody>
			</table>
		</div>
		<!-- 페이지네이션 -->
			<div class="pagination-container">
				<ul class="pagination">
					<c:if test="${pageMaker.prev }">
						<!-- 이전 페이지 : 시작페이지가 1~10이 아닌 경우 보임 -->
						<li class="paginate-button previous"><a
							href="${pageMaker.startPage-1 }">Previous</a></li>
					</c:if>
		
					<c:forEach begin="${pageMaker.startPage }"
						end="${pageMaker.endPage }" var="num">
						<li class="paginate-button ${pageMaker.criteria.pageNum == num ? 'active':''}"><a
							href="${num }">${num }</a></li>
					</c:forEach>
		
					<c:if test="${pageMaker.next }">
						<!-- 다음 페이지 : 끝페이지가 마지막 페이지가 아닌 경우 보임. 끝페이지의 다음페이지로 이동 -->
						<li class="paginate-button next"><a
							href="${pageMaker.endPage+1 }">Next</a></li>
					</c:if>
				</ul>
			</div>
		<!--end 페이지네이션 -->
	</div>
	<!-- 페이지네이션 클릭시 페이지이동-->
	<form id="actionForm" action="/board/noticeBoard" method='get'>
		<!-- 클릭한 href에 들어있는 이동 페이지 번호로 바꿔준다 -->
		<input id="pageNum" type="hidden" name="pageNum" value="${pageMaker.criteria.pageNum }"> 
		<input type="hidden" name="amount" value="${pageMaker.criteria.amount }">
		<input type="hidden" name="keyword" value="${pageMaker.criteria.keyword }">
	</form> 
</body>
</html>