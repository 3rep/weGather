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
</body>
</html>
