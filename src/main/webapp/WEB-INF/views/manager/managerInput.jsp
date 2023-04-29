<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>

<head>
<meta charset="UTF-8">
	<title>활동 내역</title>
	<link href="${path}/static/style/manager/managerInput.css" rel="stylesheet" type="text/css" />
</head>
<style>
  
</style>

<body>
  <h1 style="font-size: 30px; position:relative; left:90px; top:50px;">사용자 랭크입력</h1>
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
                <option value="0">전체</option>
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
  <a href="${path}/manager/managerPast" class="page-link">
    <button class="submit-button" onclick="alert('랭크를 입력했습니다.')">입력</button>
	<button class="back-button">취소</button></a>
  </div>

</body>
<script>
    
  
    $(document).ready(function() {
        $('.submit-button').click(function() {
            var managerInputList = [];
            $('tbody tr').each(function() {
                var managerInput = {};
                managerInput['userid'] = $(this).find('td:eq(0)').text();
                managerInput['rank'] = $(this).find('select.rank-filter').val();
                managerInputList.push(managerInput);
                
            });
            console.log(managerInputList);
            $.ajax({
                url: "${path}/manager/managerInput",
                type: "POST",
                contentType: "application/json; charset=utf-8",
                data: JSON.stringify(managerInputList),
                dataType : "json",
                success: function(response) {
                    alert("랭크를 입력했습니다.");
                    console.log(response);
                    window.location.href = "${path}/manager/managerPast";
                },
                error: function(jqXHR, textStatus, errorThrown) {
                    alert("랭크 입력에 성공했습니다.");
                }
            });
        });
    });
   
    
    </script>
    
   
 
</html>