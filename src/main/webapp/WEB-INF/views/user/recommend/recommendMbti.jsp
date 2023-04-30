<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<script>
	$(function(){
		var logId = '<%=(String)session.getAttribute("logId")%>';

        if(logId=="null"){ 
        	$(".recommend_user.non_login").addClass("active");
        	$(".recommend_content.non_login").addClass("active");
        } else {
        	$(".recommend_user.login").addClass("active");
        	$(".recommend_content.login").addClass("active");
        }

        
        const a = {};
        let b;
        <c:forEach items="${mbtiList}" var="mbtiType">
        	b = [];
    		<c:forEach items="${mbtiStatistics.get(mbtiType)}" var="sport">
    			 b.push(["${sport.sportname}", "${sport.sport_ratio}"]);
			</c:forEach>
			a["${mbtiType}"] = b;
		</c:forEach>
    
	    $(".mbti_select").change(function(){
	    	var mbtiType = $(this).val();
	    	var c = a[mbtiType];
	    	
	    	let tag = "<div>"+mbtiType+"</div>";
	    	
	    	for (let i = 0; i < c.length; i++){
	    	    if(i===0){
	    	    	tag += "<div>당신의 MBTI와 같은 사용자들이 가장 좋아하는 취미는 <b>"+c[i][0]+"</b>입니다</div>";
	    	    }
	    	    
	    	    tag += "<div><span>"+c[i][0]+"</span><span>"+c[i][1]+"</span><div>";
	    	}
	    	
	    	$(".mbti_result").html(tag);
	    	

        });
	});
</script>

<div id="recommend_header">
	<span class="title">스포츠 추천</span>
</div>
<div id="recommend_nav">
	<ul class="recommend_user login">
		<li>ESFJ</li>
		<li>당신의 MBTI와 같은 사용자들이 가장 좋아하는 취미는 농구입니다</li>
		<li>농구</li>
		<li>42%</li>
	</ul>
	<ul class="recommend_user non_login">
		<li>MBTI를 선택하고 맞춤형 추천 결과를 확인해보세요</li>
		<li>
			<span>
				나의 MBTI는?
			</span>
			<select class="mbti_select">
				<c:forEach var="mbtiType" items="${mbtiList}">
					<option value="${mbtiType}">${mbtiType}</option>
				</c:forEach>
			</select>
		</li>
	</ul>
</div>
<div id="recommend_container">
	<div class="title-filter-wrap">
		<h2>맞춤형 스포츠 추천</h2>
		<button onclick="location.href='/recommend/mbti'">MBTI</button>
		<button onclick="location.href='/recommend/gender'">나이/성별</button>
	</div>
	<div class="recommend_content non_login">
		<div class="mbti_result"></div>
		<div><a href="/login">로그인</a>하시면 모든 MBTI의 추천 결과를 한눈에 볼 수 있습니다</div>
	</div>
	<div class="recommend_content login">
		<ul class="mbti_list">
			<c:forEach var="mbtiType" items="${mbtiList}">
				<li class="mbti_item">
					<span class="mbti_type">${mbtiType}</span>
					<ul>
						<c:forEach var="statistics" items="${sportStatistics.get(mbtiType)}">
							<li>
								<span>${statistics.sportname}: </span>
								<span>${statistics.sport_ratio}</span>
							</li>
						</c:forEach>
					</ul>
				</li>
			</c:forEach>
		</ul>
	</div>
	<div class="recommend_content non_login">
		<div class="age_gender_result">
			<div>
				<canvas id="mChart" width="500px" height="500px"></canvas>
				<canvas id="wChart" width="500px" height="500px"></canvas>
				<div></div>
			</div>
			<div></div>
		</div>
	</div>
</div>