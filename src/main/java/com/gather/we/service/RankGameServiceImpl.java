package com.gather.we.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.gather.we.dao.RankGameDAO;
import com.gather.we.dto.RankGameDTO;

@Service
public class RankGameServiceImpl implements RankGameService {
	@Inject
	RankGameDAO dao;

	@Override
	public int rankGameInsert(RankGameDTO dto) {
		return dao.rankGameInsert(dto);
	}
}
