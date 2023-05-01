<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha384-GsWP7a9Kj6EuHYsXsLK9TC6Z9gGnU6ZL2/KuZrHdPYojIuBm+qn8XoPmOf4NMWPG" crossorigin="anonymous"></script>
<script>	
	$(function(){
		// 이전 검색 정보 유지
	    var sportname = "${param.sportname}";
	    $("#sportname").val(sportname);
	    
	    //페이지네이션
		$(".paginate-button a").on("click", function(e){
			e.preventDefault();//페이지이동 무시 시킨다.
			$("#pageNum").val($(this).attr("href"));
			$("#actionForm").submit();
		});
	    
	    //검색
		$("#search-form").submit(function(e) {
		      e.preventDefault();
		      var sportname = $("#sportname").val();
		      var keyword = $("#search-word").val();
		      $("#actionForm input[name=sportname]").val(sportname);
		      $("#actionForm input[name=keyword]").val(keyword);
		      $("#actionForm input[name=pageNum]").val(1);
		      $("#actionForm").submit();
		});
		$("#sportname").on("change", function() {
		    $("#search-form").submit();
		});
	});
	
</script>	

<style>
/*테이블*/
	.tc {text-align: center;}
	#rankboard-container {flex:auto;padding:40px 78px;height:auto;width:1200px;margin:0 auto;}
	#rankboard-container h1 {font-size:32px;margin: 0 0 57px 0;}
	.rankboard-table {border-collapse:collapse;border-top: 2px solid #eee;border-spacing:0;width:100%;color: #757575; margin-bottom: 5px;}
	.rankboard-table th, td {padding:6px 15px;}
	.rankboard-table thead th {height: 40px;font-size: 12px;font-weight: 300;}
	.rankboard-table tbody tr {height: 50px;background-color: #fff;border-bottom: 1px solid #fff;}
	.rankboard-table tbody tr:nth-child(odd) {background-color: #fafafa;}
	.blue{background-color:#ebf9ff !important;}
	.tc.rank{position:relative;}
	.tc .num {position: absolute;left:33px;top:10px;}
	.tc.rank img{position:absolute;left:21px;top:4px;}	
	
/*검색,필터*/
	.search_area form {height:50px;display: flex; align-items: center; margin-bottom:10px;}		
	.search_area form * {height:40px;background-color:#fff;border:1px solid #e1e1e5;margin:5px 20px 5px 0px;}
	.search_area form select {width: 110px;}
	
	#search-word {width:500px;margin-left: auto;margin-right:0px; margin-left:346px;padding:0px;border-right: 0px;}
	#submit-btn {width:60px;font-size:14px;font-family:'Noto Sans', 'Noto Sans KR', -apple-system, BlinkMacSystemFont, Roboto, Arial, sans-serif; color:#000000; font:bold;margin:0; padding:0;border-left: 0px;}
	.search_area form select {height: 40px;}
	#sportname {margin-top:5px;margin-left:0px;font-size:16px;font-family:'Noto Sans', 'Noto Sans KR', -apple-system, BlinkMacSystemFont, Roboto, Arial, sans-serif;color:#000000;}
	
/* 페이지네이션 */
	.pagination-container{margin-top:13px;}
	.pagination-container ul {list-style:none;display:flex;justify-content:center;align-items:center;}
	.pagination li {margin:0 5px;border:1px solid #ccc;padding:5px 10px;}
	.pagination li.active {background-color:gray;border-color:#F8F9FB;}
	.pagination li:hover {background-color:#F8F9FB;}
	.pagination li a {color:black;}
	.pagination li.active a {color:white;}
	.pagination li:hover a {color:black;font-weight:bold;text-decoration:underline;}	

/*비디오*/
	.video-box{width:100%; height:230px; overflow:hidden; margin:0px; position:relative;opacity: 0.8;}
	video{width:100%; position:absolute; top:50%; left:50%; transform:translate(-50%,-50%);}
</style>
</head>
<body>
	<div class="video-box">
			<video muted autoplay loop>
				<source type="video/mp4" src="${path}/static/video/rankBoard/rankboard.mp4">
			</video>
	</div>
	<div id="rankboard-container">
		<div class="search_wrap">
			<div class="search_area">
				<form id="search-form" action="/user/rankBoard/rankBoard" method="get">
					<select id="sportname">
						<option value="" selected>종목 전체</option>
						<option value="풋살">풋살</option>
						<option value="축구">축구</option>
						<option value="야구">야구</option>
						<option value="농구">농구</option>
					</select>
					<input id="search-word" type="text" name="keyword" placeholder="  아이디 랭킹검색">
					<button id="submit-btn" type="submit">검색</button>
				</form>
			</div>
		</div>
		<div>
			<table class=rankboard-table>
				<colgroup>
					<col style="width: 7%"/>
					<col style="width: 50%"/>
					<col style="width: 15%"/>
					<col style="width: 15%"/>
					<col style="width: 15%"/>
				</colgroup>
				<thead>
					<tr>
						<th class="tc">순위</th>
						<th>아이디</th>
						<th class="tc">종목</th>
						<th class="tc">평점</th>
						<th class="tc">랭크</th>
					</tr>
				</thead>
				<tbody>
				<c:forEach var="ranklist" items="${ranklist }"> 
					<tr class="${ranklist.rnum < 4?'blue':'' }">
						<c:choose>
							<c:when test="${ranklist.rnum==1 }">
								<td class="tc rank"><img alt="1등" src="${path}/static/img/rankBoard/1st.png"/><span class="num">${ranklist.rnum }</span></td>
							</c:when>
							<c:when test="${ranklist.rnum==2 }">
								<td class="tc rank"><img alt="2등" src="${path}/static/img/rankBoard/2st.png"/><span class="num">${ranklist.rnum }</span></td>
							</c:when>
							<c:when test="${ranklist.rnum==3 }">
								<td class="tc rank"><img alt="3등" src="${path}/static/img/rankBoard/3st.png"/><span class="num">${ranklist.rnum }</span></td>
							</c:when>
							<c:otherwise>
								<td class="tc">${ranklist.rnum }</td>
							</c:otherwise>
						</c:choose>
						<td>${ranklist.userid }</td>
						<td class="tc">${ranklist.sportname }</td>
						<td class="tc">${ranklist.rank_avg }</td>
						<td class="tc">
							<c:choose>
								<c:when test="${ranklist.rank_avg ge 5}">
									다이아
								</c:when>
								<c:when test="${ranklist.rank_avg ge 4}">
									플레티넘
								</c:when>
								<c:when test="${ranklist.rank_avg ge 3}">
									골드
								</c:when>
								<c:when test="${ranklist.rank_avg ge 2}">
									실버
								</c:when>
								<c:when test="${ranklist.rank_avg ge 1}">
									브론즈
								</c:when>
								<c:otherwise>
									언랭
								</c:otherwise>
							</c:choose>
						</td>
					</tr>
				</c:forEach>
				</tbody>
			</table>
			<!-- 페이지네이션 -->
					<div class="pagination-container">
                    	<ul class="pagination">
                    		<c:if test="${pageMaker.prev }">
                    			<!-- 이전 페이지 : 시작페이지가 1~10이 아닌 경우 보임 -->
                    			<li class="paginate-button previous"><a href="${pageMaker.startPage-1 }">이전</a></li>
                    		</c:if>
	
							<c:forEach begin="${pageMaker.startPage }" end="${pageMaker.endPage }" var="num">
                    			<li class="paginate-button ${pageMaker.criteria.pageNum == num ? 'active':''}"><a href="${num }">${num }</a></li>
							</c:forEach>
                    		
                    		<c:if test="${pageMaker.next }">
                    			<!-- 다음 페이지 : 끝페이지가 마지막 페이지가 아닌 경우 보임. 끝페이지의 다음페이지로 이동 -->
                    			<li class="paginate-button next"><a href="${pageMaker.endPage+1 }">다음</a></li>
                    		</c:if>
                    	</ul>
                    </div>
                    <!--end 페이지네이션 -->
		</div>
	</div>
	<!-- 페이지네이션 클릭시 페이지이동 -->
	<form id="actionForm" action="/user/rankBoard/rankBoard" method='get'>
		<!-- 클릭한 href에 들어있는 이동 페이지 번호로 바꿔준다 -->
		<input id="pageNum" type="hidden" name="pageNum" value="${pageMaker.criteria.pageNum }"> 
		<input type="hidden" name="amount" value="${pageMaker.criteria.amount }">
		<input type="hidden" name="keyword" value="${pageMaker.criteria.keyword }"> 
		<input type="hidden" name="sportname" value="${param.sportname }">
	</form>  
</body>
</html>