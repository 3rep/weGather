package com.gather.we.service;

import com.gather.we.dto.ManagerDTO;

public interface ManagerService {
	//회원가입
	public int managerInsert(ManagerDTO dto);
	public int dataDelete(String managerid);
	public ManagerDTO loginManOk(String managerid, String password);
}
