package com.gather.we.dao;

import java.util.List;

import com.gather.we.dto.MypageApplyListDTO;
import com.gather.we.dto.MypageUserDTO;

public interface MypageDAO {
	//db에 등록된 사용자 1인의 정보 가져오기 --test용
	public MypageUserDTO getUserinfo(String userid);
	//username 프로필아래에 넣기
	public String getUsername(String userid);
	
	//////applyList에 필요한 정보 가져오기 : 랭크전, 일반전
	//모든 경기(랭크+일반)
	public List<MypageApplyListDTO> allgameList(String userid);
	//랭크전
	public List<MypageApplyListDTO> rankgameList(String userid); 
	//일반전
	public List<MypageApplyListDTO> normgameList(String userid);

}
