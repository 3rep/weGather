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
			height: 150vh;
			font-family: Arial, sans-serif;
			align-items: center; /* 수직 중앙 정렬 */
			justify-content: center; /* 수평 중앙 정렬 */
		}
		.container {
			display: flex;
			flex-direction: column;
			align-items: center; /* 세로로 중앙 정렬 */
			justify-content: center; /* 가로로 중앙 정렬 */
		}
		.box {
			background-color: #D1D9E2;
			color: #FFFF;
			padding: 10px;
			margin: 5px;
			text-align: left;
			
			flex-basis: 20%; /* 크기 조절 */
			flex-grow: 1; /* 네개의 박스를 동일한 높이로 설정 */
			width: 500px;
			 height: 100px;
		}
		.box-info {
			display: flex;
			justify-content: space-between;
			 flex-direction: column;
				
  margin-bottom: 10px;

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
	<div class="container"></div>
		<div class="box">
			<div class="box-info">
				<h2>축구(용산 축구장)</h2>
				<div class="box-info-item">승인대기</div>
				<div class="box-info-item">취소하기</div>
			</div>
			<p>영등포 sky 축구장</p>
		</div>
		<div class="box">
			<div class="box-info">
				<h2>축구</h2>
				<div class="box-info-item">승인완료</div>
				<div class="box-info-item">Small box 2</div>
			</div>
			<p>마포구 대동동</p>
		</div>
		<div class="box">
			<div class="box-info">
				<h2>풋살</h2>
				<div class="box-info-item">승인완료</div>
				<div class="box-info-item">취소하기</div>
			</div>
			<p>북구 체육센터</p>
		</div>
		<div class="box">
			<div class="box-info">
				<h2>축구</h2>
				<div class="box-info-item">승인완료</div>
				<div class="box-info-item">취소하기</div>
			</div>
			<p>남구 체육시설</p>
		</div>
</body>
</html>