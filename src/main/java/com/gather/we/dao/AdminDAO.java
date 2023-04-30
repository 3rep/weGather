package com.gather.we.dao;

import java.util.List;

import com.gather.we.dto.AdminDTO;

import com.gather.we.dto.UserPayDTO;

public interface AdminDAO {
	public AdminDTO loginAdminOk(String adminid, String password);
	//정산 수입내역
	public List<UserPayDTO> revenue();
	public List<UserPayDTO> expense();
}
