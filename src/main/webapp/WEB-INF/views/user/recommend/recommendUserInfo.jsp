<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.9.3/Chart.min.js"></script>
<script>
	$(function(){
		var logId = '<%=(String)session.getAttribute("logId")%>';

        if(logId=="null"){ 
        	$(".recommend_user_info.non_login").addClass("active");
        } else {
        	$(".recommend_user_info.login").addClass("active");
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
						fontSize: 30,
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
							fontSize: 30,
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
	    	
	    	/* bar chart */
	    	var age_labels = [];
	    	var age_data = [];
	    	var sport_labels = [];
	    	var s = {};
	    	
	    	<c:forEach items="${ageGroup}" var="age">
	    		age_labels.push("${age}");
			</c:forEach>
			
			<c:forEach items="${sportnameList}" var="sportname">
				sport_labels.push("${sportname}");
				s["${sportname}"] = [];
				
			</c:forEach>
			
			<c:forEach items="${ageStatistics}" var="statistics">
				<c:forEach items="${statistics}" var="sport" varStatus="status">
					s["${sport.sportname}"].push("${sport.sport_ratio}");
				</c:forEach>
			</c:forEach>
			
			let index = 0;
			for(var sportname of sport_labels) {
				const data = {
						label: sportname,
	                    data: s[sportname],
	                    backgroundColor: colorList[index],
	                    borderColor: '#CBCE91',
	                    borderWidth: 1
						}
				age_data.push(data);
				index++;
			}
			
	    	
	    	let ageChart= $('#ageChart');
	    	
	        const myChart = new Chart(ageChart, {
	        type: 'bar',
	        data:{
	            labels: age_labels,
	            datasets: age_data
	        },
	        options:{
	                    maintainAspectRatio :false,//그래프의 비율 유지
	                }
	        });

	});
</script>

<div id="recommend_header">
	<span class="title">스포츠 추천</span>
</div>
<div id="recommend_nav">
	<div class="recommend_user_info login">
		
	</div>
	<div class="recommend_user_info non_login">성별과 나이에 따른 스포츠 추천 결과를 확인해보세요</div>
</div>
<div id="recommend_container">
	<div class="title-filter-wrap">
		<h3>맞춤형 스포츠 추천</h3>
		<button onclick="location.href='/recommend/mbti'" class="filter">MBTI</button>
		<button onclick="location.href='/recommend/userinfo'" class="filter active">나이/성별</button>
	</div>
	<div class="recommend_content_user_info">
		<div class="gender_result">
			<canvas id="mChart" width="350px" height="350px"></canvas>
			<canvas id="wChart" width="350px" height="350px"></canvas>
		</div>
		<div class="age_result"><canvas id="ageChart"></canvas></div>
	</div>
</div>