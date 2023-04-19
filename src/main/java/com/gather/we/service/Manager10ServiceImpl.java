package com.gather.we.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.gather.we.dao.Manager10DAO;
import com.gather.we.dto.Manager10DTO;
import com.gather.we.dto.PagingVO;

@Service
public class Manager10ServiceImpl implements Manager10Service {
	@Inject
	Manager10DAO dao;
	@Override
	public List<Manager10DTO> getAllManager10() {
		
		return dao.getAllManager10();
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
