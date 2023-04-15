package com.gather.we.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.gather.we.dao.RecommendDAO;
import com.gather.we.dto.RecommendDTO;

@Service
public class RecommendServiceImpl implements RecommendService {
	@Inject
	RecommendDAO dao;
	@Override
	public List<RecommendDTO> getAllRecommend() {
		
		return dao.getAllRecommend();
	}
				
	
	
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*
    @Autowired
   private RecommendDAO hobbyDAO;
   	

	@Override
	public List<RecommendDTO> getTopHobbyByAgeAndGenderAndMbti(int age, String gender, String mbti) {
		
		return getTopHobbyByAgeAndGenderAndMbti(age, gender,mbti);
	}

	@Override
	public List<RecommendDTO> getAllHobbies() {
		
		return getAllHobbies();
	}

	@Override
	public List<RecommendDTO> getRecommendedHobbies(RecommendDTO hobby) {
		return getRecommendedHobbies(hobby);
	}

	@Override
	public Object getHobbyStatistic(RecommendDTO hobbyDTO) {
		return getHobbyStatistic(hobbyDTO);
	}

*/
