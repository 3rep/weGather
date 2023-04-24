package com.gather.we.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.gather.we.dao.NormalGameDAO;

@Service
public class NormalGameServiceImpl implements NormalGameService {
	@Inject
	NormalGameDAO dao;
	
	
}
