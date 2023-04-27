package com.gather.we.service;

import java.util.List;

import com.gather.we.dto.NormGameDTO;
import com.gather.we.dto.NormGameDetailDTO;
import com.gather.we.dto.NormGameListDTO;

public interface NormalGameService {
	// 일반경기 목록 선택
	public List<NormGameDTO> normGameListSelect(NormGameListDTO dto);
	// 일반경기 세부정보 선택
	public NormGameDetailDTO normGameDetailSelect(int no);
	// 일반경기 현재인원수 업데이트
	public int currPeopleCount(int no);
}
