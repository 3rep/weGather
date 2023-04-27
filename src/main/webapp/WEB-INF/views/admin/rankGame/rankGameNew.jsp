<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<script>
	// 유효성검사
	$(function(){
		$("#gametype").change(function(){
			if($(this).val() == "rank")
		});
		
		$("#rankgameForm").submit(function(){
			if($("#gametime").val()==""){
				alert("날짜/시간을 입력하세요.");
				return false;
			}
			if($("#min_people").val()==""){
				alert("경기충족인원을 입력하세요.");
				return false;
			}
			if($("#max_people").val()==""){
				alert("경기최대인원을 입력하세요.");
				return false;
			}
			if($("#payment").val()==""){
				alert("1인당 결제금액을 입력하세요.");
				return false;
			}
			if($("#managerfee").val()==""){
				alert("매니저비를 입력하세요.");
				return false;
			}
			return true;
		});
		
		// 취소 버튼 누르면 이전 페이지로 돌아가기
		$(".prev").click(function(){
			history.back();
		});
	});
</script>
<div class="container" id="rank_new_container">
	<h2 id="page-title">경기 등록</h2>
	<form method="post" action="newOk" id="rankgameForm">
		<ul>
			<li class="item">
				<label>경기유형</label>
				<select name="gametype" id="gametype">
					<option value="rank" selected>랭크경기</option>
					<option value="normal">일반경기</option>
				</select>
			</li>
			
			<li class="item">
				<label for="s_no">종목</label>
				<select name="s_no" id="s_no">
					<c:forEach var="sportDTO" items="${sportList}">
						<option value="${sportDTO.s_no}">${sportDTO.sportname}</option>
					</c:forEach>
				</select>
			</li>
			<li class="item">
				<label for="gametime">날짜/시간</label>
				<input type="datetime-local" name="gametime" id="gametime"/>
			</li>
			<li class="item">
				<label for="st_no">구장</label>
				<select name="st_no" id="stadium">
					<c:forEach var="StadiumInfoDTO" items="${stadiumInfoList}">
						<option value="${StadiumInfoDTO.st_no}">${StadiumInfoDTO.stadium}, ${StadiumInfoDTO.location}</option>
					</c:forEach>
				</select>
			</li>
			<li class="item">
				<label for="min_people">경기충족인원</label>
				<input type="text" name="min_people" id="min_people"/>명
			</li>
			<li class="item">
				<label for="max_people">경기최대인원</label>
				<input type="text" name="max_people" id="max_people"/>명
			</li>
			<li class="item">
				<label for="gendertype">성별유형</label>
				<select name="gendertype" id="gendertype">
					<option value="남녀모두">남녀모두</option>
					<option value="남자만">남자만</option>
					<option value="여자만">여자만</option>
				</select>
			</li>
			<li class="item">
				<label for="req_rank">요구랭크</label>
				<select name="req_rank" id="req_rank">
					<option value="0">모든랭크</option>
					<option value="1">BRONZE</option>
					<option value="2">SILVER</option>
					<option value="3">GOLD</option>
					<option value="4">PLATINUM</option>
					<option value="5">DIAMOND</option>
				</select>
			</li>
			<li class="item">
				<label for="payment">1인당 결제금액</label>
				<input type="text" name="payment" id="payment" maxlength="8" />원
			</li>
			<li class="item">
				<label for="managerfee">매니저비</label>
				<input type="text" name="managerfee" id="managerfee" maxlength="8" />원
			</li>
		</ul>
		<div class="btns">
			<a class="btn-gray btn-cancel prev">취소</a>
			<input type="submit" value="등록" class="btn-black" />
		</div>
	</form>
</div>
</body>
</html>