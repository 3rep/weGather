package com.gather.we.service;

import java.util.List;

import com.gather.we.dto.AdminDTO;
import com.gather.we.dto.ManagerSettlementDTO;
import com.gather.we.dto.UserPayDTO;

public interface AdminService {
	public AdminDTO loginAdminOk(String adminid, String password);
	//���� ���Գ���
	public List<UserPayDTO> revenue();
	public List<UserPayDTO> expense();
	public int waitOk(ManagerSettlementDTO dto);
}
