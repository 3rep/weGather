

package com.gather.we.service;

import java.util.List;

import com.gather.we.dto.Criteria;
import com.gather.we.dto.Manager10DTO;


public interface Manager10Service {

	 public List<Manager10DTO> getAllManager10();
	 public List<Manager10DTO> getAllManagerPast();
	 public List<Manager10DTO> getAllManagerInput();
	 public List<Manager10DTO> getAllEntry();
	 public List<Manager10DTO> pageSelect(Criteria dto);
	 
	 public int totalRecord(Criteria dto);
	 
	 public List<Manager10DTO> getList(Criteria dto);
	 
	 public List<Manager10DTO> selectManager10ByManagerid(String managerid);
	 
	public List<Manager10DTO> getAllManagerInputByRank(String rank);
	 

	 
	 public List<Manager10DTO> selectManagerPastByManagerid(String managerid);

	
}
