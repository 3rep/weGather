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
      height: 50vh;
    }

    .half-container {
      flex-basis: 50%;
      height: 100%;
      border: 1px solid black; /* 테두리 추가 */
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
      margin: 10px;
      padding: 10px;
      border: 1px solid black;
    }
 .sub-box {
 width: 100px; 


     position: relative;
      width: 50px;
      height: 25px;
     
      margin-left: auto;
}
 .sub-box button.green {
  background-color: green;
  height: 20px;
  width: 80px;
}
.sub-box button.red {
  background-color: red;
  height: 20px;
  width: 80px;
}
 
  </style>
  
</head>
<body>
  <div class="container">
    <div class="half-container image-container">
      <img src="soccer.jpg">
    </div>
    <div class="half-container box-container">
      <% for (int i = 0; i < dataList.size(); i++) { %>  
        <div class="box">
          <!-- 동적으로 생성되는 상자 -->
          <%= dataList.get(i) %> 
          <div class="sub-box">
            <button style="background-color: green; height: 20px; width: 80px;">위 버튼</button>
            <button onclick="cancel()" style="background-color:red; height: 20px;  width: 80px;">아래 버튼</button>
          </div>
        </div>
      <% } %>
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