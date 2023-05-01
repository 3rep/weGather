<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.9.3/Chart.min.js"></script>
<script>
	$(function(){

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

</div>
<div id="recommend_container">
	<div class="title-filter-wrap">
		<h2>맞춤형 스포츠 추천</h2>
		<button onclick="location.href='/recommend/mbti'">MBTI</button>
		<button onclick="location.href='/recommend/userinfo'">나이/성별</button>
	</div>
	<div class="">
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