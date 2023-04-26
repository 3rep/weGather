<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>활동내역</title>
	<link href="${path}/static/style/manager/managerPast.css" rel="stylesheet" type="text/css" />
	</head>
	<style>

</style>

<body>
  <h1 style="font-size: 30px;">활동내역- 이전경기내역</h1>
  <div>총레코드 수: ${vo.totalRecord }</div>
		
		<div>${vo.totalPage }/${vo.nowPage }</div>
  <div class="container">
  
  
    <c:forEach items="${managerList}" var="manager" varStatus="status">
         
      <div class="box">
       <div class="sub-container-left" style="width: 70%;">
        <div class="box-info">
          <h2 style="font-size: 15px;">${manager.stadium}</h2>
          <div class="box-info-item">
            <c:choose>
              <c:when test="${empty manager.g_status}">
                랭크 입력
              </c:when>
             
            </c:choose>
          </div>
        </div>
        
        <div><p style="font-size: 20px;">${manager.location} </p></div>
        <div><p style="font-size: 20px;">${manager.gametime}</p></div>
       	 <div class="sub-container-right" style="width: 30%;">
        	 <a href="${path}/manager2/managerInput" class="page-link">	
     	   <button class="btn-green" data-no="${manager.managerid}">랭크입력</button></a>
     	 </div>
       </div>
      </div>
     
     </c:forEach>
    
        <div class="pagination-container">
 
	<!-- 페이징 -->	
	<div class="pagingDiv">
		<ul>
			<c:if test="${vo.nowPage==1}">
				<li>prev</li>
			</c:if>
			<c:if test="${vo.nowPage>1}">
				<li><a href="/manager2/managerPast?nowPage=${vo.nowPage-1 }">prev</a></li>
			</c:if>
			<c:forEach var="p" begin="${vo.startPageNum}" end="${vo.startPageNum+vo.onePageNumCount-1 }">
				<c:if test="${ p<=vo.totalPage}"> <!-- 표시항 페이지 번호 총페이지 수보다 작거나 같을 때 페이지 번호를 출력한다.  -->
					<!-- 현재 페이지 표시하기 -->
					<c:if test="${p==vo.nowPage }">
						<li style="background:#ddd;">${p}</li>
					</c:if>
					   <c:if test="${p!=vo.nowPage }">
						   <li>	<a href="/manager2/managerPast?nowPage=${p }">${p }</a></li>
				       </c:if>
					
				</c:if>
			</c:forEach>
			
			
			<!--다음 페이지-->
			<c:if test="${vo.nowPage<vo.totalPage }"><!-- 다음페이지가 있을 때 -->
				<li><a href="/manager2/managerPast?nowPage=${vo.nowPage + 1 }">next</a></li>
			</c:if>
			<c:if test="${vo.nowPage==vo.totalPage }">
				<li>next</li>
			</c:if>
		</ul>
		
	</div>

</div>
       
    </div>
   
   

</body>
<script>
const buttons = document.querySelectorAll('.btn-green');
  buttons.forEach(button => {
  button.addEventListener('click', () => {
    const no = button.getAttribute('data-no');
    // 여기서 서버로 매니저의 랭크 입력 정보를 보내고, 성공적으로 처리되면 아래 코드 실행
    const targetButton = document.querySelector(`[data-no="${no}"]`);
    targetButton.classList.remove('btn-green');
    targetButton.classList.add('btn-gray');
    targetButton.innerText = '완료';
    
    
  
  
</script>
</html>

