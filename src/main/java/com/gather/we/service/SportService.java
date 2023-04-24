package com.gather.we.service;

import java.util.List;

import com.gather.we.dto.SportDTO;

public interface SportService {

	public List<SportDTO> dataSelect();

	// 醫낅ぉ �벑濡�
	public int sportInsert(SportDTO dto);
	// 醫낅ぉ �궘�젣
	public int sportDelete(int no);
	// 醫낅ぉ �쟾泥댁꽑�깮
	public List<SportDTO> sportAllSelect();

}
