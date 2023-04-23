<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<title>매니저페이지</title>
<link href="${path}/static/style/manager/manager10.css" rel="stylesheet" type="text/css" />
	

</head>
  
	<style>
	</style>

<h1 style="font-size: 30px;">신청한 경기 내역</h1>

  <body>

    <div class="container">
      <div class="half-container image-container">
        <img src="/static/img/soccer1.jpg">
      </div>
      <div class="half-container box-container">
      
      
    
        <c:forEach items="${managerList}" var="manager">
          <div class="box">
            <!-- 동적으로 생성되는 상자 -->
            ${manager.stadium}
            ${manager.location}
            ${manager.gametime}
            ${manager.g_status}
            <div class="sub-box">
              <c:if test="${manager.g_status == 0}">
                <button class="green" style="width: 90px;">승인대기</button>
                <button onclick="deleteManager()" class="red" style="width: 90px;">취소신청</button>
              </c:if>
              <c:if test="${manager.g_status == 1}">
            <a href="entry" class="page-link" style="display: flex; flex-direction: column;">
  <button class="grey" style="padding: 10px; height:60%;">확정</button>
  <button class="blue" style="padding: 10px;">명단확인</button>
</a>

             
              </c:if>
            </div>
          </div>
        </c:forEach>
        
    
        
      </div>
    
 </div>
 
    
</body>
<script>
  function deleteManager() {
    if (confirm("취소하시겠습니까?")) {
      alert("취소되었습니다.");
      // 여기에 취소 처리를 위한 로직을 추가할 수 있습니다.
    }
  }
</script>
 
<div>총레코드 수: ${vo.totalRecord }</div>
<div>${vo.totalPage }/${vo.nowPage }</div>
<div class="pagingDiv">
	<ul>
		<c:if test="${vo.nowPage==1}">
			<li>prev</li>
		</c:if>
		<c:if test="${vo.nowPage>1}">
			<li><a href="manager10?nowPage=${vo.nowPage-1 }<c:if test="${not empty vo.searchWord}">&amp;searchKey=${vo.searchKey}&amp;searchWord=${vo.searchWord}</c:if>">prev</a></li>
		</c:if>
		<c:forEach var="p" begin="${vo.startPageNum}" end="${vo.endPageNum }">
			<li><c:if test="${p==vo.nowPage }"><span>${p}</span></c:if>
				<c:if test="${p!=vo.nowPage }"><a href="manager10?nowPage=${p }<c:if test="${not empty vo.searchWord}">&amp;searchKey=${vo.searchKey}&amp;searchWord=${vo.searchWord}</c:if>">${p}</a></c:if>
			</li>
		</c:forEach>
		<c:if test="${vo.nowPage<vo.totalPage }"><!-- 다음페이지가 있을 때 -->
			<li><a href="manager10?nowPage=${vo.nowPage + 1 }<c:if test="${not empty vo.searchWord}">&amp;searchKey=${vo.searchKey}&amp;searchWord=${vo.searchWord}</c:if>">next</a></li>
		</c:if>
		<c:if test="${vo.nowPage==vo.totalPage }">
			<li>next</li>
		</c:if>
	</ul>
</div>
</html>
