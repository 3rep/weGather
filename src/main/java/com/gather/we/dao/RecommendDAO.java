package com.gather.we.dao;

import java.util.List;



import com.gather.we.dto.RecommendDTO;


public interface RecommendDAO {

   public List<RecommendDTO> getAllRecommend(); // ��� ��� ���� ��ȸ
    
      
  // public List<HobbyDTO> getRecommendByAgeGenderAndMbti(int age, String gender, String mbti); // ����, ����, MBTI ������������ ��õ ��� ���� ��ȸ
    
  // public Object getHobbyStatistic(HobbyDTO hobbyDTO); // ��̿� ���� ��� ���� ��ȸ
}