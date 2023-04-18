package com.gather.we.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.gather.we.dao.MypageDAO;
import com.gather.we.dto.MypageApplyListDTO;
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
	public List<MypageApplyListDTO> getSportName(String userid) {
		return dao.getSportName(userid);
	}

	@Override
	public List<MypageApplyListDTO> getRankgameInfo(String userid) {
		return dao.getRankgameInfo(userid);
	}

	@Override
	public List<MypageApplyListDTO> getStadium(String userid) {
		return dao.getStadium(userid);
	}

	
	

	
}
