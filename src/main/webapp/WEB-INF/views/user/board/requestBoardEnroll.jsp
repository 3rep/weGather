<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
		.detail-container {
			width: 1237px;
			margin: 50px auto;
			padding: 30px;
			background-color: #fff;
			box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
			border-radius: 5px;
			font-size: 18px;
			color: #333;
		}
		.input-group {
			display: flex;
		  	flex-direction: row;
			margin-bottom:10px;
			border:1px #e6e6e6 solid;
		}
		.input-group span{width:170px; height:40px;background-color: #F2F2F2; text-align: center;}
		.input-group input, .input-group textarea{border:1px #e6e6e6 solid; width:100%;}
		.text-box{margin-top:5px; margin-right:30px; margin-bottom:30px; padding:0;}
		.text-box h2{margin:0; padding:0;}
</style>
</head>
<body>
	<div class="detail-container">
		<div class=text-box>
			<h2>건의사항</h2>
		</div>
	<form action="/board/requestBoard/enroll" method="post">
		<div class="input-group">
			<span>제목</span>
			<input name="title">
		</div>
		<div class="input-group">	
			<span>내용</span>
			<textarea rows="3" name="content"></textarea>
		</div>
		<input type="hidden" name="userid" values="<%=session.getAttribute("logId") %>">
		<button class="btn">등록</button>
	</form>
	</div>
</body>
</html>