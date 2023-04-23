package com.gather.we.service;

import java.util.List;

import com.gather.we.dto.Manager10DTO;
import com.gather.we.dto.ManagerPastDTO;
import com.gather.we.dto.PagingVO;

public interface ManagerPastService {

	
	public List<ManagerPastDTO> getAllManagerPast();
	
 public List<Manager10DTO> pageSelect(PagingVO vo);
	 
	 public int totalRecord(PagingVO vo);
}
