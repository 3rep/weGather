package com.gather.we.dao;

import com.gather.we.dto.AdminDTO;

public interface AdminDAO {
	public AdminDTO loginAdminOk(String adminid, String password);
}
