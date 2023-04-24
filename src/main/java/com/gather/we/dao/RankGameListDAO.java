package com.gather.we.dao;

import java.util.List;

import com.gather.we.dto.Criteria;
import com.gather.we.dto.RankGameDTO;
import com.gather.we.dto.RankGameListDTO;

public interface RankGameListDAO {
	public List<RankGameListDTO> rankGameListAllSelect(); //랭크게임 리스트

	public int updateApply(RankGameDTO rankGameDTO) throws Exception; //랭크게임 신청
	
	public List<RankGameListDTO> getListWithPaging(Criteria criteria); //랭크게임 페이징
	
	public int getTotalCount(Criteria criteria);//전체 랭크게임 개수
}
