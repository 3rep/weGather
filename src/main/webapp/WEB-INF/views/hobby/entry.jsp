<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
  <title>참가명단확인</title>
   <meta charset="UTF-8">
	
	<link href="${path}/static/style/style.css" rel="stylesheet" type="text/css" />

	</head>
	<style>
  /* CSS 스타일링 */
  #container {
    margin: 0 auto; /* 가운데 정렬 */
    width: 700px; /* 너비 줄이기 */
    position:absolute;
    top:300px;
    left:400px;
  }
  table {
    border-collapse: separate;
    border-spacing: 0px;
    width: 100%;
    table-layout: fixed;
    border-radius: 10px;
    overflow: hidden;
  }
  td, th {
    border: 1px solid black;
    border-color: rgba(0, 0, 0, 0.3); 
    padding: 5px;
    text-align: left; 
  
    white-space: nowrap;
    overflow: hidden;
    text-overflow: ellipsis;
  }
  td:first-child, th:first-child {
    border-left: none;
  }
  td:last-child, th:last-child {
    border-right: none;
  }
  tr:first-child td:first-child {
    border-top-left-radius: 10px;
  }
  tr:first-child td:last-child {
    border-top-right-radius: 10px;
  }
  tr:last-child td:first-child {
    border-bottom-left-radius: 10px;
  }
  tr:last-child td:last-child {
    border-bottom-right-radius: 10px;
  }
  tr:last-child td {
    border-bottom: 1px solid rgba(0, 0, 0, 0.3); /* 마지막 행 경계선 색상 */
  }
  tr:nth-child(even) td {
    background-color: #f2f2f2;
  }
.back-button {
  position: absolute;
  top: 105%;
  right: 0;
 background-color: #2E3646;
 color: #FFFFFF;
}
</style>
  
 <body>
 <h1 style="font-size: 30px;">참가명단 확인</h1>
  <div id="container">

    <table>
      <thead>
        <tr>
          <th colspan="5">참가명단</th>
        </tr>
        <tr>
          <th colspan="5">종목</th>
        </tr>
        <tr>
          <th>아이디</th>
          <th>이름</th>
          <th>연락처</th>
          <th>성별</th>
          <th>랭크</th>
        </tr>
      </thead>
      <tbody>
  <c:forEach items="${entryList}" var="entry">
    <tr>
      <td><c:out value="${entry.getUserid()}" /></td>
      <td><c:out value="${entry.getUsername()}" /></td>
      <td><c:out value="${entry.getTel()}" /></td>
      <td><c:out value="${entry.getGender()}" /></td>
      <td><c:out value="${entry.getRank()}" /></td>
    </tr>
  </c:forEach>
</tbody>
    </table>
    <button class="back-button">뒤로가기</button>
  </div>
</body>

</html>