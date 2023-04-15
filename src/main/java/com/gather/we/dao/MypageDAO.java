package com.gather.we.dao;

import com.gather.we.dto.MypageDTO;

public interface MypageDAO {
	//db에 등록된 사용자 정보 가져오기
	public MypageDTO getUserinfo(String userid);
	//username 프로필아래에 넣기
	public String getUsername(String userid);
}
