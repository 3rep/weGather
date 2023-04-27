package com.gather.we.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gather.we.dao.ManagerRankGameListDAO;
import com.gather.we.dto.MRankGameListCriteria;
import com.gather.we.dto.ManagerRankGameDTO;
import com.gather.we.dto.ManagerRankGameListDTO;

@Service
public class ManagerRankGameListServiceImpl implements ManagerRankGameListService{
	@Autowired
	ManagerRankGameListDAO dao;
	
	
	@Override
	public List<ManagerRankGameListDTO> rankGameListAllSelect(MRankGameListCriteria criteria) {
		return dao.getListWithPaging(criteria);
	}

	@Override
	public int updateApply(ManagerRankGameDTO rankGameDTO) throws Exception {
		return dao.updateApply(rankGameDTO);
	}

	@Override
	public int getTotalCount(MRankGameListCriteria criteria) {
		return dao.getTotalCount(criteria);
	}

	

}
