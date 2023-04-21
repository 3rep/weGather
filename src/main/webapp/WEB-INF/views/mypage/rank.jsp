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
			<textarea id="result"></textarea>
			
			<!-- 차트 그리기 script -->
			<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script>
			<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
			<script src="https://cdn.jsdelivr.net/npm/chart.js@2.8.0"></script>
			<script>
			
				//차트 그리기에서 필요한 데이터 ---------------
				var title;//차트제목
				var labels = ['January', 'February', 'March', 'April', 'May', 'June', 'July'];//라벨(x축)
				var rankData = [0, 10, 5, 2, 20, 30, 45]; //데이터(y축)
				var backgroundColor = 'rgba(255, 99, 132, 0.2)';
				var borderColor = 'rgb(255, 99, 132)';
				//------------------------------------- 
				//차트 그리기
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
			
			
			</script>
			
		</div> <!-- 오른쪽 내용칸 div -->
		
		
</div>	<!-- 왼쪽메뉴바와 오른쪽 본문 합친 div -->
</body>

</html>