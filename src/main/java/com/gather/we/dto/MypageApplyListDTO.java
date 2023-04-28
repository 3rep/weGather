package com.gather.we.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MypageApplyListDTO {

	private String userid; //아이디 
	private int no; //경기일련번호
	private String sportname; //종목명
	private Date gametime; //경기날짜
	private String stadium; //구장명(경기명)
	private int g_status; //경기상태
	private Date gt2ago; //경기날짜 이틀전
	
	//날짜 필터링
	private String aplSelectedDate; //달력에서 선택한 값
	
	
	


	
	
}
