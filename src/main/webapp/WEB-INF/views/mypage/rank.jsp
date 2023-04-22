<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!-- 오른쪽 내용칸 -->
		<div id="content"> 
			<h3>나의 랭크</h3>
			<hr/>
		
			<form id="chartView">
				<select id="sportname" name="sportname" required >
					<option value="" >--종목선택--</option>
					<option value="풋살">풋살</option>
					<option value="야구">야구</option>
					<option value="농구">농구</option>
				</select>
				<button id="chartBtn" title="Button border blue/green" class="button btnBorder btnBlueGreen" >그래프 보기</button>
			</form>
			
			<!-- BarChart넣기 -->
			<div class="chart" style="width:100%">
				<canvas id="line_chart"></canvas>
			</div>
			
		</div> <!-- 오른쪽 내용칸 div -->
		
		
</div>	<!-- 왼쪽메뉴바와 오른쪽 본문 합친 div -->
</body>
<!-- 차트 그리기 script -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/chart.js@2.8.0"></script>
<script>


	$(function(){
		//차트 그리기에서 필요한 데이터 ---------------
		var label; //차트제목
		var gametime = new Array();//라벨(x축)
		var newgt = new Array();
		var isoDates = new Array();
		var rankData = new Array(); //데이터(y축)
		var backgroundColor = 'rgba(255, 99, 132, 0.2)';
		var borderColor = 'rgb(255, 99, 132)';
		//------------------------------------- 
		//차트 그리기
		function chart(){
			var data = {
				labels: isoDates,
				datasets: [{
					label: label,
				    data: rankData,
				    fill: false,
				    borderColor: 'rgb(75, 192, 192)',
				    tension: 0.1,
				    pointRadius: 7, // 포인트 크기
				    pointStyle: 'rect', // 직사각형, triangle : 삼각형, default : circle (원형)
	                pointBackgroundColor: 'Color'
		 		 }]
			};
			
			var chart = new Chart(document.getElementById("line_chart"), {
			    type: 'line',
			    data: data,
			    options: { 
			    	scales: { 
			    		xAxes: [{ ticks: { display: false } }], //x축 없애기
			    		yAxes: [{	//y축설정
			                ticks: {
			                    max: 5,
			                    min: 0,
			                    stepSize: 1
			                }
			            }]
			    	},
			    	tooltips: {
		                titleFontSize: 15,
		                bodyFontSize: 15
		            }
			    
			    }
			
			});
		}
		
		
		//버튼누르면 ajax 실행
		$("#chartBtn").click(function(){ 
			event.preventDefault();
			
			var value = (sportname.options[sportname.selectedIndex].value);
			var data = {sportname: value }
			console.log(data);
			console.log("value---->"+value);
			label = value;
			
			if(value==""){
				alert("종목을 선택하세요");
				return false;	
			}
			
			
			$.ajax({
				data : data,
				type : "post",
				url : "rankMain",
				success : function(result){
				
					//console.log("result->"+result);
					//$("#re").html(result);
					
					
					
					var jsonData = JSON.parse(result);
					//console.log("jsonData->"+jsonData);
					
					jsonData.map(function(obj, i){
						gametime[i]=obj.gametime; //라벨(x축) : 기준날짜
						console.log("gametime[i]->"+gametime[i]);
						newgt[i] = new Date(gametime[i]);
						console.log("newgt->"+newgt);
						
						rankData[i]=obj.rank; //데이터(y축)
						console.log("rankData[i]->"+rankData[i]);
					}) 
					
					isoDates = newgt.map(date=>date.toISOString().split('T')[0]);
					console.log(isoDates);
					
					//이전에 있는 차트 먼저 지우기
					/* if(window.chart!=undefined){
						window.chart.destroy();
					} */
						
					//차트그리기
					chart();
					
					//시간형식 변환해야하는데...
					
					
					///차트가 겹쳐져서 그려진다.... 최근 5경기를 반드시 만드는수밖에...
					//	야구가 경기가 없는데, 야구 직전에 풋살 5경기 그래프를 봤다면
					//	야구를 눌러도 풋살 5경기 그래프가 뜬다..ㅎ
					
				 
				}, error : function(e){
					console.log(e.responseText);
				}
			});
		});
		
	});	
	
	
</script>
</html>