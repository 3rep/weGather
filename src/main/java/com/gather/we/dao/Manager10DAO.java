package com.gather.we.dao;

import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;

import com.gather.we.dto.Manager10DTO;
import com.gather.we.dto.ManagerPagingVO;




public interface Manager10DAO {
	 
	 public List<Manager10DTO> getAllManager10();
	 
	 public List<Manager10DTO> getAllManagerPast();
	 
	 public List<Manager10DTO> getAllManagerInput();
	 
	 public List<Manager10DTO> getAllEntry();
	  
	 public List<Manager10DTO> getAllManager10(String managerid);
	 
	 public List<Manager10DTO> getAllManagerInputByRank(String rank);
	 
	 public int totalRecord(ManagerPagingVO vo);
		//해당페이지 선택
   	 public List<Manager10DTO> pageSelect(ManagerPagingVO vo);
	 
	 public List<Manager10DTO> getAllManagerPast(String managerid);
	
	 public List<Manager10DTO> updateRank(String userid, int rank);

	
	}
