package com.gather.we.service;

import com.gather.we.dto.RankGameDTO;

public interface RankGameService {
	// 랭크게임 등록
	public int rankGameInsert(RankGameDTO dto);
}
