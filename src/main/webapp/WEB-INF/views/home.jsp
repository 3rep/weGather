<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<link rel="stylesheet" href="static/style/style.css" type="text/css"/>

<div class="container" style="width:1200px; margin:0 auto">
<h1>
	Hello world!
</h1>

<P>  The time on the server is ${serverTime}. </P>
<a href="/admin/sport/sportlist">관리자 페이지로 이동</a>
</div>