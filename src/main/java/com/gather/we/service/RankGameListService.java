package com.gather.we.service;

import java.util.List;
import java.util.Map;

import com.gather.we.dto.Criteria;
import com.gather.we.dto.RankGameDTO;
import com.gather.we.dto.RankGameListDTO;

public interface RankGameListService {
	public List<RankGameListDTO> rankGameListAllSelect(Criteria criteria);//랭크게임 리스트, 페이징

	public int updateApply(RankGameDTO rankGameDTO) throws Exception;//랭크게임 신청
	
	public int getTotalCount(Criteria criteria);
	
}
