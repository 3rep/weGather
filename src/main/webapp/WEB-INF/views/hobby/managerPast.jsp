<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<title>활동한 신청내역</title>
	
	<style>
			body {
			margin: 0;
			padding: 0;
			display: flex;
			flex-direction: column;
			height: 100vh; /* 뷰포트 높이를 100%로 설정 */
			justify-content: center; /* 수직 중앙 정렬 */
			align-items: center; /* 수평 중앙 정렬 */
			font-family: Arial, sans-serif;
		}
		.container {
			display: flex;
			flex-direction: column;
			align-items: center; /* 세로로 중앙 정렬 */
		}
		.box {
			background-color: #D1D9E2;
			color: #FFFF;
			padding: 10px;
			margin: 5px;
			text-align: left;
			flex-basis: 20%; /* 크기 조절 */
			flex-grow: 1; /* 네 개의 박스를 동일한 높이로 설정 */
			width: 500px;
			height: 50px;
		}
		.box-info {
			display: flex;
			justify-content: space-between;
			flex-direction: column;
			margin-bottom: 10px;
			width: 100%;
		}
		.box-info-item {
			background-color: #48CD5D;
			color: #fff;
			padding: 5px;
			margin: 5px;
			text-align: center;
			height: 20px;
			width: 150px;
			align-self: flex-end;
		}
	</style>
</head>
<body>
	<div class="container">
		<div class="box">
			<div class="box-info">
				<h2>박스 1</h2>
				<div class="box-info-item">사용자 랭크 입력</div>
			</div>
			<p>박스 1 내용</p>
		</div>
		<div class="box">
			<div class="box-info">
				<h2>박스 2</h2>
				<div class="box-info-item">사용자 랭크 입력</div>
			</div>
			<p>박스 2 내용</p>
		</div>
		<div class="box">
			<div class="box-info">
				<h2>박스 3</h2>
				<div class="box-info-item">완료</div>
			</div>
			<p>박스 3 내용</p>
		</div>
		<div class="box">
			<div class="box-info">
				<h2>박스 4</h2>
				<div class="box-info-item">완료</div>
			</div>
			<p>박스 4 내용</p>
		</div>
	</div>
</body>
</html>