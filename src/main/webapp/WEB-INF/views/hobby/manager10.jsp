<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>My Page</title>
  <style>
    .container {
     position: absolute;
     top:200px;
     left:400px;
	
      width: 800px;
      display: flex;
      justify-content: center;
      align-items: center;
      height: 60vh;
    }

    .half-container {
      flex-basis: 50%;
      height: 100%;
    /*  border: 1px solid black; /* 테두리 추가 */ */
      box-sizing: border-box; /* 테두리 두께를 요소의 크기에 포함 */
    }

    .image-container {
      height: 100%;
      display: flex;
      justify-content: center;
      align-items: center;
    }

    .image-container img {
      max-height: 100%;
      max-width: 100%;
    }

    .box-container {
      height: 100%;
      display: flex;
      flex-direction: column;
      justify-content: flex-start;
      align-items: center;
    }

  .box {
  position: relative;
  width: 90%;
height:60px;
  margin: 10px;
  padding: 10px;
  border: 1px solid black;
}

.sub-box {
  position: absolute;
  bottom: 0;
  right: 0;
  width: 100px;
  height: 60px;
}

.sub-box button.green {
  background-color: green;
  height: 40px;
  width: 100%;
}

.sub-box button.red {
  background-color: red;
  height: 20px;
  width: 100%;
}
 .sub-box button.grey {
      background-color: grey;
      height: 20px;
      width: 80px;
      pointer-events: none; /* 클릭 이벤트 제거 */
    }
    .sub-box button.blue {
      background-color: blue;
      height: 20px;
      width: 80px;
      pointer-events: none; /* 클릭 이벤트 제거 */
    }
  </style>
</head>
<body>
  <div class="container">
    <div class="half-container image-container">
      <img src="/static/img/soccer.jpg">
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
              <button class="green" style="width: 80px;">승인 대기</button>
              <button onclick="cancel()" class="red" style="width: 80px;">취소 신청</button>
            </c:if>
            <c:if test="${manager.g_status == 1}">
              <button class="grey">확정</button>
              <button onclick="location.href='/participant-list'" class="blue" style="width: 80px;">참가명단 확인</button>
            </c:if>
          </div>
        </div>
      </c:forEach>
    </div>
  </div>
  <script>
    function cancel() {
      var isCancelled = confirm("취소하였습니다.");
      if (isCancelled) {
        // 취소되었다는 팝업창을 띄우는 코드
        alert("취소되었습니다.");
      }
    }
  </script>
</body>
</html>