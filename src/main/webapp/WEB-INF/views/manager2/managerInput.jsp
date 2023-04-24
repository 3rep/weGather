<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>

<head>
<meta charset="UTF-8">
	<title>활동내역</title>
	<link href="${path}/static/style/manager/managerInput.css" rel="stylesheet" type="text/css" />
</head>
<style>
  
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
<script>
    const modifyButton = document.querySelector('.modify-button');
    const submitButton = document.querySelector('.submit-button');
    
    modifyButton.addEventListener('click', () => {
      // 랭크 정보 수정 API 호출
      alert('랭크 정보를 수정했습니다.');
    });
    
    submitButton.addEventListener('click', () => {
      // 랭크 정보 입력 API 호출
      
      // managerPast 페이지에서 해당 버튼을 회색으로 변경
      const no = '${manager.managerid}';
      const button = window.opener.document.querySelector(`[data-no="${no}"]`);
      button.classList.remove('btn-green');
      button.classList.add('btn-gray');
      button.innerText = '완료';
      
      // 창 닫기
      window.close();
    });
    </script>
    
   
 
</html>