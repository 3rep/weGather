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
				<button id="chartBtn" >그래프 보기</button>
			</form>
			
			<!-- BarChart넣기 -->
			<div id="chart" class="chart" style="width:100%">
				<canvas id="line_chart"></canvas>
			</div>
			
			<div id="result" style="width:100%; height:100px; border:1px solid gray">ㅇㅇ</div> <!-- 내용들어오나 확인하는 칸 -->
			
			
			
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
		var label; //차트내용의 제목
		var gametime = new Array();//라벨(x축)
		var newgt = new Array(); //유닉스 타임스탬프를 자바형식으로 변경
		var isoDates = new Array(); // 2023-01-01 형태로 변경

		var rank = new Array(); //데이터(y축)
		var backgroundColor = 'rgba(255, 99, 132, 0.2)';
		var borderColor = 'rgb(255, 99, 132)';
		var newgt = new Array();
		
		//----------------------------------------
		//차트 그리기
		function chart(){
			//차트data
			var data = {
				labels: isoDates, //x축
				datasets: [{
					label: label, //차트제목
				    data: rank, //y축
				    fill: false,
				    borderColor: borderColor,
				    tension: 0.1
				    
		 		 }]
			};
			//차트생성
			var chart = new Chart(document.getElementById("line_chart"), {
			    type: 'line',
			    data: data,
			    options: { 
			    	 scales: { 
			    		/*xAxes: [{ ticks: { display: false } }], //x축 없애기*/
			    		yAxes: [{	//y축설정
			                ticks: {
			                    max: 5,
			                    min: 0,
			                    stepSize: 1
			                }
			            }]
			    	},
			    	tooltips: { //툴팁 사이즈 키우기(기본 12)
		                titleFontSize: 15,
		                bodyFontSize: 15
		            } 
			    
			    }
			});
		}
		//차트 지우기
		/* function removeChart(){
			alert("경고");
			$("#line_chart").html("랭크결과가 없습니다.");
			$('#line_chart').append("append success!");
		} */
		
		//랭크명 생성
		/*function updateArray(myArray, oldValue, newValue) {	}
		function updateArray(myArray, oldValue, newValue) {
			  if (!myArray instanceof Array) return;

			  const index = myArray.indexOf(oldValue);
			  if (index !== -1) {
			    myArray[index] = newValue;
			  }
		} */
		function replaceArrayValues(arr1) {
			const [a, b, c, d, e] = [1, 2, 3, 4, 5];
			const mapObj = {
			  1: a,
			  2: b,
			  3: c,
			  4: d,
			  5: e,
			};
			
			const arr2 = arr1.map((num) => mapObj[num] || num);
			return arr2;
		}

			
		
		//버튼누르면 ajax 실행
		$("#chartBtn").click(function(){ 
			event.preventDefault();
			
			var value = (sportname.options[sportname.selectedIndex].value); //옵션의 value값 구하기
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
				type : 'POST',
				url : "rankMain",
				success : function(result){
					console.log("result->"+result);
					//$("#result").html(result);
					
					var jsonData = JSON.parse(result);
					//$("#result").html(jsonData); > 안나오네
					console.log(jsonData);
					
					jsonData.map(function(obj, i){
						gametime[i]=obj.gametime; //라벨(x축) : 기준날짜
						console.log("gametime[i]->"+gametime[i]);
						newgt[i] = new Date(gametime[i]);
						console.log("newgt->"+newgt);

						rank[i]=obj.rank; //데이터(y축)
						console.log("rank[i]->"+rank[i]);

						}) 

						isoDates = newgt.map(date=>date.toISOString().split('T')[0]);
						console.log(isoDates);
						
						//rank 숫자값을 랭크명으로 변경
						console.log(rank);
						
						/* updateArray(rank, 1, "브론즈");
						updateArray(rank, 2, "실버");
						updateArray(rank, 3, "골드");
						updateArray(rank, 4, "플래티넘");
						updateArray(rank, 5, "다이아"); */
						
						const arr1 = rank;
						const arr2 = replaceArrayValues(arr1);

						console.log("arr2222"+arr2); // [a, b, b, c, c, d, e, e]
						//console.log(rank);

					//기존 차트 지우기
					//chart.destroy();
					//removeChart();
					
					//차트 그리기
					chart();

				 
				}, error : function(e){
					console.log(e.responseText);
				}
			});
		});
		
	});	
	
	
</script>
</html>