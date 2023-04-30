package com.gather.we.service;

import java.util.List;

import com.gather.we.dto.RecommendDTO;

public interface RecommendService {
	// mbti유형의 스포츠 통계 선택
	public List<RecommendDTO> sportStatisticsSelect(String mbtiType);
	// 성별 스포츠 통계 선택
	public List<RecommendDTO> genderStatisticsSelect(String gender);
	// 사용자 mbti 선택
	public String userMbtiSelect(String userid);
}