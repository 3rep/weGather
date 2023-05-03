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
	public List<Manager10DTO> getAllManagerInputByRank(String rank, Integer no) {
		
		return dao.getAllManagerInputByRank(rank, no);
	}



	


	@Override
	public List<Manager10DTO> getAllManagerPast() {
		// TODO Auto-generated method stub
		return dao.getAllManagerPast();
	}



	@Override
	public List<Manager10DTO> getAllManagerInput(Integer no) {
		// TODO Auto-generated method stub
		return dao.getAllManagerInput(no);
	}



	@Override
	public List<Manager10DTO> getAllEntry(Integer no) {
		// TODO Auto-generated method stub
		return dao.getAllEntry(no);
	}





	





	@Override
	public List<Manager10DTO> pageSelect(ManagerPagingVO vo) {
		
		return dao.pageSelect(vo);
	}





	





	@Override
	public int getTotalRecordByManagerid(String managerid) {
		return dao.getTotalRecordByManagerid(managerid);
	}





	@Override
	public List<Manager10DTO> getAllManagerPast(ManagerPagingVO vo) {
		return dao.getAllManagerPast(vo);
	}





	@Override
	public void deleteRankGame(String managerid, Integer no) {
		
		 dao.deleteRankGame(managerid, no);
		
	}


	@Override
	public void updateRank(String userid, int rank, Integer no) {
	 System.out.println(userid + "part" + Integer.valueOf(rank));
		dao.updateRank(userid, rank, no);
		
	}





	@Override
	public List<Manager10DTO> getAllManagerInputByManagerid(String rank, Integer no) {
		
		return dao.getAllManagerInputByManagerid(rank, no);
	}












	





	





}

