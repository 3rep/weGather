<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

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
	<div class="recommend_content">
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
	<div class="recommend_content">
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
</div>