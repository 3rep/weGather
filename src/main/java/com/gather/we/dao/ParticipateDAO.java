package com.gather.we.dao;

import com.gather.we.dto.NParticipateDTO;
import com.gather.we.dto.RParticipateDTO;

public interface ParticipateDAO {
	// 랭크경기 참여 등록
	public int rParticipateInsert(RParticipateDTO dto);
	// 일반경기 참여 등록
	public int nParticipateInsert(NParticipateDTO dto);
}
