<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<link href="static/style/style.css" rel="stylesheet" type="text/css" />
<head>
	<title>Home</title>
</head>
<script>
	/* function goPost{
		let f = document.createElement('form');
		f.setAttribute('method','post');
		f.setAttribute('action','/mypage/applylist');
		document.body.appendChild(f);
		f.submit();
		
	} */
</script>
<body>
<h1>
	Hello world!
</h1>
	<a href="/login" >로그인 했다 치고</a>
	<a href="mypage/applyList" >마이페이지로 이동</a>
	
	<hr/>
	
	sessionId : <%=session.getId() %>
	<br/>
	<div>
		session 세팅하기 : userid -> scott
		<%session.setAttribute("logId", "man2");	%>
		<br/>
		세팅확인 :<br/>
		userid -> [[ <%= session.getAttribute("logId") %> ]]<br/>
		username -> [[ ${logName } ]]
	</div>  
	
	
	
	<%-- sessionUsername : <%=session.getUsername() %> --%>
</body>
</html>
