<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<link rel="stylesheet" href="${path}/static/style/style.css" type="text/css"/>
<link rel="stylesheet" href="${path}/static/style/user/main.css" type="text/css"/>

	<!-- 메인화면 contents부분 -->
	<!-- 배경에 이미지(A) 깔고 
	그 위에 
		1. 로고 + 회원가입, 로그인 버튼?  있는 화면 : 백그라운드 연하게
			> 불투명 백그라운드(B) + 내용들어있는 div(C)
		2. 회원가입화면 바로 밑에 붙여서 소개 div(D)
	
		하나의 container에 넣어서 flex 적용시킨다.
		
		맨 뒤 바탕사진(A)은 스크롤할때 1씩 간다면,
		그 위에 1,2div는 5씩 이동해야함
	-->
	
<div class="container" id="main-container">
	<section id="container" class="section-main"> <!-- css우선순위: id가 css보다 우선적용 -->
		<!-- <div class="rank-visual" > -->
		
		<img class="img" src="static/img/imgMain/stadium.jpg" alt="football"/> 
		
		<div class="item" id="cloudy"> <!-- A -->
			<div class="login"> <!-- B -->
				<span>We Gather &emsp;</span><br/>
				<span>&emsp; Together </span><br/>
				<span id="featSpan">feat. sport</span><br/>
				<br/>
				<button class="button button--ujarak button--border-medium button--round-s button--text-upper" onclick="location.href='/userHome_unlogin'">시작하기</button>
				<!-- <button class="button button--ujarak button--border-medium button--round-s button--text-upper" onclick="location.href='login'">회원</button>
          		<button class="button button--ujarak button--border-medium button--round-s button--text-upper" onclick="location.href='loginMan'">매니저</button> -->
			</div>
		</div>
	</section>
	
	<!-- 사이트 소개 -->
	<section id="section-info">
		<div class="section-title">
			<img src="/static/img/imgMain/quoteLeft.png" style="width:50px; height:50px;"/>
			&emsp;&emsp; WE GATHER, JUST DO IT &emsp;&emsp;
			<img src="/static/img/imgMain/quoteRight.png" style="width:50px; height:50px;"/>
		</div>
		<div class="section-content">
			<div class="info-img">이미지</div>
			<div class="info">
				<div class="info-title-wrap">
					<span class="title">경기신청 버튼하나로 끝</span>
					<span class="desc">오직 경기신청만! 나머지는 wegather가 준비합니다.</span>
				</div>
				<div class="info-items">
					<div class="item-wrap left">
						<div class="info-item">
							<span class="title">인원모집 및 장소예약</span>
							<span class="desc">원하는 시간, 장소만 선택하세요.<br/>
												wegather에서 플레이어를 모으고<br/>
												경기장을 준비합니다. 
												 </span>
						</div>
						<div class="info-item">
							<span class="title">매니저 지원 서비스</span>
							<span class="desc">체계적인 시스템으로 경기를 매끄럽게 진행합니다.<br/>
												KFA, KBSA 등 협회에 등록된<br/>
												검증된 매니저가 함께 합니다.<br/>
												 </span>
						</div>
					</div>
					<div class="item-wrap right">
						<div class="info-item">
							<span class="title">랭크 시스템에 따른 팀 배정</span>
							<span class="desc">매니저가 실력에 맞게 팀을 나눠<br/>
												팽팽한 경기가 진행됩니다.<br/>
												긴장감 넘치는 경기를 즐겨보세요.</span>
						</div>
						<div class="info-item">
							<span class="title">맞춤형 스포츠 추천</span>
							<span class="desc">아직 즐기는 스포츠가 없는 당신을 위해!<br/>
												나에게 맞는 스포츠를 추천받아보세요.</span>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
	
	<!-- 경기 소개 -->
	<section id="section-game">
		<img src="" class="game-img" />
		<div class="game-wrap">
			<div class="game rank">
				<span class="title">
					<!-- <img src="/static/img/imgMain/arrowLeft.png" style="width:50px; height:50px;"/> -->
					랭크경기
				</span>
				<span class="desc">
				나는 아마추어 중에서 실력이 어느 정도일까?<br/>
				랭크 경기는 매니저 주관 하에 사용자 퍼포먼스에 맞춰<br/>
				랭크가 매겨지는 경기입니다.<br/>
				게임 후 나의 랭킹과 순위를 확인해보세요!
				</span>
				<a href="#">둘러보기????</a>
			</div>
			<div class="game norm">
				<span class="title">
					일반경기
					<!-- <img src="/static/img/imgMain/arrowRight.png" style="width:50px; height:50px;"/> -->
				</span>
				<span class="desc">
				랭크 경기 말고 자유롭게 스포츠를 즐기고 싶다면?<br/>
				일반 경기는 매니저 없이 사용자가 <br/>
				자유롭게 진행, 참여하는 경기입니다.<br/>
				원하는 시간, 장소에 원하는 사람들과 경기를 즐기세요!
				</span>
				<a href="#">둘러보기????</a>
			</div>
		</div>
		<img src="" class="game-img" />
	</section>
	
	<!-- 스포츠추천, 랭크보드 -->
	<section id="section-others">
		<div class="item-wrap">
			<img src="" class="item-img" />
			<div class="item">
				<span class="title">랭크보드</span>
				<span class="desc">
				나의 실력은 어느 정도일까?<br/>
				랭크보드는 랭크 경기를 참여한 사용자들의 평점과 랭크에 맞춰 순위를 나타냅니다.<br/>
				평점과 랭크는 누적된 평균 랭크 점수에 따라 부여됩니다.<br/>
				나의 순위와 랭크를 확인하고 다른 사용자들과 비교해보세요!<br/>
				</span>
				<a href="#">둘러보기?</a>
			</div>
		</div>
		<div class="item-wrap">
			<div class="item">
				<span class="title">스포츠추천</span>
				<span class="desc">
				나의 MBTI, 나이, 성별에 맞는 스포츠는 뭐가 있을까?<br/>
				MBTI, 나이, 성별 별로 사용자들이 참여하는 스포츠를 통계로 나타냅니다.<br/>
				나와 비슷한 사용자들이 좋아하는 스포츠를 확인하고 새로운 스포츠를 즐겨보세요!
				</span>
				<a href="#">둘러보기?</a>
			</div>
			<img src="" class="item-img" />
		</div>
	</section>
</div>		
		<!-- <div class="item" id="info"> -->
		
			
			<!-- <img class="infoImg" src="static/img/imgMain/info.png" alt="info"/> -->
			<!--  
			<div class="infoTxt">
				<span class="first">신청, 경기시작 </span><br/>
				<span class="second">We gather, Just do it!</span> 
				<div class="jb-division-line"></div>
				<div class="third">
					인원모집 및 예약 서비스 <br/>
					랭크 시스템<br/>
					매니저 지원 서비스<br/>
					맞춤형 스포츠 추천
				</div>
			</div>
		</div>
		-->

	
