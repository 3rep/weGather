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
				<button id="chartBtn" class="button btnBorder btnBlueGreen" >그래프 보기</button>
			</form>
			
			<!-- BarChart넣기 -->
			<div id="chart" class="chart" style="width:100%">
				<canvas id="line_chart"></canvas>
			</div>
			
			<div id="rankTotal">
				<div>풋살랭크: </div>
				<div>종합랭크: </div>
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
		var rankName = new Array(); //랭크변환 : 12345 > "브실골프다" 로 바꾸기
		
		var backgroundColor = 'rgba(255, 99, 132, 0.2)';
		var borderColor = 'rgb(255, 99, 132)';
		
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
			    		xAxes: [{ ticks: { display: false } }], //x축 없애기 -> 오른쪽 끝이 잘린다??*/
			    		yAxes: [{	//y축설정
			                ticks: {
			                    max: 5,
			                    min: 0,
			                    stepSize: 1,
			                    callback: function(value, index, values) {
			                        // y축 눈금 값을 브실골플다 로 변경
			                        var labels = ['', '브론즈', '실버', '골드', '플래티넘', '다이아'];
			                        return labels[value];
			                      }
			                }
			            }]
			    	},
			    	tooltips: { //툴팁 사이즈 키우기(기본 12)
		                titleFontSize: 15,
		                bodyFontSize: 15,
		                callbacks: {
		                    label: function(tooltipItem, data) {
		                      			//툴팁했을땐 날짜(x축)만 나오게
		                      			var label = data.labels[tooltipItem.dataIndex];
      								    return label;
		                  	}
		          		} 
			    
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
					//console.log("result->"+result);
					$("#result").html(result);
					
					var jsonData = JSON.parse(result);
					//$("#result").html(jsonData); > 안나오네
					console.log(jsonData);
					
					jsonData.map(function(obj, i){
						gametime[i]=obj.gametime; //라벨(x축) : 기준날짜
						console.log("gametime["+i+"]:: "+gametime[i]);
						
						newgt[i] = new Date(gametime[i]);
						console.log("newgt["+i+"]:: "+newgt); 
						//	newgt[]에 gametime[]를 담으니까 gametime[]에 들어가있는 애들이 다 나오는구나

						rank[i]=obj.rank; //데이터(y축)
						console.log("rank["+i+"]:: "+rank[i]);

					}) 

					isoDates = newgt.map(date=>date.toISOString().split('T')[0]);
					console.log(isoDates);
					
					//////////////////////////////////
					//rank 숫자값을 랭크명으로 변경
					console.log(rank);
					console.log(rank.length);
					
					// 새로운 배열 생성 및 값 할당
					for(var i=0; i<rank.length; i++) {
					    if(rank[i] == 1 ){
					    	rankName[i] = "브론즈"
					    } else if(rank[i] == 2){
					    	rankName[i] = "실버"
					    } else if(rank[i] == 3) {
					        rankName[i] = "골드";
					    } else if(rank[i] == 4) {
					        rankName[i] = "플래티넘";
					    } else if(rank[i] == 5) {
					        rankName[i] = "다이아";
					    }
					}
					console.log(rankName);

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
