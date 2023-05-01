package com.gather.we.dao;

import java.util.List;

import com.gather.we.dto.RecommendDTO;

public interface RecommendDAO {
	// mbti유형의 스포츠 통계 선택
	public List<RecommendDTO> sportStatisticsSelect(String mbtiType);
	// 성별 스포츠 통계 선택
	public List<RecommendDTO> genderStatisticsSelect(String gender);
	// 사용자 mbti 선택
	public String userMbtiSelect(String userid);
	// 나이별 스포츠 통계 선택
	public List<RecommendDTO> ageStatisticsSelect(String age);
}
