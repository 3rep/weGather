package com.gather.we.service;

import java.util.List;

import com.gather.we.dto.RankGameDTO;
import com.gather.we.dto.RankGameListDTO;

public interface RankGameService {
	// 랭크경기 등록
	public int rankGameInsert(RankGameDTO dto);
	// 랭크경기 목록 선택
	public List<RankGameDTO> rankGameListSelect(RankGameListDTO dto);
}
