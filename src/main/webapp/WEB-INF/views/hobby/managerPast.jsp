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
  height: 100vh;
  justify-content: center;
  align-items: center;
  font-family: Arial, sans-serif;
}

.container {
  display: flex;
  flex-direction: column;
  align-items: center;
  height: 50%; /* 컨테이너 높이를 60%로 설정 */
}

.box {
  background-color: #D1D9E2;
  color: #FFFF;
  padding: 10px;
  margin: 5px;
  text-align: left;
  flex-basis: 20%;
  flex-grow: 1;
   font-size: 14px;
  width: 500px;
  height: 50px; /* 박스 높이를 50px로 조절 */
}

.box-info {
  display: flex;
  justify-content: space-between;
  flex-direction: column;
  margin-bottom: 10px;
  width: 100%;
}

.box-info-item {
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
    background-color: gray;
  }
</style>

<body>
  <h1 style="font-size: 30px;">활동내역- 이전경기내역</h1>
  <div class="container">
    <c:forEach items="${managerList}" var="manager">
      <div class="box">
        <div class="box-info">
          <h2>${manager.stadium}</h2>
          <div class="box-info-item">
            <c:choose>
              <c:when test="${empty manager.g_status}">
                랭크 입력
              </c:when>
             
            </c:choose>
          </div>
        </div>
        <p>${manager.location} ${manager.gametime}</p>
        <button class="btn-green">랭크 입력</button>
      </div>
    </c:forEach>
  </div>
</body>

<script>
  const buttons = document.querySelectorAll('.btn-green');
  buttons.forEach(button => {
    button.addEventListener('click', () => {
      button.classList.remove('btn-green');
      button.classList.add('btn-gray');
      button.innerText = '완료';
    });
  });
</script>
</html>