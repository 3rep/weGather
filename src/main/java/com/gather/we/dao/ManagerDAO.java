package com.gather.we.dao;

import com.gather.we.dto.ManagerDTO;

public interface ManagerDAO {
	//ȸ������
	public int managerInsert(ManagerDTO dto);
	public int dataDelete(String managerid);
	public ManagerDTO loginManOk(String managerid, String password);
}
