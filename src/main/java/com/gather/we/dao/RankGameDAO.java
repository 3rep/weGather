package com.gather.we.dao;

import java.util.List;

import com.gather.we.dto.RankGameDTO;
import com.gather.we.dto.RankGameDetailDTO;
import com.gather.we.dto.RankGameListDTO;

public interface RankGameDAO {
	// 랭크경기 등록
	public int rankGameInsert(RankGameDTO dto);
	// 랭크경기 목록 선택
	public List<RankGameDTO> rankGameListSelect(RankGameListDTO dto);
	// 랭크경기 세부정보 선택
	public RankGameDetailDTO rankGameDetailSelect(int no);
}
