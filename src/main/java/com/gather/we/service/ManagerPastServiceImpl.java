package com.gather.we.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.gather.we.dao.ManagerPastDAO;
import com.gather.we.dto.Criteria;
import com.gather.we.dto.ManagerPastDTO;
import com.gather.we.dto.PageDTO;



@Service
public class ManagerPastServiceImpl implements ManagerPastService {
	@Inject
	ManagerPastDAO dao;
	@Override
	public List<ManagerPastDTO> getAllManagerPast() {
		return dao.getAllManagerPast();
	}
	@Override
	public List<ManagerPastDTO> pageSelect(Criteria dto) {
		
		return dao.pageSelect(dto);
	}
	@Override
	public int totalRecord(Criteria dto) {
		
		return dao.totalRecord(dto);
	}
	@Override
	public List<ManagerPastDTO> selectManagerPastByManagerid(String managerid) {
		
		return dao.selectManagerPastByManagerid(managerid);
	}///////
	
	@Override
	public List<ManagerPastDTO> getList(Criteria dto) {
		// TODO Auto-generated method stub
		return dao.getList(dto);
	}
	

	
}
