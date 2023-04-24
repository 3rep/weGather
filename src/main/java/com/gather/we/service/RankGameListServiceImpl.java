package com.gather.we.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gather.we.dao.RankGameListDAO;
import com.gather.we.dto.Criteria;
import com.gather.we.dto.RankGameDTO;
import com.gather.we.dto.RankGameListDTO;

@Service
public class RankGameListServiceImpl implements RankGameListService{
	@Autowired
	RankGameListDAO dao;
	
	
	@Override
	public List<RankGameListDTO> rankGameListAllSelect(Criteria criteria) {
		return dao.getListWithPaging(criteria);
	}

	@Override
	public int updateApply(RankGameDTO rankGameDTO) throws Exception {
		return dao.updateApply(rankGameDTO);
	}

	@Override
	public int getTotalCount(Criteria criteria) {
		return dao.getTotalCount(criteria);
	}

	

}
