package com.gather.we.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.gather.we.dao.Manager10DAO;
import com.gather.we.dto.Criteria;
import com.gather.we.dto.Manager10DTO;


@Service
public class Manager10ServiceImpl implements Manager10Service {
	@Inject
	Manager10DAO dao;
	@Override
	public List<Manager10DTO> getAllManager10() {
		
		return dao.getAllManager10();
	}
	
	
	
	@Override
	public List<Manager10DTO> pageSelect(Criteria dto) {
		
		return dao.pageSelect(dto);
	}
	@Override
	public int totalRecord(Criteria dto) {
		
		return dao.totalRecord(dto);
	}



	@Override
	public List<Manager10DTO> selectManager10ByManagerid(String managerid) {
		
		return dao.selectManager10ByManagerid(managerid);
	}



	@Override
	public List<Manager10DTO> getList(Criteria dto) {
		
		return dao.getList(dto);
	}

}
