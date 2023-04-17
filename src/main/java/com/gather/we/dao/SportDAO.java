package com.gather.we.dao;

import com.gather.we.dto.SportDTO;

public interface SportDAO {
	// 종목 등록
	public int sportInsert(SportDTO dto);
	// 종목 삭제
	public int sportDelete(int no);
}
