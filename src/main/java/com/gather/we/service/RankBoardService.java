package com.gather.we.service;

import java.util.List;

import com.gather.we.dto.RankBoardCriteria;
import com.gather.we.dto.RankBoardDTO;

public interface RankBoardService {

	public List<RankBoardDTO> getUserRankList(RankBoardCriteria criteria);
	
	public int getTotalCount(RankBoardCriteria criteria);
}
