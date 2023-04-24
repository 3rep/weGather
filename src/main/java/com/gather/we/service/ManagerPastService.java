package com.gather.we.service;

import java.util.List;

import com.gather.we.dto.Criteria;
import com.gather.we.dto.Manager10DTO;
import com.gather.we.dto.ManagerPastDTO;
import com.gather.we.dto.PageDTO;


public interface ManagerPastService {

	
	public List<ManagerPastDTO> getAllManagerPast();
	
 public List<ManagerPastDTO> pageSelect(Criteria dto);
	 
	 public int totalRecord(Criteria dto);
	 
	 public List<ManagerPastDTO> selectManagerPastByManagerid(String managerid);

	public List<ManagerPastDTO> getList(Criteria dto);
}
