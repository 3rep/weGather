package com.gather.we.dao;

import java.util.List;

import com.gather.we.dto.RegisterDTO;

public interface RegisterDAO {
	//회원가입
	public int registerInsert(RegisterDTO dto);
	//추상메소드
	public RegisterDTO loginOk(String userid, String password);
	//아이디 중복검사 - 아이디의 갯수를 구한다.
	public int idCheckCount(String userid);
	public List<RegisterDTO> dataAllSelect();
	//회원정보 수정 폼
	public RegisterDTO registerEdit(String userid);
	//회원정보 수정 DB update
	public int registerEditOk(RegisterDTO dto);
}
