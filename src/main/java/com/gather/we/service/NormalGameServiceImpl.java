package com.gather.we.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.gather.we.dao.NormalGameDAO;
import com.gather.we.dto.NormGameDTO;
import com.gather.we.dto.NormGameDetailDTO;
import com.gather.we.dto.NormGameListDTO;

@Service
public class NormalGameServiceImpl implements NormalGameService {
	@Inject
	NormalGameDAO dao;

	@Override
	public List<NormGameDTO> normGameListSelect(NormGameListDTO dto) {
		return dao.normGameListSelect(dto);
	}

	@Override
	public NormGameDetailDTO normGameDetailSelect(int no) {
		return dao.normGameDetailSelect(no);
	}

	@Override
	public int currPeopleCount(int no) {
		return dao.currPeopleCount(no);
	}
}
