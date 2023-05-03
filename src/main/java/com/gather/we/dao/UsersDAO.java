package com.gather.we.dao;

import com.gather.we.dto.UsersDTO;

public interface UsersDAO {
	// 경기 참가자 정보 선택
	public UsersDTO participantInfoSelect(String userid);
	// 사용자 정보 선택
	public UsersDTO userInfoInfoSelect(String userid);
}
