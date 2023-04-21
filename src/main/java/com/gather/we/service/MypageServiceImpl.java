package com.gather.we.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.gather.we.dao.MypageDAO;
import com.gather.we.dto.MypageApplyListDTO;
import com.gather.we.dto.MypageRankDTO;
import com.gather.we.dto.MypageUserDTO;

@Service
public class MypageServiceImpl implements MypageService {
	
	@Inject
	MypageDAO dao;

	@Override
	public MypageUserDTO getUserinfo(String userid) {
	return dao.getUserinfo(userid);
	}
	
	@Override
	public String getUsername(String userid) {
		return dao.getUsername(userid);
	}
	
	@Override
	public List<MypageApplyListDTO> allgameList(String userid) {
		return dao.allgameList(userid);
	}
	
	@Override
	public List<MypageApplyListDTO> rankgameList(String userid) {
		return dao.rankgameList(userid);
	}

	@Override
	public List<MypageApplyListDTO> normgameList(String userid) {
		return dao.normgameList(userid);
	}

	@Override
	public List<MypageRankDTO> rank(String userid, String sportname) {
		return dao.rank(userid, sportname);
	}

	

	


	
}
