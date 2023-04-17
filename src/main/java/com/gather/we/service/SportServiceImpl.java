package com.gather.we.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.gather.we.dao.SportDAO;
import com.gather.we.dto.SportDTO;

@Service
public class SportServiceImpl implements SportService {
	@Inject
	SportDAO dao;

	@Override
	public int sportInsert(SportDTO dto) {
		return dao.sportInsert(dto);
	}

	@Override
	public int sportDelete(int no) {
		return dao.sportDelete(no);
	}
}
