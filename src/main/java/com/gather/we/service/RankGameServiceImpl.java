package com.gather.we.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.gather.we.dao.RankGameDAO;
import com.gather.we.dto.RankGameDTO;
import com.gather.we.dto.RankGameDetailDTO;
import com.gather.we.dto.RankGameListDTO;

@Service
public class RankGameServiceImpl implements RankGameService {
	@Inject
	RankGameDAO dao;

	@Override
	public int rankGameInsert(RankGameDTO dto) {
		return dao.rankGameInsert(dto);
	}

	@Override
	public List<RankGameDTO> rankGameListSelect(RankGameListDTO dto) {
		return dao.rankGameListSelect(dto);
	}

	@Override
	public RankGameDetailDTO rankGameDetailSelect(int no) {
		return dao.rankGameDetailSelect(no);
	}
}
