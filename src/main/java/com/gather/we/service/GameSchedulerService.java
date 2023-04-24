package com.gather.we.service;

import java.util.List;

import com.gather.we.dto.GameSchedulerDTO;

public interface GameSchedulerService {
	// 경기상태 업데이트가 필요한 경기 목록 선택
	public List<GameSchedulerDTO> statusUpdateListSelect();
	// 경기상태 업데이트
	public int statusUpdate(GameSchedulerDTO dto);
}
