package com.gather.we.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.gather.we.dao.MypageDAO;

@Service
public class MypageServiceImpl implements MypageService {
	
	@Inject
	MypageDAO dao;
}
