<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
  <title>참가명단확인</title>
   <meta charset="UTF-8">
	
	<link href="${path}/static/style/manager/entry.css" rel="stylesheet" type="text/css" />

	</head>
	<style>

</style>
  
 <body>
 <h1 style="font-size: 30px; position:relative; left:90px; top:50px; height:100px;">참가명단 확인</h1>
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
  <c:forEach items="${entryList}" var="item">
   <c:if test="${item.getNo() == no}">
    <tr>
      <td><c:out value="${item.getUserid()}" /></td>
      <td><c:out value="${item.getUsername()}" /></td>
      <td><c:out value="${item.getTel()}" /></td>
      <td><c:out value="${item.getGender()}" /></td>
      <td><c:out value="${item.getRank()}" /></td>
    </tr>
    </c:if>
  </c:forEach>
</tbody>
    </table>
     <a href="${path}/manager/manager10" class="page-link">	
    <button class="back-button">뒤로가기</button></a>
  </div>
</body>

</html>