package com.gather.we.service;

import com.gather.we.dto.UserPayDTO;
import com.gather.we.dto.UserPayDoneDTO;

public interface UserPayService {
	// 사용자 결제내역 등록
	public int userPayInsert(UserPayDTO dto);
	// 결제완료 정보 선택 - 랭크경기
	public UserPayDoneDTO rankPayDoneSelect(String payment_no);
}
