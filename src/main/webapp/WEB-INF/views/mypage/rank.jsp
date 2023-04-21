<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!-- 오른쪽 내용칸 -->
		<div id="content"> 
			<h3>나의 랭크</h3>
			<hr/>
			예시본문<br/>
			
			<!-- BarChart넣기 -->
			<div class="container" style="width:100%">
				<canvas id="line_chart"></canvas>
			</div>
			
			<button id="chartBtn">그래프로 보기</button>
			
			<!-- 내용넘어오나 확인용 ---------------------->
			<div id="re" style="border:2px solid gray"></div>
			
			
			<!-- 차트 그리기 script -->
			<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script>
			<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
			<script src="https://cdn.jsdelivr.net/npm/chart.js@2.8.0"></script>
			<script>
			
			$(function(){
				//차트 그리기에서 필요한 데이터 ---------------
				var title;//차트제목
				var labels = new Array();//라벨(x축)
				var rankData = new Array(); //데이터(y축)
				var backgroundColor = 'rgba(255, 99, 132, 0.2)';
				var borderColor = 'rgb(255, 99, 132)';
				//------------------------------------- 
				//차트 그리기
				function chart(){
					var data = {
						labels: labels,
						datasets: [{
						    label: 'My First Dataset',
						    data: rankData,
						    fill: false,
						    borderColor: 'rgb(75, 192, 192)',
						    tension: 0.1
				 		 }]
					};
					var chart = new Chart(document.getElementById("line_chart"), {
					    type: 'line',
					    data: data,
					    option: {},
					});
				}
				
				//버튼누르면 ajax 실행
				$("#chartBtn").click(function(){ 
					event.preventDefault();
					
					$.ajax({
						type : "post",
						url : "rankMain",
						success : function(data){
						//데이터 넘어오나 확인
						console.log(data);
						$("#re").append(data);
						
						
						/////////////////////////////////////////
						
						 
						}, error : function(e){
							console.log(e.responseText);
						}
					});
				});
					 
			});	
				
				
			</script>
			
		</div> <!-- 오른쪽 내용칸 div -->
		
		
</div>	<!-- 왼쪽메뉴바와 오른쪽 본문 합친 div -->
</body>

</html>