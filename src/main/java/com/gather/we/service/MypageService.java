package com.gather.we.service;

import org.springframework.stereotype.Service;

import com.gather.we.dao.MypageDAO;
import com.gather.we.dto.MypageDTO;

@Service
public interface MypageService {
	//db에 등록된 사용자 정보 가져오기
	public MypageDTO getUserinfo(String userid);
	
	public String getUsername(String userid); 


}
