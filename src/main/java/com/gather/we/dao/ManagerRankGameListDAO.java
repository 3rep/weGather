package com.gather.we.dao;

import java.util.List;

import com.gather.we.dto.MRankGameListCriteria;
import com.gather.we.dto.ManagerRankGameDTO;
import com.gather.we.dto.ManagerRankGameListDTO;

public interface ManagerRankGameListDAO {
	public List<ManagerRankGameListDTO> rankGameListAllSelect(); //랭크게임 리스트

	public int updateApply(ManagerRankGameDTO rankGameDTO) throws Exception; //랭크게임 신청
	
	public List<ManagerRankGameListDTO> getListWithPaging(MRankGameListCriteria criteria); //랭크게임 페이징
	
	public int getTotalCount(MRankGameListCriteria criteria);//전체 랭크게임 개수
}
