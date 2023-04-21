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
.table {
  border-collapse: collapse;
  width: 100%;
}

.th, td {
  text-align: center;
  padding: 8px;
}

.th {
  background-color: #ddd;
}

.tr:nth-child(even) {
  background-color: #f2f2f2;
}

.tr:hover {
  background-color: #ddd;
}

.td:nth-child(2), td:nth-child(3), td:nth-child(5) {
  display: none;
}</style>
  
 <body>
  <h1 style="font-size: 30px;">참가명단 확인</h1>
  <div class="container">
    <table>
      <thead>
        <tr>
          <th colspan="3">참가자 명단</th>
        </tr>
      </thead>
      <tbody>
        <c:forEach items="${entryList}" var="entry" varStatus="status">
          <c:if test="${status.index % 3 == 0}">
            <tr>
              <td><c:out value="${entry.getUsername()}" /></td>
          </c:if>
          <c:if test="${status.index % 3 == 1}">
              <td><c:out value="${entry.getUsername()}" /></td>
          </c:if>
          <c:if test="${status.index % 3 == 2}">
              <td><c:out value="${entry.getUsername()}" /></td>
            </tr>
          </c:if>
        </c:forEach>
      </tbody>
    </table>
  </div>
</body>





</html>