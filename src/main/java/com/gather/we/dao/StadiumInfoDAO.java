package com.gather.we.dao;

import java.util.List;

import com.gather.we.dto.StadiumInfoDTO;

public interface StadiumInfoDAO {
	// 구장정보 전체선택
	public List<StadiumInfoDTO> stadiumInfoAllSelect();
	// 구장정보 한개선택
	public StadiumInfoDTO stadiumInfoOneSelect(int st_no);
}
