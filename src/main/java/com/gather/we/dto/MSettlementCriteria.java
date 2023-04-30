package com.gather.we.dto;

import lombok.Data;

@Data
public class MSettlementCriteria {
	
	private int pageNum; // 현재 페이지 - page
	private int amount; //한페이지에 표시되는 데이터 갯수 - perPageNum
	
	private String keyword;// 검색어
	private String datetime; //정산일자 정렬
	private String dStatusOrder; //지급상태 정렬
	private String logId;
	public MSettlementCriteria() {//생성자를 이용한 기본값셋팅
		this.pageNum = 1;
		this.amount = 10;//한페이지에 데이터 4개씩 출력
	}	
}
