package com.gather.we.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.gather.we.dao.MypageDAO;
import com.gather.we.dto.MypageDTO;

@Service
public class MypageServiceImpl implements MypageService {
	
	@Inject
	MypageDAO dao;

	@Override
	public String getUsername(String userid) {
		return dao.getUsername(userid);
	}

	
}
