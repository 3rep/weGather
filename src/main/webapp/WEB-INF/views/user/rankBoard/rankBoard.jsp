<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://code.jquery.com/jquery-3.6.0.min.js" crossorigin="anonymous"></script>
<link href="${path}/static/style/style.css" rel="stylesheet" type="text/css" />
<link href="${path}/static/style/user/rankboard/rankBoard.css" rel="stylesheet" type="text/css" />
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
	// 함수 초기화
	rankBoardCtrl.init();
	
	});
	
	var listData = []
		, totalCnt
		, limit = 10
		, currPage = 1
		, maxPage
	;
	
	const rankBoardCtrl = {
		init : () => {
			rankBoardCtrl.evthandler();
			rankBoardCtrl.getList();
		},
		evthandler : () => {
			// 페이지네이션 버튼 이벤트
			$(document).on('click', '.paginate-button', function() {
				rankBoardCtrl.renderTableRow($(this).data('id'), listData);
			});
			// 검색 이벤트
			$(document).on('click', '#submit-btn', function() {
				rankBoardCtrl.searchToText();
			});
			// 종목검색 이벤트
			$(document).on('change', '#sportname', function(e) {
				rankBoardCtrl.searchToSelect(e);
			});
		},
		getList : () => {
			$.ajax({
	            type : "GET",
	            url : "/user/rankBoard/list",
	            dataType: 'json',
	            success : function(res){
	            	console.log(res)
	
	            	listData = res;
	            	totalCnt = res.length;
	            	maxPage = Math.ceil(res.length / limit);
	            	
	            	// 버튼 생성
	            	rankBoardCtrl.renderPaginationButton();
	            	// 리스트 생성
	            	rankBoardCtrl.renderTableRow(currPage, listData);
	            },
	            error : function(XMLHttpRequest, textStatus, errorThrown){
	            	console.log(XMLHttpRequest);
	                alert("실패.");
	            }
	        });
		},
		// 페이지네이션 버튼 생성
		renderPaginationButton : () => {
			// 버튼 리스트 초기화
		  	while ($('.pagination li').length) { $('.pagination').empty(); }
		 	// 화면에 최대 5개의 페이지 버튼 생성
		    for (let id = currPage; id < currPage + 5 && id <= maxPage; id++) {
		    	$('.pagination').append('<li class="paginate-button" data-id="'+id+'">'+id+'</li>');
		    }
		 	
		},
		renderTableRow : (page, list) => {
			var table = $('.rankboard-table tbody');
			// 목록 리스트 초기화
			while ($('.rankboard-table tbody tr').length) { table.empty(); }
			// 글의 최대 개수를 넘지 않는 선에서, 화면에 최대 10개의 글 생성
			for (let id = (page - 1) * 10; id < page * 10 && id <= totalCnt - 1; id++) {
				table.append(rankBoardCtrl.makeContent(id, list));
			}
		},
		makeContent : (id, list) => {
			return '<tr '+ rankBoardCtrl.tableRowCtrl(id, list) +'>'
				   + ''+ rankBoardCtrl.rankData(id, list) +''
				   + '<td>'+list[id].userid+'</td>'
				   + '<td class="tc">'+list[id].sportname+'</td>'
				   + '<td class="tc">'+list[id].rank_avg+'</td>'
				   + '<td class="tc">'+rankBoardCtrl.tierData(id, list)+'</td>'
				   + '</tr>';
		},
		tableRowCtrl : (id, list) => {
			return list[id].rnum < 4 ? 'class="blue"' : '';
		},
		rankData : (id, list) => {
			if(list[id].rnum === 1) {
				return '<td class="tc rank"><img alt="1등" src="${path}/static/img/rankBoard/1st.png"/><span class="num">'+ list[id].rnum +'</span></td>';  
			} else if(list[id].rnum === 2) {
				return '<td class="tc rank"><img alt="2등" src="${path}/static/img/rankBoard/2st.png"/><span class="num">'+ list[id].rnum +'</span></td>';
			} else if(list[id].rnum === 3) {
				return '<td class="tc rank"><img alt="3등" src="${path}/static/img/rankBoard/3st.png"/><span class="num">'+ list[id].rnum +'</span></td>';
			} else {
				return '<td class="tc">'+ list[id].rnum +'</td>';
			}
		},
		tierData : (id, list) => {
			if(list[id].rank_avg >= 5) {
				return '<span style="color:#3682F4;">다이아</span>';  
			} else if(list[id].rank_avg >= 4) {
				return '<span style="color:#20D874;">플래티넘</span>';
			} else if(list[id].rank_avg >= 3) {
				return '<span style="color:#EC9A00;">골드</span>';
			} else if(list[id].rank_avg >= 2) {
				return '<span style="color:#A4A8AD;">실버</span>';
			} else if(list[id].rank_avg >= 1) {
				return '<span style="color:#AD5600;">브론즈</span>';
			} else {
				return '언랭크';
			}
		},
		searchToText : (e) => {
			const value = document.querySelector('input[name="keyword"]').value
				, data = listData.filter((v, i) => v.userid.startsWith(value)) 
			totalCnt = data.length;
			maxPage = Math.ceil(totalCnt / limit);
			if(value) {
				rankBoardCtrl.renderPaginationButton();
				rankBoardCtrl.renderTableRow(1, data);
			} else {
				rankBoardCtrl.renderPaginationButton();
				rankBoardCtrl.renderTableRow(1, listData);
			}
		},
		searchToSelect : (e) => {
			const value = e.target.value
				, data = listData.filter((v, i) => v.sportname.startsWith(value)) 
			totalCnt = data.length;
			maxPage = Math.ceil(totalCnt / limit);
			
			rankBoardCtrl.renderPaginationButton();
			rankBoardCtrl.renderTableRow(1, data);
		}
	}	
</script>	
</head>
<body>
	<div class="img-box">
		<img alt="rankboard" src="${path}/static/img/rankBoard/field.jpg"/>
		<span class="rankboard_title">랭크보드</span>		
	</div>
	<div id="rankboard-container">
		<div class="search_wrap">
			<div class="search_area">
				<div class="search-form">
					<select id="sportname">
						<option value="" selected>종목 전체</option>
						<option value="풋살">풋살</option>
						<option value="축구">축구</option>
						<option value="야구">야구</option>
						<option value="농구">농구</option>
					</select>
					<input id="search-word" type="text" name="keyword" placeholder="  아이디 랭킹검색">
					<button id="submit-btn" type="button">검색</button>
				</div>
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
					<%-- 	<td class="tc">
							<c:choose>
								<c:when  class="dia" test="${ranklist.rank_avg ge 5}">
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
						</td> --%>
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