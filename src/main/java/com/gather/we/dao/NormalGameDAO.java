package com.gather.we.dao;

import java.util.List;

import com.gather.we.dto.NormGameDTO;
import com.gather.we.dto.NormGameDetailDTO;
import com.gather.we.dto.NormGameListDTO;

public interface NormalGameDAO {
	// 일반경기 목록 선택
	public List<NormGameDTO> normGameListSelect(NormGameListDTO dto);
	// 일반경기 세부정보 선택
	public NormGameDetailDTO normGameDetailSelect(int no);
}
