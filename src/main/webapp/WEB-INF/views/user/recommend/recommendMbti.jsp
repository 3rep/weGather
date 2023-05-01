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
	    	
	    	let tag = "<div class='mbti'>"+mbtiType+"</div>";
	    	
	    	for (let i = 0; i < c.length; i++){
	    	    if(i===0){
	    	    	tag += "<div class='message'>당신의 MBTI와 같은 사용자들이 가장 좋아하는 취미는 ["+c[i][0]+"]입니다</div>";
	    	    	tag += "<div class='sport_statistics top'>"+c[i][0]+" "+c[i][1]+"</div>";
	    	    } else {
	    	    tag += "<div class='sport_statistics'>"+c[i][0]+" "+c[i][1]+"</div>";	    	    	
	    	    }
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
		<c:set var="userRecommend" value="${mbtiStatistics.get(userMbti)[0]}"/>
		<li>${userMbti}</li>
		<li>당신의 MBTI와 같은 사용자들이 가장 좋아하는 취미는 ${userRecommend.sportname}입니다!</li>
		<li>${userRecommend.sportname}</li>
		<li>${userRecommend.sport_ratio}</li>
	</ul>
	<div class="recommend_user non_login">
		<div>MBTI를 선택하고 맞춤형 추천 결과를 확인해 보세요</div>
		<div>
			<span>나의 MBTI는?</span>
			<select class="mbti_select">
				<c:forEach var="mbtiType" items="${mbtiList}">
					<option value="${mbtiType}">${mbtiType}</option>
				</c:forEach>
			</select>
		</div>
	</div>
</div>
<div id="recommend_container">
	<div class="title-filter-wrap">
		<h3>맞춤형 스포츠 추천</h3>
		<button onclick="location.href='/recommend/mbti'" class="filter active">MBTI</button>
		<button onclick="location.href='/recommend/gender'" class="filter">나이/성별</button>
	</div>
	<div class="recommend_content non_login">
		<div class="mbti_result">
			<c:set var="defaultResult" value="${mbtiStatistics.get('ISTP')}" />
			<div class="mbti">ISTP</div>
			<div class="message">당신의 MBTI와 같은 사용자들이 가장 좋아하는 취미는 [${defaultResult[0].sportname}]입니다</div>
			<c:forEach var="sport" items="${defaultResult}" varStatus="status">
				<div class="sport_statistics <c:if test="${status.index==0}">top</c:if>">${sport.sportname} ${sport.sport_ratio}</div>
			</c:forEach>
		</div>
		<div class="login-message"><a href="/login">로그인</a>하시면 모든 MBTI의 추천 결과를 한눈에 볼 수 있습니다</div>
	</div>
	<div class="recommend_content login">
		<ul class="mbti_list">
			<c:forEach var="mbtiType" items="${mbtiList}">
				<li class="mbti_item <c:if test="${mbtiType==userMbti}">active</c:if>">
					<span class="mbti_type">${mbtiType}</span>
					<ul>
						<c:forEach var="statistics" items="${mbtiStatistics.get(mbtiType)}">
							<li class="sport_statistics">
								<span>${statistics.sportname}: </span>
								<span>${statistics.sport_ratio}</span>
							</li>
						</c:forEach>
					</ul>
				</li>
			</c:forEach>
		</ul>
	</div>
</div>