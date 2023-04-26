package com.gather.we.dao;

import java.util.List;

import com.gather.we.dto.SportDTO;

public interface SportDAO {
	public List<SportDTO> dataSelect();
	// 종목 등록
	public int sportInsert(SportDTO dto);
	// 종목 삭제
	public int sportDelete(int no);
	// 종목 전체선택
	public List<SportDTO> sportAllSelect();
}
