package com.gather.we.dao;

import com.gather.we.dto.RankGameDTO;

public interface RankGameDAO {
	// 랭크게임 등록
	public int rankGameInsert(RankGameDTO dto);
}
