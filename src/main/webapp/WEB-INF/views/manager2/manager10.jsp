<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<title>매니저페이지</title>
	<link href="${path}/static/style/manager/style.css" rel="stylesheet" type="text/css" />
	

</head>
  <style>
    .container {
     position: absolute;
     top:200px;
     left:400px;
	
      width: 800px;
      display: flex;
      justify-content: center;
      align-items: center;
      height: 100vh;
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
      height: 70%;
      position:absolute;
      top:0px;
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
height:90%;
  margin: 10px;
  padding: 10px;
  border: 1px solid black;
  background: #D1D9E2;
}

.sub-box {
  position: absolute;
  bottom: 0;
  right: 0;
  width: 100px;
  height: 60px;
}

.sub-box button.green {
  background-color: #28BD54;
  height: 30px;
  width: 90px;
}

.sub-box button.red {
  background-color: #CD3838;
  height: 30px;
  width: 90px;
}
 .sub-box button.grey {
      background-color: #448FE4;
      height: 30px;
      width: 90px;
      pointer-events: none; /* 클릭 이벤트 제거 */
    }
    .sub-box button.blue {
      background-color: #395A7F;
      height: 30px;
      width: 90px;
      pointer-events: none; /* 클릭 이벤트 제거 */
    }
     .pagingDiv {
    position: relative;
  }
    .pagingDiv li{
    	position:absolute;
    	
		
		padding:10px 20px;
		bottom: 0;
	}
	
	
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
</html>
