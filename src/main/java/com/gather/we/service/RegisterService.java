package com.gather.we.service;

import java.util.List;

import com.gather.we.dto.RegisterDTO;
public interface RegisterService {
	//�߻�޼ҵ�
	public RegisterDTO loginOk(String userid, String password);
	public int registerInsert(RegisterDTO dto);
	//���̵� �ߺ��˻� - ���̵��� ������ ���Ѵ�.
	public int idCheckCount(String userid);
	public List<RegisterDTO> dataAllSelect();
	//ȸ������ ���� ��
	public RegisterDTO registerEdit(String userid);
	//ȸ������ ���� DB update
	public int registerEditOk(RegisterDTO dto);
}
