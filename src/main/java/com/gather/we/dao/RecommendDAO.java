package com.gather.we.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.gather.we.dto.RecommendDTO;


public interface RecommendDAO {

   public List<RecommendDTO> getAllRecommend(); // 모든 취미 정보 조회
    
      
  // public List<HobbyDTO> getRecommendByAgeGenderAndMbti(int age, String gender, String mbti); // 성별, 나이, MBTI 성격유형으로 추천 취미 정보 조회
    
  // public Object getHobbyStatistic(HobbyDTO hobbyDTO); // 취미에 대한 통계 정보 조회
}