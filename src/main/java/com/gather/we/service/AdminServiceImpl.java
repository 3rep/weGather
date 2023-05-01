package com.gather.we.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gather.we.dao.AdminDAO;
import com.gather.we.dto.AdminDTO;
import com.gather.we.dto.ManagerSettlementDTO;
import com.gather.we.dto.UserPayDTO;

@Service
public class AdminServiceImpl implements AdminService {
	@Autowired
	AdminDAO dao;

	@Override
	public AdminDTO loginAdminOk(String adminid, String password) {
		// TODO Auto-generated method stub
		return dao.loginAdminOk(adminid, password);
	}

	@Override
	public List<UserPayDTO> revenue() {
	
		return dao.revenue();
	}

	@Override
	public List<UserPayDTO> expense() {
		// TODO Auto-generated method stub
		return dao.expense();
	}

	@Override
	public int waitOk(ManagerSettlementDTO dto) {
		// TODO Auto-generated method stub
		return dao.waitOk(dto);
	}

	
}
