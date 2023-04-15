<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>취미 추천 페이지</title>
<style>
.box {
    width: calc((100% - 50px) / 4); /* 메인 박스의 가로길이를 기준으로 작은 박스의 가로길이 계산 */
    height: 120px;
    margin: 10px;
    display: inline-block;
    border: 1px solid #ccc;
    text-align: center;
    vertical-align: middle;
    font-size: 12px;
    position: relative
}

/* 대표 박스 스타일 */
.main-box {
    width: 900px; /* 작은 박스 각 열의 길이가 메인박스보다 더 긴 경우, main-box의 가로 길이를 늘려주기 */
    height: 200px;
    margin: 50px auto;
    border: 2px solid #000;
    text-align: center;
    vertical-align: middle;
    font-size: 18px;
    line-height: 200px;
}

/* 추천 문구 스타일 */

/* 추천 문구 스타일 */
.recommend-msg {
    font-weight: bold;
    font-size: 20px;
    margin-top: 10px;
}

/* 페이지 제목 스타일 */
.page-title {
    font-weight: bold;
    font-size: 30px;
    margin: 50px auto;
    text-align: center;
}

/* 새로 추가한 스타일 */
.row {
    width: 500px;
    margin: 0 auto;
    text-align: center;
    vertical-align: middle;
}

.col {
    width: 120px;
    height: 120px;
    margin: 10px;
    display: inline-block;
    border: 1px solid #ccc;
    text-align: center;
    vertical-align: middle;
    font-size: 12px;
    position: relative;
}

.container {
    width: 900px;
    margin: 50px auto;
    text-align: center;
    background-color: EAE9E9;
}

.container .col {
    width: calc((100% - 10px*11) / 12); /* 컨테이너의 가로 길이를 기준으로 작은 박스의 가로 길이 계산 */
}



/* 박스 색상 */
.box1 {
    background-color: EAE9E9;
}
.box2 {
    background-color: EAE9E9;
}
.box3 {
    background-color: EAE9E9;
}
.box4 {
    background-color: EAE9E9;
}
.box5 {
    background-color: #FFFFFF ;
}
.box6 {
    background-color: #FFFFFF ;
}
.box7 {
    background-color: #FFFFFF ;
}
.box8 {
    background-color: #FFFFFF ;
}
.box9 {
    background-color: #FFFFFF ;
}
.box10 {
    background-color: #FFFFFF ;
}
.box11 {
    background-color: #FFFFFF ;
}
.box12 {
    background-color: #FFFFFF ;
}

/* 새로 추가한 스타일 */
.row {
    width: 500px;
    margin: 0 auto;
    text-align: center;
    vertical-align: middle;
}

.col {
    width: 120px;
    height: 120px;
    margin: 10px;
    display: inline-block;
    border: 1px solid #ccc;
    text-align: center;
    vertical-align: middle;
    font-size: 12px;
    position: relative;
}

</style>

<body>
    <h1 class="page-title">취미 추천 페이지</h1>
   
    <div class="main-box">
        <p class="recommend-msg">맞춤형 취미 추천</p>
    </div>
    
   
    <div>
      
        <div class="box box1">
            <p>mbti:</p>
            <p>취미1:</p>
            <p>취미2:</p>
            <p>취미3:</p>
        </div>
        
       
        <div class="box box2">
            <p>mbti:</p>
            <p>취미1:</p>
            <p>취미2:</p>
            <p>취미3:</p>
        </div>
        
       
        <div class="box box3">
            <p>mbti:</p>
            <p>취미1:</p>
            <p>취미2:</p>
            <p>취미3:</p>
            </div>
            
         
    <div class="box box4">
        <p>mbti:</p>
            <p>취미1:</p>
            <p>취미2:</p>
            <p>취미3:</p>
    </div>

   
    <div class="box box5">
        <p>mbti:</p>
            <p>취미1:</p>
            <p>취미2:</p>
            <p>취미3:</p>
    </div>

  
    <div class="box box6">
        <p>mbti:</p>
            <p>취미1:</p>
            <p>취미2:</p>
            <p>취미3:</p>
    </div>

   
    <div class="box box7">
        <p>mbti:</p>
            <p>취미1:</p>
            <p>취미2:</p>
            <p>취미3:</p>
    </div>

    
    <div class="box box8">
        <p>mbti:</p>
            <p>취미1:</p>
            <p>취미2:</p>
            <p>취미3:</p>
    </div>

    
    <div class="box box9">
        <p>mbti:</p>
            <p>취미1:</p>
            <p>취미2:</p>
            <p>취미3:</p>
    </div>

   
    <div class="box box10">
        <p>mbti:</p>
            <p>취미1:</p>
            <p>취미2:</p>
            <p>취미3:</p>
    </div>

    
    <div class="box box11">
        <p>mbti:</p>
            <p>취미1:</p>
            <p>취미2:</p>
            <p>취미3:</p>
    </div>

    
    <div class="box box12">
        <p>mbti:</p>
            <p>취미1:</p>
            <p>취미2:</p>
            <p>취미3:</p>
    </div>
</div>
   <c:forEach var="RecommendDTO" items="${rl}">
   <li> <div>${RecommendDTO.no}</div> 
        <div>${RecommendDTO.userid}</div>
        <div>${RecommendDTO.mbti}</div>
        <div>${RecommendDTO.gender}</div>
        <div>${RecommendDTO.age}</div>
        <div>${RecommendDTO.game}</div>  </li>
    </c:forEach>
</body>
</html>