package com.gather.we.service;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.gather.we.dao.Manager10DAO;

import com.gather.we.dto.Manager10DTO;
import com.gather.we.dto.ManagerPagingVO;


@Service
public class Manager10ServiceImpl implements Manager10Service {
	@Inject
	Manager10DAO dao;
	@Override
	public List<Manager10DTO> getAllManager10() {
		
		return dao.getAllManager10();
	}
	
	
	


	@Override
	public List<Manager10DTO> getAllManager10By(String managerid) {
		
		return dao.getAllManager10(managerid);
	}


	@Override
	public List<Manager10DTO> getAllManagerPast(String managerid) {
		
		return dao.getAllManagerPast(managerid);
	}

	



	@Override
	public List<Manager10DTO> getAllManagerInputByRank(String rank) {
		
		return dao.getAllManagerInputByRank(rank);
	}



	


	@Override
	public List<Manager10DTO> getAllManagerPast() {
		// TODO Auto-generated method stub
		return dao.getAllManagerPast();
	}



	@Override
	public List<Manager10DTO> getAllManagerInput() {
		// TODO Auto-generated method stub
		return dao.getAllManagerInput();
	}



	@Override
	public List<Manager10DTO> getAllEntry() {
		// TODO Auto-generated method stub
		return dao.getAllEntry();
	}





	@Override
	public int totalRecord(ManagerPagingVO vo) {
		
		return dao.totalRecord(vo);
	}





	@Override
	public List<Manager10DTO> pageSelect(ManagerPagingVO vo) {
		
		return dao.pageSelect(vo);
	}





	@Override
	public List<Manager10DTO> updateRank(String userid, int rank) {
		
		return dao.updateRank(userid, rank);
	}





	





}

