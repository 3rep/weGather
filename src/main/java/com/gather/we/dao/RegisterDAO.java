package com.gather.we.dao;

import java.util.List;

import com.gather.we.dto.RegisterDTO;

public interface RegisterDAO {
	//ȸ������
	public int registerInsert(RegisterDTO dto);
	//�߻�޼ҵ�
	public RegisterDTO loginOk(String userid, String password);
	//���̵� �ߺ��˻� - ���̵��� ������ ���Ѵ�.
	public int idCheckCount(String userid);
	public List<RegisterDTO> dataAllSelect();
	//ȸ������ ���� ��
	public RegisterDTO registerEdit(String userid);
	//ȸ������ ���� DB update
	public int registerEditOk(RegisterDTO dto);
}
