package com.gather.we.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.gather.we.dto.MypageApplyListDTO;
import com.gather.we.dto.MypagePaymentDTO;
import com.gather.we.dto.MypageRankDTO;
import com.gather.we.dto.MypageUserDTO;
import com.gather.we.dto.PagingVO;

@Service
public interface MypageService {
	//db에 등록된 사용자 1인의 정보 가져오기 --test용
	public MypageUserDTO getUserinfo(String userid);
	//username 프로필아래에 넣기
	public String getUsername(String userid); 
	
	//applyList 페이지에 필요한 메소드
	//모든 경기(랭크+일반)
	public List<MypageApplyListDTO> allgameList(PagingVO vo);
	//랭크+일반 총레코드수
	public int allTotalRecord(String userid);
	//랭크전
	public List<MypageApplyListDTO> rankgameList(PagingVO vo); 
	//랭킹 총레코드수
	public int rankTotalRecord(String userid);
	//일반전
	public List<MypageApplyListDTO> normgameList(PagingVO vo);
	//일반 총레코드수
	public int normTotalRecord(String userid);
	//rank 정보 가져오기
	public List<MypageRankDTO> rank(String userid, String sportname);
	//rank 결과요약 가져오기
	public List<MypageRankDTO> rankResult(String userid);
	
	//결제list
	public List<MypagePaymentDTO> paymentList(PagingVO vo);
	//결제 총레코드수
	public int paymentTotalRecord(String username);
	
	//회원정보수정(DB) 
	public int infoEdit(MypageUserDTO dto);

	//경기신청취소(DB)
	public int gameCancel(MypageApplyListDTO dto);
}
