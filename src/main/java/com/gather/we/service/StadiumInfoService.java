package com.gather.we.service;

import java.util.List;

import com.gather.we.dto.StadiumInfoDTO;

public interface StadiumInfoService {
	// 구장정보 전체선택
	public List<StadiumInfoDTO> stadiumInfoAllSelect();
}
