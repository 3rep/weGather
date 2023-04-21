package com.gather.we.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.gather.we.dao.EntryDAO;
import com.gather.we.dto.EntryDTO;

@Service
public class EntryServiceImpl implements EntryService {
	@Inject
	EntryDAO dao;
		
	@Override
	public List<EntryDTO> getAllEntry() {
		
		return dao.getAllEntry();
	}
	
}