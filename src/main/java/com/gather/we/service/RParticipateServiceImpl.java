package com.gather.we.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.gather.we.dao.RParticipateDAO;
import com.gather.we.dto.RParticipateDTO;

@Service
public class RParticipateServiceImpl implements RParticipateService{
	@Inject
	RParticipateDAO dao;

	@Override
	public int rParticipateInsert(RParticipateDTO dto) {
		return dao.rParticipateInsert(dto);
	}
}
