package com.gather.we.service;

import org.springframework.stereotype.Service;

import com.gather.we.dao.MypageDAO;
import com.gather.we.dto.MypageDTO;

@Service
public interface MypageService {
	
	public String getUsername(String userid); 


}
