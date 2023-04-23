package com.gather.we.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.gather.we.dao.ManagerPastDAO;
import com.gather.we.dto.Manager10DTO;
import com.gather.we.dto.ManagerPastDTO;
import com.gather.we.dto.PagingVO;


@Service
public class ManagerPastServiceImpl implements ManagerPastService {
	@Inject
	ManagerPastDAO dao;
	@Override
	public List<ManagerPastDTO> getAllManagerPast() {
		return dao.getAllManagerPast();
	}
	@Override
	public List<Manager10DTO> pageSelect(PagingVO vo) {
		
		return dao.pageSelect(vo);
	}
	@Override
	public int totalRecord(PagingVO vo) {
		
		return dao.totalRecord(vo);
	}

	
}
