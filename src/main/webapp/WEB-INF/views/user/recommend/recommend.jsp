<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<script src="https://cdn.jsdelivr.net/npm/chart.js@2.9.4/dist/Chart.min.js"></script>
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
        
        /* 남성 파이차트*/
    	var colorList = ['#FA7577', '#FAD275', '#A9CC8E', '#60A9A7', '#7391AB', '#3098C5', '#F9AC4E', '#FA9461', '#5295B8'];

    	var m_labels = [];
    	var m_data = [];
    	
    	<c:forEach items="${manStatistics}" var="sport">
    		m_labels.push("${sport.sportname}");
    		m_data.push("${sport.sport_ratio}");
		</c:forEach>
		
    	let mChart= $('#mChart');
    	
    	const manPieChart = new Chart(mChart, {
   	    	type: 'pie',
   	    	data : {
   	    		labels : m_labels,
   	    		datasets:[{   
	    		backgroundColor: colorList,
	    		borderWidth: 0.5 ,
	    		borderColor: '#ddd',
	    		data: m_data   
	    		}]
			},
				options: {
					responsive: false,
					title: {
						display: true,
						text: '남성',
						position: 'top',
						fontSize: 25,
						fontColor: '#111',
						padding: 20
 	    		        },
				legend: {
 					display: true,
 					position: 'bottom',
					labels: {
						fontSize: 20,
						fontWeight: 800,
						boxWidth: 20,
						fontColor: '#111',
						padding: 15
						}
					},
				},
					centerText: {
						display: false,
						text: ""
					}
			});
    	
    		
    		/* 여성 파이차트*/
    	
	    	var w_labels = [];
	    	var w_data = [];
	    	
	    	<c:forEach items="${womanStatistics}" var="sport">
	    		w_labels.push("${sport.sportname}");
	    		w_data.push("${sport.sport_ratio}");
			</c:forEach>
			
			let wChart= $('#wChart');
	    	
	    	const womanPieChart = new Chart(wChart, {
	   	    	type: 'pie',
	   	    	data : {
	   	    		labels : w_labels,
	   	    		datasets:[{   
		    		backgroundColor: colorList,
		    		borderWidth: 0.5 ,
		    		borderColor: '#ddd',
		    		data: w_data   
		    		}]
				},
					options: {
						responsive: false,
						title: {
							display: true,
							text: '여성',
							position: 'top',
							fontSize: 25,
							fontColor: '#111',
							padding: 20
	 	    		        },
					legend: {
	 					display: true,
	 					position: 'bottom',
						labels: {
							fontSize: 20,
							fontWeight: 800,
							boxWidth: 20,
							fontColor: '#111',
							padding: 15
							}
						},
					},
						centerText: {
							display: false,
							text: ""
						}
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
			<select>
				<option value="ISTP">ISTP</option>
				<option value="ISTJ">ISTJ</option>
				<option value="ISFP">ISFP</option>
				<option value="ISFJ">ISFJ</option>
				<option value="INTP">INTP</option>
				<option value="INTJ">INTJ</option>
				<option value="INFP">INFP</option>
				<option value="INFJ">INFJ</option>
				<option value="ESTP">ESTP</option>
				<option value="ESTJ">ESTJ</option>
				<option value="ESFP">ESFP</option>
				<option value="ESFJ">ESFJ</option>
				<option value="ENTP">ENTP</option>
				<option value="ENTJ">ENTJ</option>
				<option value="ENFP">ENFP</option>
				<option value="ENFJ">ENFJ</option>
			</select>
		</li>
	</ul>
</div>
<div id="recommend_container">
	<div class="title-filter-wrap">
		<h2>맞춤형 스포츠 추천</h2>
		<button class="btn-filter">MBTI</button>
		<button class="btn-filter">나이/성별</button>
	</div>
	<div class="recommend_content non_login">
		<div class="mbti_result">
			<div>ESFJ</div>
			<div>
				<span>농구</span>
				<span>42%</span>
			</div>
			<div>당신의 MBTI와 같은 사용자들이 가장 좋아하는 취미는 농구입니다</div>
			<div>
				<div>
					<span>야구</span>
					<span>18%</span>
				</div>
				<div>
					<span>배구</span>
					<span>7%</span>
				</div>
			</div>
		</div>
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