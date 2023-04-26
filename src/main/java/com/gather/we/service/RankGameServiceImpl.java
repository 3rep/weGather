package com.gather.we.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.gather.we.dao.RankGameDAO;
import com.gather.we.dto.AdminRankGameDTO;
import com.gather.we.dto.RankGameDTO;

@Service
public class RankGameServiceImpl implements RankGameService {
	@Inject
	RankGameDAO dao;

	@Override
	public int rankGameInsert(RankGameDTO dto) {
		return dao.rankGameInsert(dto);
	}

	@Override
	public List<AdminRankGameDTO> adminRankGameAllSelect() {
		return dao.adminRankGameAllSelect();
	}

	@Override
	public RankGameDTO rankGameOneSelect(int no) {
		return dao.rankGameOneSelect(no);
	}

	@Override
	public int rankGameUpdate(RankGameDTO dto) {
		return dao.rankGameUpdate(dto);
	}


}
