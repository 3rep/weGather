package com.gather.we.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gather.we.dao.AdminDAO;
import com.gather.we.dto.AdminDTO;

@Service
public class AdminServiceImpl implements AdminService {
	@Autowired
	AdminDAO dao;

	@Override
	public AdminDTO loginAdminOk(String adminid, String password) {
		// TODO Auto-generated method stub
		return dao.loginAdminOk(adminid, password);
	}
}
