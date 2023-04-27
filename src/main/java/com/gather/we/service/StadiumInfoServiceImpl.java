package com.gather.we.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.gather.we.dao.StadiumInfoDAO;
import com.gather.we.dto.StadiumInfoDTO;

@Service
public class StadiumInfoServiceImpl implements StadiumInfoService {
	@Inject
	StadiumInfoDAO dao;

	@Override
	public List<StadiumInfoDTO> stadiumInfoAllSelect() {
		return dao.stadiumInfoAllSelect();
	}

	@Override
	public StadiumInfoDTO stadiumInfoOneSelect(int st_no) {
		return dao.stadiumInfoOneSelect(st_no);
	}
	
}
