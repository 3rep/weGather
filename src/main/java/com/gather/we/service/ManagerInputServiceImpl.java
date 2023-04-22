package com.gather.we.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.gather.we.dao.ManagerInputDAO;
import com.gather.we.dto.ManagerInputDTO;

@Service
public class ManagerInputServiceImpl implements ManagerInputService {

	@Inject
	ManagerInputDAO dao;
	@Override
	public List<ManagerInputDTO> getAllManagerInput() {
		
		return dao.getAllManagerInput();
	}
	@Override
	public List<ManagerInputDTO> getAllManagerInputByRank(String rank) {
		
		return dao.getAllManagerInputByRank(rank);
	}

	
}
