<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>

<head>
<meta charset="UTF-8">
	<title>활동내역</title>
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
  .submit-button {
  position: absolute;
  top: 105%;
  right: 90px;
 background-color: #28BD54;
 color: #FFFFFF;
}
  .modify-button {
  position: absolute;
  top: 105%;
  right: 45px;
 background-color: #448FE4;
 color: #FFFFFF;
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
  <h1 style="font-size: 30px;">사용자 랭크입력</h1>
  <div id="container">

    <table>
      <thead>
        <tr>
          <th colspan="3">랭크 입력 대상</th>
        </tr>
        <tr>
          <th>아이디</th>
          <th>이름</th>
          <th>랭크</th>
        </tr>
      </thead>
      <tbody>
        <c:forEach items="${managerInputList}" var="managerInput">
          <tr>
            <td><c:out value="${managerInput.getUserid()}" /></td>
            <td><c:out value="${managerInput.getUsername()}" /></td>
            <td>
              <select class="rank-filter">
                <option value="">전체</option>
                <option value="1" ${managerInput.getRank() == 1 ? 'selected' : ''}>브론즈</option>
                <option value="2" ${managerInput.getRank() == 2 ? 'selected' : ''}>실버</option>
                <option value="3" ${managerInput.getRank() == 3 ? 'selected' : ''}>골드</option>
                <option value="4" ${managerInput.getRank() == 4 ? 'selected' : ''}>플래티넘</option>
                <option value="5" ${managerInput.getRank() == 5 ? 'selected' : ''}>다이아</option>
              </select>
            </td>
          </tr>
        </c:forEach>
      </tbody>
    </table>
    <a href="managerPast" class="page-link">	
    <button class="submit-button" onclick="alert('랭크를 입력했습니다.')">입력</button></a>
	<button class="modify-button">수정</button>
    <button class="back-button">취소</button>
  </div>

</body>

</html>