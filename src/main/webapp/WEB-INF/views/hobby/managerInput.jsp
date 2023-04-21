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
.container {
  display: flex;
  justify-content: center;
}

.table {
  display: flex;
  flex-wrap: wrap;
}

.table-row {
  display: flex;
  justify-content: center;
  align-items: center;
  margin: 10px 0;
}

.cell {
  display: flex;
  justify-content: center;
  align-items: center;
  width: 150px;
  height: 50px;
  border: 1px solid black;
}

.username {
  font-size: 18px;
}
</style>

<body>
  <h1 style="font-size: 30px;">사용자 랭크 입력</h1>
  <div class="container">
    <div class="table">
      <c:forEach items="${managerList}" var="manager" varStatus="status">
        <div class="cell">
          <div class="username"><c:out value="${manager.getUsername()}" /></div>
        </div>
        <c:if test="${status.index % 3 == 2}">
          </div><div class="table-row">
        </c:if>
        <c:if test="${status.index % 3 == 0 && status.index != 0}">
          </div>
        </c:if>
      </c:forEach>
    </div>
  </div>
</body>
</html>