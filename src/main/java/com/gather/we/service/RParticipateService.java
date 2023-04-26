package com.gather.we.service;

import com.gather.we.dto.RParticipateDTO;

public interface RParticipateService {
	// 랭크경기 참여 등록
	public int rParticipateInsert(RParticipateDTO dto);
}
