package com.gather.we.dao;

import java.util.List;

import com.gather.we.dto.Criteria;
import com.gather.we.dto.Manager10DTO;




public interface Manager10DAO {
	 
	 public List<Manager10DTO> getAllManager10();
	    
 public List<Manager10DTO> pageSelect(Criteria dto);
	 
	 public int totalRecord(Criteria dto);
	 
	 public List<Manager10DTO> getList(Criteria dto);
	 
	 public List<Manager10DTO> selectManager10ByManagerid(String managerid);
	 
	
	}
