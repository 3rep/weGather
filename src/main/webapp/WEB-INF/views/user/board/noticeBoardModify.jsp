<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<link href="${path}/static/style/style.css" rel="stylesheet" type="text/css" />
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
		
		.board-detail {
			width: 100%;
			border-collapse: collapse;
			margin-bottom: 20px;
		}
		
		.board-detail th {
			background-color: #f2f2f2;
			padding: 10px;
			text-align: center;
			font-weight: normal;
			border: 1px solid #e6e6e6;
		}
		
		.board-detail td {
			border: 1px solid #e6e6e6;
			padding-left:35px;
		}
		.content-th{
			height:400px;
		}
		.content-td{
			padding-top:35px;
			padding-right:35px;
			padding-bottom:35px;
			height:400px;
		}
		.board-detail td:first-child,
		.board-detail th:first-child {
			width: 100px;
			font-weight: bold;
		}
		
		.board-detail td:last-child {word-break:break-all;}
		.btn {padding:10px 20px; background-color:#007bff; color:#fff; border-radius:5px; border:none; cursor:pointer; font-size:16px; line-height:1; float:right;}
		.btn:hover {background-color:#0062cc;}
		.btn:focus {outline:none; box-shadow: 0 0 0 3px rgba(0, 123, 255, 0.5);}
		.btn-box{overflow:hidden;}
		.text-box{margin-top:30px; margin-right:30px; margin-bottom:30px; padding:0;}
		.text-box h2{margin:0; padding:0;}
</style>
</head>
<body>
	<form method="post">
	<div class="detail-container">
		<div class=text-box>
			<h2>공지사항</h2>
		</div>
	    	<table class="board-detail">
	    		<colgroup>
					<col style="width: 8%"/>
					<col style="width: 20%"/>
					<col style="width: 8%"/>
					<col style="width: 20%"/>
				</colgroup>
 				<tbody>
					<tr>
						<th>글번호</th>
						<td colspan="3">${board.no}</td>
					</tr>
					<tr>
						<th>제목</th>
						<td colspan="3">${board.title }</td>
					</tr>
					<tr>
						<th>작성자</th>
						<td colspan="1">${board.adminid}</td>
						<th>작성일</th>
						<td colspan="1"><fmt:formatDate pattern = "yyyy-MM-dd HH:mm:ss" value ="${board.writedate }"/></td>
					</tr>
					<tr>
						<th class=content-th>내용</th>
						<td class=content-td colspan="3"><textarea>${board.content }</textarea></td>
					</tr>
				</tbody>
			</table>
			<div class=btn-box>
				<button class="btn btn-info" onclick="location.href='/board/noticeBoard'">목록</button>
				<button type="submit">완료</button>
			</div>
	</div>
	</form>
</body>
</html>