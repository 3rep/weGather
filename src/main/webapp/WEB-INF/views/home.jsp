<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MainScreen</title>	
<link href="static/style/style.css" rel="stylesheet" type="text/css" />
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
<style>
	#demo{
		height: 600px;
		margin-bottom:70px;
		border : 5px solid blue;
		
	}}
	.carousel-caption p{
		/* position: absolute; */
		/* right: 500px;
		top: 500px; */
		/* font-size : 12px; */
	}
	
	/*슬라이드 아래쪽 스타일*/
	#bottomBox{ 
		width:100%;
		height: 1000px;
		border: 1px solid red;
		font-size: 35px;
		text-align: center;
		line-height: center;
		
	}
	
	#bottomContentMain li{
		float: left;
		margin : 10px;
		width: 30%;
		padding : 10px;
		background: #F6F6F6;
		border-radius: 40px;
		
	}
	#bottomContentMain img{
		width:100%; 
		height:300px
	}
	
	#bottomContentSub li{
		float : left;
		width: 47%;
		margin : 10px;
		padding : 10px;
		background: #F6F6F6;
		border-radius: 40px;
		
	}
	#bottomContentSub img{
		width:100%; 
		height:200px
	}
	
</style>
<script>
	//스크롤 내리며 아래 내용 나오게 할거야
	
</script>
</head>
<body>

	<container class="backView" style="height:900px; width:1200px; background:#ddd;">
		
		<!-- Carousel -->
		<div id="demo" class="carousel slide" data-bs-ride="carousel">
		
			<!-- Indicators/dots -->
			<div class="carousel-indicators">
				<button type="button" data-bs-target="#demo" data-bs-slide-to="0" class="active"></button>
				<button type="button" data-bs-target="#demo" data-bs-slide-to="1"></button>
				<button type="button" data-bs-target="#demo" data-bs-slide-to="2"></button>
			</div>
				
			<!-- The slideshow/carousel -->
			<div class="carousel-inner" >
				<div class="carousel-item active">
					<img src="static/img/fancy.jpg" alt="" class="d-block" style="height: 600px; width:100%" >
					<div class="carousel-caption" style="left:60%; top: 50px; width:400px; ">
					    <h2>스포츠</h2>
					    <p style="font-size:1.2em">
					    	모든 경기가 준비되어 있습니다.<br/>
					    	원하는 경기에 참여해보세요</p>
					</div>
				</div>
				<div class="carousel-item">
					<img src="static/img/together.jpg" alt="" class="d-block" style="height: 600px; width:100%" >
					<div class="carousel-caption" style="left:60%; top: 50px; width:400px">
						<h2>자유모임</h2>
						<p style="font-size:1.2em">
							자유롭게 모임을 개설하고 참여합니다.<br/>
							좋아하는 취미를 함께 할 친구를 찾아보아요 </p>
					</div> 
				</div>
				<div class="carousel-item">
					<img src="static/img/together2.jpg" alt="" class="d-block" style="height: 600px; width:100%" >
					<div class="carousel-caption" style="left:60%; bottom: 80px; width:400px">
						<h2>취미추천</h2>
						<p style="font-size:1.2em">
							아직도 취미를 못 정하신 당신을 위해!<br/>
							당신께 맞는 취미를 추천해드립니다.</p>
					</div>  
				</div>
			</div>
 		
			<!-- Left and right controls/icons -->
			<button class="carousel-control-prev" type="button" data-bs-target="#demo" data-bs-slide="prev">
			  <span class="carousel-control-prev-icon"></span>
			</button>
			<button class="carousel-control-next" type="button" data-bs-target="#demo" data-bs-slide="next">
			  <span class="carousel-control-next-icon"></span>
			</button>
			
		</div>
	
		<!-- 슬라이드 아래쪽 내용 -->
		<div class="container-fluid mt-3" id="bottomBox">
			<div id="bottomContentMain" style="background:yellow; height:400px; margin-bottom:100px;" >
				<ul >
					<li>
						<div >
							Contend for Victory
							<br/>
							<img src="static/img/colorpen.jpg" >
						</div> 
					</li>
					<li > 
						<div >
							Get Together
							<br/>
							<img src="static/img/handss.jpg" >
						</div>
					</li>
					<li > 
						<div >
							Let's Find Your Hobby 
							<br/>
							<img src="static/img/handss.jpg" >
						</div>
					</li>
				</ul>
			</div>
			
			<div id="bottomContentSub" style="background:green; height:400px">
				<ul >
					<li>
						<div >
							Check the Rank 
							<br/>
							<img src="static/img/handss.jpg" >
						</div>
					</li>
					<li>
						<div >
							Community 
							<br/>
							<img src="static/img/handss.jpg" >
						</div>
					</li>
								
				</ul>
			</div>
		</div>
		
	</div>
</body>
</html>
