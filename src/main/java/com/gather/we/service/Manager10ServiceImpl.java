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
	public List<Manager10DTO> getAllManagerInputByRank(Integer rank, Integer no) {
		
		return dao.getAllManagerInputByRank(rank, no);
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
	public void updateRankGame(String managerid, Integer no) {
		
		 dao.updateRankGame(managerid, no);
		
	}

	@Override
	public void deleteMSettlement(String managerid, Integer no) {
		dao.deleteMSettlement(managerid, no);
		
	}
	

	@Override
	public void updateRank(String userid, Integer rank, Integer no) {
	 System.out.println(userid + "part" + Integer.valueOf(rank));
		dao.updateRank(userid, rank, no);
		
	}





	@Override
	public List<Manager10DTO> getAllManagerInputByManagerid(String rank, Integer no) {
		
		return dao.getAllManagerInputByManagerid(rank, no);
	}





//	@Override
//	public List<Manager10DTO> getAllManagerPast(ManagerPagingVO vo) {
		
//		return dao.getAllManagerPast(vo);
//	}





	@Override
	public List<Manager10DTO> getAllManagerPast(ManagerPagingVO vo) {
		
		return dao.getAllManagerPast(vo);
	}





	@Override
	public int getTotalRecordByManagerid10(String managerid) {
		
		return dao.getTotalRecordByManagerid10(managerid);
	}





	
	}





	

