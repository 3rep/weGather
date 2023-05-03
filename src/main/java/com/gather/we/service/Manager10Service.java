

package com.gather.we.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.jdbc.core.JdbcTemplate;

import com.gather.we.dto.Manager10DTO;
import com.gather.we.dto.ManagerPagingVO;


public interface Manager10Service {

	 public List<Manager10DTO> getAllManager10();
	
	 public List<Manager10DTO> getAllManagerPast();
	 
	 public List<Manager10DTO> getAllManagerInput(Integer no);
	
	 public List<Manager10DTO> getAllEntry(Integer no);
	 
	 public int getTotalRecordByManagerid(String managerid);
		//해당페이지 선택
	 public List<Manager10DTO> pageSelect(ManagerPagingVO vo);
	 
	 public List<Manager10DTO> getAllManager10By(String managerid);
	 
	 public List<Manager10DTO> getAllManagerInputByRank(String rank, Integer no);
	 
	 public List<Manager10DTO> getAllManagerInputByManagerid(String rank, Integer no);
	 
	 public List<Manager10DTO> getAllManagerPast(ManagerPagingVO vo);
	 
	 public List<Manager10DTO> getAllManagerPast(String managerid);

	

	public void deleteRankGame(String managerid, Integer no);

	public void updateRank(@Param("userid") String userid, @Param("rank") int rank, @Param("no") Integer no);

	
	 
	 
	 
	 
}
