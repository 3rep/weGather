package com.gather.we.dao;

import com.gather.we.dto.RParticipateDTO;

public interface RParticipateDAO {
	// 랭크경기 참여 등록
	public int rParticipateInsert(RParticipateDTO dto);
}
