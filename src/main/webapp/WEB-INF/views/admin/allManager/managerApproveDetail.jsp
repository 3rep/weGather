<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="container" id="container-oneManager">
	<form method="post" id="managerApproveForm">
		<div class="manager_header">
			<h2>매니저 승인 대기 목록</h2>
			<ul class="approve_detail">
				<!-- 항목 -->
				<li>이름</li>
				<li>아이디</li>
				<li>이메일</li>
				<li>연락처</li>
				<li>주소</li>
				<li>성별</li>
				<li>가입날짜</li>
				<li>종목</li>
		
				<!-- 내용 -->
				<c:set var="mDTO" value="${dto}" />
				<li>${mDTO.m_name}</li>
				<li>${mDTO.managerid}</li>
				<li>${mDTO.email}</li>
				<li>${mDTO.tel}</li>
				<li>${mDTO.address}</li>
				<li>${mDTO.gender}</li>
				<li>${mDTO.signupdate}</li>
				<li>${mDTO.sportname}</li>
			</ul>
			<input type="hidden" value="${mDTO.managerid}" name="managerid"/>
		</div>
	</form>
		<div class="manager_info">
			<img src="${path}/static/img/admin/sample_proof.jpg" alt="sample proof img" class="proof_img"/>
		</div>
		<div class="manager_info">
			입금계좌<br/>
			${mDTO.m_account}
		</div>
		<div class="manager_tail">
			첨부파일 : <a href="${path}/static/img/admin/sample_proof.jpg" download>&nbsp;인증서류</a>
		</div>
		<div class="button_box">
			<input type="button" value="승인" id="approve"/>
			<input type="button" value="보류" id="postpone"/>
			<input type="button" value="거절" id="refuse"/>
		</div>
</div>

<script>
	var m_name = "${mDTO.m_name}";
	
	$(function(){
		$("#approve").click(function(){
			alert(m_name+" 님의 요청이 승인되었습니다.");
			$("#managerApproveForm").attr("action","approveOk");
			$("#managerApproveForm").submit();
		});
		
		$("#postpone").click(function(){
			alert(m_name+" 님의 요청이 보류되었습니다.");
			location.href="approvelist";
		});
		
		$("#refuse").click(function(){
			alert(m_name+" 님의 요청이 거부되었습니다.");
			$("#managerApproveForm").attr("action","refuseOk");
			$("#managerApproveForm").submit();
		});
	});
</script>

</body>
</html>
