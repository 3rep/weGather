<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<div class="container" id="container-oneManager2">
	<c:set var="mDTO" value="${dto}"/>
	<h2>매니저 정보</h2>
	<div class="content_box">
		<div class="manager_header">
			<img src="/static/img/admin/manager_icon.png" alt="user_icon" id="manager_icon"/>${mDTO.m_name} (${mDTO.managerid}) 매니저
		</div>
		<div class="manager_body">
			<div class="manager_content">
				<ul>
					<li>아이디</li>
					<li>${mDTO.managerid}</li>
					<li>이름</li>
					<li>${mDTO.m_name}</li>
					<li>이메일</li>
					<li>${mDTO.email}</li>
					<li>입금계좌</li>
					<li>${mDTO.m_account}</li>
					<li>주소</li>
					<li>${mDTO.address}</li>
				</ul>			
			</div>
			<div class="manager_content">
				<ul>
					<li>가입날짜</li>
					<li>${mDTO.signupdate}</li>
					<li>연락처</li>
					<li>${mDTO.tel}</li>
					<li>성별</li>
					<li>${mDTO.gender}</li>
					<li>종목</li>
					<li>${mDTO.sportname}</li>
					<li>&nbsp;</li>
					<li id="last_point">
						<input type="button" value="매니저 제명"/>
						<input type="button" value="매니저 활동내역"/>
					</li>
				</ul>
			</div>
		</div>
	</div>
</div>
</body>
</html>
