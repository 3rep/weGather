<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<link href="static/style/style.css" rel="stylesheet" type="text/css" />
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!
</h1>

<P>  The time on the server is ${serverTime}. </P>
<a href="/hobby/recommend">취미추천</a> <!-- url넣어서 페이지 띄우기 위함 -->
<a href="/hobby/manager10">매니저신청현황</a>
<a href="/hobby/managerPast">매니저이전내역</a>
<a href="/hobby/entry">참가자 명단 확인</a>
<a href="/hobby/managerInput">사용자 랭크 입력</a>
</body>
</html>
