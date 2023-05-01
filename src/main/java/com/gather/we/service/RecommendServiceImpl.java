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
	
	public List<RecommendDTO> sportStatisticsSelect(String mbtiType) {
		return dao.sportStatisticsSelect(mbtiType);
	}

	@Override
	public List<RecommendDTO> genderStatisticsSelect(String gender) {
		return dao.genderStatisticsSelect(gender);
	}

	@Override
	public String userMbtiSelect(String userid) {
		return dao.userMbtiSelect(userid);
	}

	@Override
	public List<RecommendDTO> ageStatisticsSelect(String age) {
		return dao.ageStatisticsSelect(age);
	}

}
