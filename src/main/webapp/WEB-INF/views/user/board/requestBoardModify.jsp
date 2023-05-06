<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script
  src="https://code.jquery.com/jquery-3.4.1.js"
  integrity="sha256-WpOohJOqMqqyKL9FccASB9O0KwACQJpFTUBLTYOVvVU="
  crossorigin="anonymous"></script>
  <style>
<style type="text/css">
.input_wrap{
	padding: 5px 20px;
}
label{
    display: block;
    margin: 10px 0;
    font-size: 20px;	
}
input{
	padding: 5px;
    font-size: 17px;
}
textarea{
	width: 800px;
    height: 200px;
    font-size: 15px;
    padding: 10px;
}
.btn{
  	display: inline-block;
    font-size: 22px;
    padding: 6px 12px;
    background-color: #fff;
    border: 1px solid #ddd;
    font-weight: 600;
    width: 140px;
    height: 41px;
    line-height: 39px;
    text-align : center;
    margin-left : 30px;
    cursor : pointer;
}
.btn_wrap{
	padding-left : 80px;
	margin-top : 50px;
}
</style>
</head>
<body>
<h1>수정 페이지</h1>
	<form id="modifyForm" action="/board/requestBoard/modify" method="post">
	<div class="input_wrap">
		<label>번호</label>
		<input name="no" readonly="readonly" value='<c:out value="${pageInfo.no}"/>' >
	</div>
	<div class="input_wrap">
		<label>제목</label>
		<input name="title" value='<c:out value="${pageInfo.title}"/>' >
	</div>
	<div class="input_wrap">
		<label>내용</label>
		<textarea rows="3" name="content"><c:out value="${pageInfo.content}"/></textarea>
	</div>
	<div class="input_wrap">
		<label>작성일</label>
		<input name="writedate" readonly="readonly" value='<fmt:formatDate pattern="yyyy/MM/dd" value="${pageInfo.writedate}"/>' >
	</div>		
	<div class="btn_wrap">
		<a class="btn" id="list_btn">목록 페이지</a> 
		<a class="btn" id="modify_btn">수정 완료</a>
		<a class="btn" id="cancel_btn">수정 취소</a>
	</div>
	</form>
	<form id="infoForm" action="/board/requestBoard/modify" method="get">
		<input type="hidden" id="no" name="no" value='<c:out value="${pageInfo.no}"/>'>
	</form>
<script>
	let form = $("#infoForm");
	let mForm = $("#modifyForm");
	$("#list_btn").on("click", function(e){
		form.find("#no").remove();
		form.attr("action", "/board/requestBoard");
		form.submit();
	});
	
	$("#modify_btn").on("click", function(e){
		mForm.submit();
	});
	
	$("#cancel_btn").on("click", function(e){
		form.attr("action", "/board/requestBoard/get");
		form.submit();
	});
	
</script>	
</body>
</html>