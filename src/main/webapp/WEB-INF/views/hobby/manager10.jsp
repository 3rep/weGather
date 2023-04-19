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
            <button style="background-color: green; height: 20px; width: 80px;">승인 대기</button>
            <button onclick="cancel()" style="background-color:red; height: 20px;  width: 80px;">취소 신청</button>
            <button id="grey-btn" style="background-color:grey; height: 20px;  width: 80px; display:none;" disabled>버튼</button>
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
    
    var gameStatus = 0; // 게임 상태를 0으로 초기화
    if (gameStatus === 0) {
      // 버튼을 조작하는 코드
      var greenBtn = document.querySelector('.sub-box button:first-of-type');
      var redBtn = document.querySelector('.sub-box button:last-of-type');
      var greyBtn = document.getElementById('grey-btn');
      greenBtn.style.display = "inline-block";
      redBtn.style.display = "inline-block";
      greyBtn.style.display = "none";
    } else if (gameStatus === 1) {
      // 버튼을 조작하는 코드
      var greenBtn = document.querySelector('.sub-box button:first-of-type');
      var redBtn = document.querySelector('.sub-box button:last-of-type');
      var greyBtn = document.getElementById('grey-btn');
      greenBtn.style.display = "none";
      redBtn.style.display = "none";
      greyBtn.style.display = "inline-block";
      greyBtn.disabled = true;
    }
  </script>
</body>
</html>