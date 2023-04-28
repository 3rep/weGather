package com.gather.we.dao;

import java.util.List;

import com.gather.we.dto.MSettlementCriteria;
import com.gather.we.dto.ManagerSettlementDTO;

public interface ManagerSettlementDAO {
	
	public List<ManagerSettlementDTO> mSettlementAllSelect();//정산내역 목록
	
	public List<ManagerSettlementDTO> getListWithPaging(MSettlementCriteria mscriteria); //정산내역 페이징
	
	public int getTotalCount(MSettlementCriteria mscriteria);//전체 정산내역 개수
	
	public int selectCompletedAmount();//정산내역-완료 합계

	public int selectInprogressAmount();//정산내역-처리중 합계
}
