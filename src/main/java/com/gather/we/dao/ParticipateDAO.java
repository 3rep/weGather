package com.gather.we.dao;

import com.gather.we.dto.NParticipateDTO;
import com.gather.we.dto.RParticipateDTO;

public interface ParticipateDAO {
	// 랭크경기 참여 등록
	public int rParticipateInsert(RParticipateDTO dto);
	// 일반경기 참여 등록
	public int nParticipateInsert(NParticipateDTO dto);
	// 일반경기 참가 여부 확인
	public int isNormParticipate(String userid, int no);
	// 랭크경기 참가 여부 확인
	public int isRankParticipate(String userid, int no);
}
