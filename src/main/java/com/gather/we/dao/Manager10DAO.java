package com.gather.we.dao;

import java.util.List;


import com.gather.we.dto.Manager10DTO;
import com.gather.we.dto.PagingVO;


public interface Manager10DAO {
	 
	 public List<Manager10DTO> getAllManager10();
	    
	 public List<Manager10DTO> pageSelect(PagingVO vo);
	 
	 public int totalRecord(PagingVO vo);
	}
