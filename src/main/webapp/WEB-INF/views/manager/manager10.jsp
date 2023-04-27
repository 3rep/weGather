<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<title>매니저페이지</title>
<link href="${path}/static/style/manager/manager10.css" rel="stylesheet" type="text/css" />
	
<style>
	.box>div{float:left;}
</style>
</head>
 <body>
  	<h1 style="font-size: 30px; position:relative; left:90px; top:50px;">신청한 경기 내역</h1>
  		
  		 <div class= "box1">
  		 
  		  <div><h3>신청한 경기 수: ${vo.totalRecord }</h3></div>
		 <div></div> </div>
		
 		   <div class="container">
        		<div class="half-container image-container">
            		<img src="/static/img/manager/soccer1.jpg">
        		</div>
         
        		<div class="half-container box-container">
            	   <c:forEach items="${managerList}" var="manager" varStatus="status">       
     	
                   
                    <div class="box" >
                        <div>
	                       <div><b>${manager.stadium}</b></div>
	                       <div class="locationbox">${manager.location}</div>
	                      <div>
  								<fmt:parseDate var="gametime" value="${manager.gametime}" pattern="yyyy-MM-dd HH:mm:ss" />
 							    <fmt:formatDate pattern="yyyy년 MM월 dd일 E요일 HH:mm" value="${gametime}" />
						  </div>
	                      
                        </div>
                        <div class="sub-box"> 
                            <c:if test="${manager.g_status == 0}">
                                <button class="green" style="width: 90px;">승인대기</button>
                                <button onclick="deleteManager()" class="red" style="width: 90px;">취소신청</button>
                            </c:if>
                            <c:if test="${manager.g_status == 1}">
                                <a href="${path}/manager/entry" class="page-link" style="display: flex; flex-direction: column;">
                                    <button class="grey" >확정</button>
                                    <button class="blue">명단확인</button>
                                </a>
                            </c:if>
                        </div>
                    </div>
            	  
            </c:forEach>
            
            <!-- 페이징 -->	
	<div class="pagingDiv">
		<ul>
			<c:if test="${vo.nowPage==1}">
				<li class="active">prev</li>
			</c:if>
			<c:if test="${vo.nowPage>1}">
				<li><a href="/manager/manager10/${managerid}?nowPage=${vo.nowPage-1 }">prev</a></li>
			</c:if>
			<c:forEach var="p" begin="${vo.startPageNum}" end="${vo.startPageNum+vo.onePageNumCount-1 }">
				<c:if test="${ p<=vo.totalPage}"> <!-- 표시항 페이지 번호 총페이지 수보다 작거나 같을 때 페이지 번호를 출력한다.  -->
					<!-- 현재 페이지 표시하기 -->
					<c:if test="${p==vo.nowPage }">
   						 <li class="active" style="background:#ddd;">${p}</li>
					</c:if>
					   <c:if test="${p!=vo.nowPage }">
						   <li>	<a href="/manager/manager10?nowPage=${p }">${p }</a></li>
					   </c:if>
					
				</c:if>
			</c:forEach>
			
			
			<!--다음 페이지-->
			<c:if test="${vo.nowPage<vo.totalPage }"><!-- 다음페이지가 있을 때 -->
				<li><a href="/manager/manager10?nowPage=${vo.nowPage + 1 }">next</a></li>
			</c:if>
			<c:if test="${vo.nowPage==vo.totalPage }">
				<li class="active">next</li>
			</c:if>
		</ul>
		
	</div>
       
     
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
 
  

  
 
</html>



   <!-- .manager = ${manager.managerList} 
                <c:if test="${manager.managerid == 'messi'}"></c:if> -->



 <!-- manager 컬럼 값이 1일 때만 페이지에 표시됨 -->


