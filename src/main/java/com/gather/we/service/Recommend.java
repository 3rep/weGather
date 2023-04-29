package com.gather.we.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.gather.we.dao.RecommendDAO;
import com.gather.we.dto.RecommendDTO;

@Service
public class Recommend implements RecommendService {

	@Inject
	RecommendDAO dao;
	
	public List<RecommendDTO> sportStatisticsSelect(String mbtiType) {
		return dao.sportStatisticsSelect(mbtiType);
	}

}
