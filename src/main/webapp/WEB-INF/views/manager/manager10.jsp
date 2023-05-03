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
  	<h1 style="font-size: 30px; position:relative; left:90px; top:30px; height:150px;">신청한 경기 내역</h1>
  		
  		 <div class= "box1">
  		 
  		  <div><h3>신청한 경기 수: ${vo.totalRecord }</h3></div>
		 <div></div> </div>
		
 		   <div class="container">
        		<div class="half-container image-container">
            		<img src="${path}/static/img/manager/soccer1.jpg" style=" position:relative; left:20px; top:10px; height:50%;">
        		</div>
         
        		<div class="half-container box-container">
            	   <c:forEach items="${managerList}" var="manager" varStatus="status">       
     			<input type='hidden' id='no' name='no' value='${manager.getNo()}'/>
                <input type='hidden' id='managerid' name='managerid' value='${manager.getManagerid()}'/>   
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
                                
                       
  						    <button class="red" type="submit" style="width: 90px;">취소신청</button>
						
                          	 
                            
                            </c:if>
                            <c:if test="${manager.g_status == 1}">
                                <a href="${path}/manager/entry?no=${manager.no}" class="page-link" style="display: flex; flex-direction: column;">
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
				<li><a href="${path }/manager/manager10/${managerid}?nowPage=${vo.nowPage-1 }">prev</a></li>
			</c:if>
			<c:forEach var="p" begin="${vo.startPageNum}" end="${vo.startPageNum+vo.onePageNumCount-1 }">
				<c:if test="${ p<=vo.totalPage}"> <!-- 표시항 페이지 번호 총페이지 수보다 작거나 같을 때 페이지 번호를 출력한다.  -->
					<!-- 현재 페이지 표시하기 -->
					<c:if test="${p==vo.nowPage }">
   						 <li class="active" style="background:#ddd;">${p}</li>
					</c:if>
					   <c:if test="${p!=vo.nowPage }">
						   <li>	<a href="${path }/manager/manager10?nowPage=${p }">${p }</a></li>
					   </c:if>
					
				</c:if>
			</c:forEach>
			
			
			<!--다음 페이지-->
			<c:if test="${vo.nowPage<vo.totalPage }"><!-- 다음페이지가 있을 때 -->
				<li><a href="${path }/manager/manager10?nowPage=${vo.nowPage + 1 }">next</a></li>
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


           $(document).ready(function() {
           $(document).on('click', '.red', function() {
            	var managerList = [];
            		$('.box').each(function() {
            	var manager = {};
            		manager['managerid'] = $('#managerid').val();
            		manager['no'] = $('#no').val();
            		managerList.push(manager);
            		
            	});
            		console.log(managerList);
           // 	var index = $(this).closest('.box')
            		$.ajax({
            			url: "${path}/manager/manager10",
            			type: "POST",
            			contentType: "application/json; charset=utf-8",
            			data: JSON.stringify(managerList),
            			dataType: "json",
            			success: function(response) {
            			alert("삭제하시겠습니까?.");
            				console.log(response);
            	// window.location.href = "${path}/manager/manager10";
            	},
            		error: function(jqXHR, textStatus, errorThrown) {
            			alert("삭제 되었습니다.");
            	}
            	});
            			$(this).closest('.box').remove();
            	});
            	});




</script>
 
  

  
 
</html>


