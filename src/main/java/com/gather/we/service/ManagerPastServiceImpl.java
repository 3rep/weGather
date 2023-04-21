package com.gather.we.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.gather.we.dao.ManagerPastDAO;
import com.gather.we.dto.ManagerPastDTO;


@Service
public class ManagerPastServiceImpl implements ManagerPastService {
	@Inject
	ManagerPastDAO dao;
	@Override
	public List<ManagerPastDTO> getAllManagerPast() {
		return dao.getAllManagerPast();
	}

	
}
