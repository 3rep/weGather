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
  <div class="container">
    <c:forEach items="${managerList}" var="manager">
      <div class="box">
      <div class="sub-container-left" style="width: 70%;">
        <div class="box-info">
          <h2 style="font-size: 25px;">${manager.stadium}</h2>
          <div class="box-info-item">
            <c:choose>
              <c:when test="${empty manager.g_status}">
                랭크 입력
              </c:when>
             
            </c:choose>
          </div>
        </div>
        <p style="font-size: 20px;">${manager.location} ${manager.gametime}</p>
          
         <div class="sub-container-right" style="width: 30%;">
         <a href="managerInput" class="page-link">	
       <button class="btn-green" data-no="${manager.managerid}">랭크 입력</button></a>
     </div>
      </div>
    </div>
  </c:forEach>
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
    
    // 버튼 상태를 저장
    buttonStates[no] = {
      clicked: true,
      completed: false
    };
  });
});
</script>
</html>