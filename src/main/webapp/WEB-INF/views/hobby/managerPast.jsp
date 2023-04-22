<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>활동내역</title>
	<link href="${path}/static/style/style.css" rel="stylesheet" type="text/css" />
	</head>
	<style>
.body {
  margin: 0;
  padding: 0;
  display: flex;
  flex-direction: column;
  height: 70vh;
  justify-content: center;
  align-items: center;
  font-family: Arial, sans-serif;
}

.container {
  display: flex;
  flex-direction: column;
  align-items: center;
  height: 30%; /* 컨테이너 높이를 60%로 설정 */
}

.box {
  background-color: #D1D9E2;
  color: #FFFF;
  padding: 3px;
  margin: 5px;
  text-align: left;
  flex-basis: 20%;

   font-size: 12px;
  width: 500px;
  height: 50px; /* 박스 높이를 50px로 조절 */
    position: relative; /* 박스에 position을 추가 */
    top:150px;
}

.box-info {
  display: flex;
  justify-content: space-between;
  flex-direction: column;
  margin-bottom: 10px;
  width: 100%;
}


.box button {
    //background-color: #48CD5D;
    color: #fff;
    padding: 5px;
    margin: 5px;
    text-align: center;
    height: 30px;
    width: 150px;
    font-size: 14px;
    align-self: flex-end;
    position: absolute; /* 버튼 위치를 absolute로 지정 */
    right: 0; /* 오른쪽에 위치하도록 지정 */
    bottom: 0; /* 하단에 위치하도록 지정 */
   
     
  }
  
  .btn-green {
    background-color: #48CD5D;
    color: #fff;
    padding: 5px;
    margin: 5px;
    text-align: center;
    height: 20px;
    width: 150px;
    font-size: 14px;
    align-self: flex-end;
  }

 .btn-gray {
  background-color: gray !important;
  color: #fff;
  padding: 5px;
  margin: 5px;
  text-align: center;
  height: 20px;
  width: 150px;
  align-self: flex-end;
}
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