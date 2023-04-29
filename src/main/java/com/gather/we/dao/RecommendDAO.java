package com.gather.we.dao;

import java.util.List;

import com.gather.we.dto.RecommendDTO;

public interface RecommendDAO {
	// mbti유형의 스포츠 통계 선택
	public List<RecommendDTO> sportStatisticsSelect(String mbtiType);
}
