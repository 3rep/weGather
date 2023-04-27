package com.gather.we.dao;

import com.gather.we.dto.ManagerDTO;

public interface ManagerDAO {
	//회원가입
	public int managerInsert(ManagerDTO dto);
	public int dataDelete(String managerid);
	public ManagerDTO loginManOk(String managerid, String password);
	//아이디 중복검사 - 아이디의 갯수를 구한다.
	public int idCheckCount(String managerid);
}
