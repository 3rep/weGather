package com.gather.we.service;

import com.gather.we.dto.ManagerDTO;

public interface ManagerService {
	//ȸ������
	public int managerInsert(ManagerDTO dto);
	public int dataDelete(String managerid);
	public ManagerDTO loginManOk(String managerid, String password);
	//���̵� �ߺ��˻� - ���̵��� ������ ���Ѵ�.
	public int idCheckCount(String managerid);
}
