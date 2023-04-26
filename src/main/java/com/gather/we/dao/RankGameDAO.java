package com.gather.we.dao;

import java.util.List;

import com.gather.we.dto.AdminRankGameDTO;
import com.gather.we.dto.RankGameDTO;

public interface RankGameDAO {
	// 랭크게임 등록
	public int rankGameInsert(RankGameDTO dto);
	// 관리자 랭크게임 목록 전체선택
	public List<AdminRankGameDTO> adminRankGameAllSelect();
}
